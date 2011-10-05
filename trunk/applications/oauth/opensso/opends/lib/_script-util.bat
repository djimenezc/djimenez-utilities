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
rem      Copyright 2008-2010 Sun Microsystems, Inc.

set SET_JAVA_HOME_AND_ARGS_DONE=false
set SET_ENVIRONMENT_VARS_DONE=false
set SET_CLASSPATH_DONE=false

if "%INSTALL_ROOT%" == "" goto setInstanceRoot

:scriptBegin
if "%SCRIPT_UTIL_CMD%" == "set-full-environment-and-test-java" goto setFullEnvironmentAndTestJava
if "%SCRIPT_UTIL_CMD%" == "set-full-environment" goto setFullEnvironment
if "%SCRIPT_UTIL_CMD%" == "set-java-home-and-args" goto setJavaHomeAndArgs
if "%SCRIPT_UTIL_CMD%" == "set_environment_vars" goto setEnvironmentVars
if "%SCRIPT_UTIL_CMD%" == "test-java" goto testJava
if "%SCRIPT_UTIL_CMD%" == "set-classpath" goto setClassPath
goto prepareCheck

:setInstanceRoot
setlocal
for %%i in (%~sf0) do set DIR_HOME=%%~dPsi..
set INSTALL_ROOT=%DIR_HOME%
set INSTANCE_DIR=
for /f "delims=" %%a in (%INSTALL_ROOT%\instance.loc) do (
  set INSTANCE_DIR=%%a
)
set CUR_DIR=%~dp0
cd /d %INSTALL_ROOT%
cd /d %INSTANCE_DIR%
set INSTANCE_ROOT=%CD%
cd /d %CUR_DIR%
goto scriptBegin


:setClassPath
if "%SET_CLASSPATH_DONE%" == "true" goto prepareCheck
FOR %%x in ("%INSTALL_ROOT%\lib\*.jar") DO call "%INSTALL_ROOT%\lib\setcp.bat" %%x
if "%INSTALL_ROOT%" == "%INSTANCE_ROOT%"goto setClassPathDone
FOR %%x in ("%INSTANCE_ROOT%\lib\*.jar") DO call "%INSTANCE_ROOT%\lib\setcp.bat" %%x
FOR %%x in ("%INSTALL_ROOT%\resources\*.jar") DO call "%INSTALL_ROOT%\lib\setcp.bat" %%x
set CLASSPATH=%INSTANCE_ROOT%\classes;%CLASSPATH%
:setClassPathDone
set SET_CLASSPATH_DONE=true
goto scriptBegin

:setFullEnvironment
if "%SET_JAVA_HOME_AND_ARGS_DONE%" == "false" goto setJavaHomeAndArgs
if "%SET_CLASSPATH_DONE%" == "false" goto setClassPath
if "%SET_ENVIRONMENT_VARS_DONE%" == "false" goto setEnvironmentVars
goto prepareCheck

:setFullEnvironmentAndTestJava
if "%SET_JAVA_HOME_AND_ARGS_DONE%" == "false" goto setJavaHomeAndArgs
if "%SET_CLASSPATH_DONE%" == "false" goto setClassPath
if "%SET_ENVIRONMENT_VARS_DONE%" == "false" goto setEnvironmentVars
goto testJava


:setJavaHomeAndArgs
if "%SET_JAVA_HOME_AND_ARGS_DONE%" == "true" goto prepareCheck
if not exist "%INSTANCE_ROOT%\lib\set-java-home.bat" goto checkEnvJavaHome
call "%INSTANCE_ROOT%\lib\set-java-home.bat"
if "%OPENDS_JAVA_BIN%" == "" goto checkEnvJavaHome
:endJavaHomeAndArgs
set SET_JAVA_HOME_AND_ARGS_DONE=true
goto scriptBegin

:checkEnvJavaHome
if "%OPENDS_JAVA_BIN%" == "" goto checkOpenDSJavaHome
if not exist "%OPENDS_JAVA_BIN%" goto checkOpenDSJavaHome
goto endJavaHomeAndArgs

:checkOpenDSJavaHome
if "%OPENDS_JAVA_HOME%" == "" goto checkJavaPath
if not exist "%OPENDS_JAVA_HOME%\bin\java.exe" goto checkJavaPath
set OPENDS_JAVA_BIN=%OPENDS_JAVA_HOME%\bin\java.exe
goto endJavaHomeAndArgs

:checkJavaPath
java.exe -version > NUL 2>&1
if not %errorlevel% == 0 goto checkJavaBin
set OPENDS_JAVA_BIN=java.exe
goto endJavaHomeAndArgs

:checkJavaBin
if "%JAVA_BIN%" == "" goto checkJavaHome
if not exist "%JAVA_BIN%" goto checkJavaHome
set OPENDS_JAVA_BIN=%JAVA_BIN%
goto endJavaHomeAndArgs

