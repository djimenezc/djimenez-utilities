<%@ page contentType="text/html"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<title>Insert title here</title>
</head>

<body>

	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

<a href="<portlet:renderURL >
	     	<portlet:param name="action" value="books"/>
	     	</portlet:renderURL>"/><span>Spring MVC</span></a><br/>
<a href="<portlet:renderURL >
	     	<portlet:param name="action" value="javascript"/>
	     	</portlet:renderURL>"/><span>Frameworks Javascript-Ajax</span></a><br/>
<a href="<portlet:renderURL >
	     	<portlet:param name="action" value="display-tags"/>
	     	</portlet:renderURL>"/><span>DisplayTags</span></a><br/>
<a href="<portlet:renderURL >
	     	<portlet:param name="action" value="dwrPage"/>
	     	</portlet:renderURL>"/><span>Dwr</span></a><br/>
<a href="<portlet:renderURL >
	     	<portlet:param name="action" value="sack"/>
	     	</portlet:renderURL>"/><span>Sack</span></a><br/>
	     	
	<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>