<%@ include file="/WEB-INF/jsp/include.jsp" %>


<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h1>Books Portlet</h1>

<p>This portlet is an example of a slightly more complicated portlet
that use multiple pages within various modes.  You can view the list
of books, edit a given book, delete a given book, and add new books.</p>

<p>You can also go into 'edit' mode and select your favorite books
and then these will be displayed first when in view mode.</p>

<!-- p style="text-align:center;"><a href="<portlet:renderURL portletMode="view"/>">- <spring:message code="button.home"/> -</a></p-->

<%@ include file="/WEB-INF/jsp/footer.jsp" %>