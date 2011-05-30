<%-- 
    Document   : layout
    Created on : 09-dic-2010, 15:12:53
    Author     : rafael
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html:html lang="true">
<head>
<html:base />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<title><bean:message key="app.title" /></title>
<link rel="stylesheet" type="text/css" href="../../css/datePicker.css" />
<link rel="stylesheet" type="text/css" href="../../css/comun.css" />
<link rel="shortcut icon" href="../../images/favicon.ico">
<!--[if IE]>
      <link rel="stylesheet" type="text/css" href="../../css/comun_ie.css" media="screen" />
      <![endif]-->

</head>

<script src="../../js/jquery.js" type="text/javascript"></script>
<script src="../../js/jquery.clock.js" type="text/javascript"></script>
<script src="../../js/jquery.datepicker.js" type="text/javascript"></script>
<script src="../../js/jquery.expander.js" type="text/javascript"></script>
<script src="../../js/application.js" type="text/javascript"></script>

<body>
<div id="container">
<div id="navigation"><tiles:insert attribute="navigation" /></div>
</div>
</body>

</html:html>
