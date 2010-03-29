<%@ page contentType="text/html"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<title>Insert title here</title>
	
	<!-- Additional IE/Win specific style sheet (Conditional Comments) -->
        <!--[if lte IE 7]>
        <link rel="stylesheet" href="jquery.tabs-ie.css" type="text/css" media="projection, screen">
        <![endif]-->
	<link rel="stylesheet" href="<c:url value="/styles/jquery.tabs.css"/>"></link>
	
	<script type="text/javascript">                                         
		
		// Map the jQuery namespace to the '$' one
		window.$ = jQuery;
		
		$(function() {
			jQuery('#tabs').tabs({ remote:true, fxSlide: true, fxFade: true, fxSpeed: 'normal' });
		});
	</script>
	<style>
		.tabs-nav a, .tabs-nav a span {
			background:transparent url(<c:url value="/images/tab.png"/>) no-repeat scroll 0%;
		}
	</style>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<div id="tabs" class="flora">
        <ul >
	     
	     <!-- remote:true, para llamadas ajax utilizar los action de spring MVC de la siguiente
	     	manera
	     	<li><a href="<portlet:renderURL windowState="exclusive">
	     	<portlet:param name="action" value="ajaxCall"/><portlet:param name="ajax" value="true"/>
	     	</portlet:renderURL>"/><span>Ajax Call</span></a></li>
	      -->
	     
	     <li><a href="<portlet:renderURL windowState="exclusive">
	     <portlet:param name="action" value="scriptaculus"/>
	     </portlet:renderURL>"/><span>Scriptaculus</span></a></li>
	     
         <li><a href="<portlet:renderURL windowState="exclusive">
         	<portlet:param name="action" value="jquery"/>
         	</portlet:renderURL>"/><span>JQuery</span></a></li>

        </ul>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>