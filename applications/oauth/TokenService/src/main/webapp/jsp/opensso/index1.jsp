<!--
/**
  * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
  *
  * Redistribution and use in source and binary forms, with or without
  * modification, are permitted provided that the following conditions
  * are met:
  *
  * - Redistributions of source code must retain the above copyright
  *   notice, this list of conditions and the following disclaimer.
  *
  * - Redistribution in binary form must reproduce the above copyright
  *   notice, this list of conditions and the following disclaimer in
  *   the documentation and/or other materials provided with the
  *   distribution.
  *
  * Neither the name of Sun Microsystems, Inc. or the names of
  * contributors may be used to endorse or promote products derived
  * from this software without specific prior written permission.
  *
  * This software is provided "AS IS," without a warranty of any
  * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
  * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
  * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
  * EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY
  * DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
  * DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN
  * OR ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA,
  * OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR
  * PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF
  * LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE SOFTWARE,
  * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
  *
  * You acknowledge that Software is not designed, licensed or
  * intended for use in the design, construction, operation or
  * maintenance of any nuclear facility.
  */ 
-->
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Identity Services Client</title>
    </head>
    <body>

    <h1 align="center">Identity Services Client</h1><hr>
    <br><br>
    <form name="authn" action="/TokenService/jsp/opensso/authenticate.jsp" method="POST">
    
        Username: <input type="text" name="username" value="demo" size="25" /><br><br>
        Password: <input type="password" name="password" value="demodemo" size="25" /><br><br><br>
    
        Authenticate using Web Service (SOAP/WSDL) <input type="submit" value="WS" name="auth" /><br><br>
        Authenticate using REST <input type="submit" value="REST" name="auth" /><br>
        Enter REST URL: <input type="text" name="url" value="http://localhost:8080/opensso/identity" size="100" />
    </form>
    <br><br><hr>
    </body>
</html>