:checkJavaHome
if "%JAVA_HOME%" == "" goto noJavaFound
if not exist "%JAVA_HOME%\bin\java.exe" goto noJavaFound
set OPENDS_JAVA_BIN=%JAVA_HOME%\bin\java.exe
goto endJavaHomeAndArgs

:noJavaFound
echo ERROR:  Could not find a valid Java binary to be used.
echo You must specify the path to a valid Java 5.0 or higher version.
echo The procedure to follow is:
echo 1. Delete the file %INSTANCE_ROOT%\lib\set-java-home.bat if it exists.
echo 2. Set the environment variable OPENDS_JAVA_HOME to the root of a valid
echo Java 5.0 installation.
echo If you want to have specific Java settings for each command line you must
echo follow the steps 3 and 4.
echo 3. Edit the properties file specifying the Java binary and the Java arguments
echo for each command line.  The Java properties file is located in:
echo %INSTANCE_ROOT%\config\java.properties.
echo 4. Run the command-line %INSTALL_ROOT%\bat\dsjavaproperties.bat
pause
exit /B 1

:setEnvironmentVars
if %SET_ENVIRONMENT_VARS_DONE% == "true" goto prepareCheck
set PATH=%SystemRoot%;%PATH%
set SCRIPT_NAME_ARG=-Dorg.opends.server.scriptName=%SCRIPT_NAME%
set SET_ENVIRONMENT_VARS_DONE=true
goto scriptBegin

:testJava
"%OPENDS_JAVA_BIN%" %OPENDS_JAVA_ARGS% org.opends.server.tools.InstallDS -t > NUL 2>&1
set RESULT_CODE=%errorlevel%
if %RESULT_CODE% == 13 goto notSupportedJavaHome
if not %RESULT_CODE% == 0 goto noValidJavaHome
goto prepareCheck

:noValidJavaHome
if NOT "%OPENDS_JAVA_ARGS%" == "" goto noValidHomeWithArgs
echo ERROR:  The detected Java version could not be used.  The detected
echo Java binary is:
echo %OPENDS_JAVA_BIN%
echo You must specify the path to a valid Java 5.0 or higher version.
echo The procedure to follow is:
echo 1. Delete the file %INSTANCE_ROOT%\lib\set-java-home.bat if it exists.
echo 2. Set the environment variable OPENDS_JAVA_HOME to the root of a valid
echo Java 5.0 installation.
echo If you want to have specific Java settings for each command line you must
echo follow the steps 3 and 4.
echo 3. Edit the properties file specifying the Java binary and the Java arguments
echo for each command line.  The Java properties file is located in:
echo %INSTANCE_ROOT%\config\java.properties.
echo 4. Run the command-line %INSTALL_ROOT%\bat\dsjavaproperties.bat
pause
exit /B 1

:notSupportedJavaHome
rem We get here when the java version is 5 (or up) but not supported.  We run
rem InstallDS again to see a localized message.
"%OPENDS_JAVA_BIN%" %OPENDS_JAVA_ARGS% org.opends.server.tools.InstallDS -t
pause
exit /B 1

:noValidHomeWithArgs
echo ERROR:  The detected Java version could not be used with the set of Java
echo arguments %OPENDS_JAVA_ARGS%.
echo The detected Java binary is:
echo %OPENDS_JAVA_BIN%
echo You must specify the path to a valid Java 5.0 or higher version.
echo The procedure to follow is:
echo 1. Delete the file %INSTANCE_ROOT%\lib\set-java-home.bat if it exists.
echo 2. Set the environment variable OPENDS_JAVA_HOME to the root of a valid
echo Java 5.0 installation.
echo If you want to have specific Java settings for each command line you must
echo follow the steps 3 and 4.
echo 3. Edit the properties file specifying the Java binary and the Java arguments
echo for each command line.  The Java properties file is located in:
echo %INSTANCE_ROOT%\config\java.properties.
echo 4. Run the command-line %INSTALL_ROOT%\bat\dsjavaproperties.bat
pause
exit /B 1

:isVersionOrHelp
if [%1] == [] goto check
if [%1] == [--help] goto end
if [%1] == [-H] goto end
if [%1] == [--version] goto end
if [%1] == [-V] goto end
if [%1] == [--fullversion] goto end
if [%1] == [-F] goto end
shift
goto isVersionOrHelp

:prepareCheck
rem Perform check unless it is specified not to do it
if "%NO_CHECK%" == ""  set NO_CHECK=false
goto isVersionOrHelp

:check
if "%NO_CHECK%" == "true" goto end
if "%CHECK_VERSION%" == "true" set OPT_CHECK_VERSION=--checkVersion
"%OPENDS_JAVA_BIN%" %SCRIPT_NAME_ARG% -DINSTALL_ROOT="%INSTALL_ROOT%" -DINSTANCE_ROOT="%INSTANCE_ROOT%" org.opends.server.tools.configurator.CheckInstance %OPT_CHECK_VERSION%
set RESULT_CODE=%errorlevel%
if "%RESULT_CODE%" == "0" goto end
exit /B 1

:end
exit /B 0
