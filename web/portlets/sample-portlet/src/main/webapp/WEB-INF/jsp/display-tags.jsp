<%@ page contentType="text/html"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/styles/portlet.css"/>"/>
	
</head>

<body>

<script type="text/javascript">

</script>

<portlet:defineObjects/>

<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h1><fmt:message key="portlet.sample.title"/></h1>

<p>Locale: [${renderRequest.locale}]</p>

<p><spring:message code="portlet.sample.message"/></p>

<display:table name="items" cellspacing="0" cellpadding="0" defaultsort="1" id="items"
               pagesize="5" class="table" export="true">
    <display:column property="id"/>
    <display:column property="name"/>
    <display:column property="description"/>
</display:table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>

</body>
</html> 