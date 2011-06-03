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
        <title>Profile</title>
    </head>
    <body>

    <h1 align="center">Profile Results</h1><hr>
    <br>
    <%
        String type = request.getParameter("auth");
        String url = request.getParameter("url");
        String token = request.getParameter("token");
        try {
            if (type.equals("REST")) {
                if (url == null || url.length() == 0) {
                    out.println("<h2>Invalid URL: </h2>" + url);
                } else {
                    token = java.net.URLEncoder.encode(token, "UTF-8");
                    url += "/attributes?subjectid=" + token;
                    java.net.URL iurl = new java.net.URL(url);
                    java.net.URLConnection connection = iurl.openConnection();
                    java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(
                        (java.io.InputStream) connection.getContent()));
                    out.println("<h2>Successful using REST</h2>");
                    String line;
                    while ((line = reader.readLine()) != null) {
                        out.println(line + "<br>");
                    }
                }
            }
        } catch (Exception e) {
            try {
                e.printStackTrace(new java.io.PrintWriter(out));
            } catch (Exception ex) {
                // Ignore
            }
        }
    %>
    <br><br>
    <hr>
        <h3><a href="/TokenService/jsp/opensso/index1.jsp">Return To Login</a></h3>
    </body>
    
</html>
