
@echo off
rem CDDL HEADER START
rem
rem The contents of this file are subject to the terms of the
rem Common Development and Distribution License, Version 1.0 only
rem (the "License").  You may not use this file except in compliance
rem with the License.
rem
rem You can obtain a copy of the license at
rem trunk/opends/resource/legal-notices/OpenDS.LICENSE
rem or https://OpenDS.dev.java.net/OpenDS.LICENSE.
rem See the License for the specific language governing permissions
rem and limitations under the License.
rem
rem When distributing Covered Code, include this CDDL HEADER in each
rem file and include the License file at
rem trunk/opends/resource/legal-notices/OpenDS.LICENSE.  If applicable,
rem add the following below this CDDL HEADER, with the fields enclosed
rem by brackets "[]" replaced with your own identifying information:
rem      Portions Copyright [yyyy] [name of copyright owner]
rem
rem CDDL HEADER END
rem
rem
rem      Copyright 2006-2009 Sun Microsystems, Inc.

setlocal

set PATH=%SystemRoot%

set OPENDS_INVOKE_CLASS="org.opends.server.tools.StopDS"
set SCRIPT_NAME=stop-ds
for %%i in (%~sf0) do set DIR_HOME=%%~dPsi..

rem We keep this values to reset the environment before calling start-ds.
set ORIGINAL_JAVA_ARGS=%OPENDS_JAVA_ARGS%
set ORIGINAL_JAVA_HOME=%OPENDS_JAVA_HOME%
set ORIGINAL_JAVA_BIN=%OPENDS_JAVA_BIN%

set INSTALL_ROOT=%DIR_HOME%

set INSTANCE_DIR=
for /f "delims=" %%a in (%INSTALL_ROOT%\instance.loc) do (
  set INSTANCE_DIR=%%a
)
set CUR_DIR=%~dp0
cd /d%INSTALL_ROOT%
cd /d%INSTANCE_DIR%
set INSTANCE_ROOT=%CD%
cd /d%CUR_DIR%

set LOG="%INSTANCE_ROOT%\logs\native-windows.out"
set SCRIPT=stop-ds.bat

rem This is the template to use for logging.  Make sure to use >>
rem echo %SCRIPT%: your-message-here >> %LOG%
echo %SCRIPT%: invoked >> %LOG%

rem Set environment variables
set SCRIPT_UTIL_CMD=set-full-environment-and-test-java
call "%INSTALL_ROOT%\lib\_script-util.bat" %*
if NOT %errorlevel% == 0 exit /B %errorlevel%

echo %SCRIPT%: CLASSPATH=%CLASSPATH% >> %LOG%

"%OPENDS_JAVA_BIN%" %OPENDS_JAVA_ARGS% %SCRIPT_NAME_ARG%  org.opends.server.tools.StopDS --checkStoppability %*

if %errorlevel% == 98 goto serverAlreadyStopped
if %errorlevel% == 99 goto startUsingSystemCall
if %errorlevel% == 100 goto stopUsingSystemCall
if %errorlevel% == 101 goto restartUsingSystemCall
if %errorlevel% == 102 goto stopUsingProtocol
if %errorlevel% == 103 goto stopAsWindowsService
if %errorlevel% == 104 goto restartAsWindowsService
rem An error or we display usage
goto end

:serverAlreadyStopped
echo %SCRIPT%: server already stopped >> %LOG%
if exist "%INSTANCE_ROOT%\logs\server.pid" erase "%INSTANCE_ROOT%\logs\server.pid"
goto end

:startUsingSystemCall
echo %SCRIPT%: start using system call >> %LOG%
rem Set the original values that the user had on the environment in order to be
rem sure that the start-ds script works with the proper arguments (in particular
rem if the user specified not to overwrite the environment).
set OPENDS_JAVA_ARGS=%ORIGINAL_JAVA_ARGS%
set OPENDS_JAVA_HOME=%ORIGINAL_JAVA_HOME%
set OPENDS_JAVA_BIN=%ORIGINAL_JAVA_BIN%
"%INSTALL_ROOT%\bat\start-ds.bat"
goto end

:stopUsingSystemCall
echo %SCRIPT%: stop using system call >> %LOG%
"%INSTALL_ROOT%\lib\winlauncher.exe" stop "%INSTANCE_ROOT%"
goto end

:restartUsingSystemCall
echo %SCRIPT%: restart using system call >> %LOG%
"%INSTALL_ROOT%\lib\winlauncher.exe" stop "%INSTANCE_ROOT%"
if not %errorlevel% == 0 goto end
goto startUsingSystemCall

:stopUsingProtocol
echo %SCRIPT%: stop using protocol >> %LOG%
call "%INSTALL_ROOT%\lib\_client-script.bat" %*
goto end

:stopAsWindowsService
echo %SCRIPT%: stop as windows service >> %LOG%
"%OPENDS_JAVA_BIN%" -client org.opends.server.tools.StopWindowsService
goto end

:restartAsWindowsService
echo %SCRIPT%: restart as windows service, stopping >> %LOG%
"%OPENDS_JAVA_BIN%" -client org.opends.server.tools.StopWindowsService
if not %errorlevel% == 0 goto end
echo %SCRIPT%: restart as windows service, starting >> %LOG%
"%OPENDS_JAVA_BIN%" -client org.opends.server.tools.StartWindowsService
"%OPENDS_JAVA_BIN%" -client org.opends.server.tools.WaitForFileDelete --targetFile "%INSTANCE_ROOT%\logs\server.startingservice"
rem Type the contents the winwervice.out file and delete it.
if exist "%INSTANCE_ROOT%\logs\winservice.out" type "%INSTANCE_ROOT%\logs\winservice.out"
if exist "%INSTANCE_ROOT%\logs\winservice.out" erase "%INSTANCE_ROOT%\logs\winservice.out"
goto end

:end

echo %SCRIPT%: finished >> %LOG%
