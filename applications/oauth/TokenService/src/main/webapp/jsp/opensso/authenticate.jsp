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
<title>Authentication</title>
</head>
<body>

<h1 align="center">Authentication Results</h1>
<hr>

<%
  //String username = "demo";//request.getParameter("username");
  //String password = "demodemo";//request.getParameter("password");
  //String type = "rest"; //request.getParameter("auth");
  // String url = "http://localhost:8080/opensso/identity";//request.getParameter("url");
  // String token = null;
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  String type = request.getParameter("auth");
  String ourl = request.getParameter("url");
  String token = null;
  try {
    if (username == null || username.length() == 0 || password == null
      || password.length() == 0) {
      out.println("<h2>Invalid Username or Password</h2>");
      out.println("<br><br>Either user name or password is null.");
    }
    else
      if (type.equals("REST")) {
        String url = ourl;
        if (url == null || url.length() == 0) {
          out.println("<h2>Invalid URL: </h2>" + url);
        }
        else {
          url += "/authenticate";
          java.net.URL iurl = new java.net.URL(url);
          java.net.URLConnection connection = iurl.openConnection();
          connection.setDoInput(true);
          connection.setDoOutput(true);
          connection.setUseCaches(false);
          connection.setRequestProperty("Content-Type",
            "application/x-www-form-urlencoded");
          // Send POST output.
          java.io.DataOutputStream printout =
            new java.io.DataOutputStream(connection.getOutputStream());
          String content =
            "username=" + java.net.URLEncoder.encode(username)
              + "&password=" + java.net.URLEncoder.encode(password);
          printout.writeBytes(content);
          printout.flush();
          printout.close();
          java.io.BufferedReader reader =
            new java.io.BufferedReader(new java.io.InputStreamReader(
              (java.io.InputStream) connection.getContent()));
          out.println("<h2>Successful Authentication using REST</h2>");
          String line;
          while ((line = reader.readLine()) != null) {
            out.println(line + "<br>");
            int index = line.indexOf("token");
            if (index != -1) {
              token = line.substring(9);
            }
          }
        }
      }
  }
  catch (Exception e) {
    try {
      e.printStackTrace(new java.io.PrintWriter(out));
    }
    catch (Exception ex) {
      // Ignore
    }
  }
  if (token != null) {
%>
<hr>
<br>
<h2>Obtain Profile Attributes</h2>
<form name="profile" action="./profile.jsp" method="POST"><input
	type="hidden" name="token" value=<%=token%> /> Profile using Web
Service (SOAP/WSDL) <input type="submit" value="WS" name="auth" /><br>
<br>
Profile using REST <input type="submit" value="REST" name="auth" /><br>
<input type="hidden" name="url" value=<%=ourl%> /></form>
<hr>
<br>
<h2>Obtain Authorization Decision</h2>
<form name="authorization" action="/TokenService/jsp/opensso/authorization.jsp" method="POST">
<input type="hidden" name="token" value=<%=token%> /> Resource (URL)
<input type="text" name="resource"
	value="http://localhost:10001/StockService" size="30" /> <br>
Action <select name="action">
	<option>GET</option>
	<option>POST</option>
</select><br>
<br>
Authorize using Web Service (SOAP/WSDL) <input type="submit" value="WS"
	name="auth" /><br>
<br>
Authorize using REST <input type="submit" value="REST" name="auth" /><br>
<input type="hidden" name="url" value=<%=ourl%> /></form>

<hr>
<h3><a href="index1.jsp">Return To Login</a></h3>
<%
  }
%>
<hr />
</body>
</html>