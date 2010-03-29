<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h1>Book Details</h1>

<table border="0" cellpadding="4">
	<tr>
		<th>Author</th>
		<td>${book.author}</td>
	</tr>
	<tr>
		<th>Title</th>
		<td>${book.title}</td>
	</tr>
	<tr>
		<th>Description</th>
		<td>${book.description}</td>
	</tr>
	<tr>
		<th>Availability Date</th>
		<td><fmt:formatDate value="${book.availability}" dateStyle="full" /></td>
	</tr>
	<tr>
		<th>Count</th>
		<td>${book.count}</td>
	</tr>
</table>

<p style="text-align:center;">- 
	<a href="<portlet:renderURL>
			<portlet:param name="action" value="editBook"/>
			<portlet:param name="book" value="${book.key}"/>
		</portlet:renderURL>"><fmt:message key="button.edit"/></a> 
	<!--a href="<portlet:renderURL portletMode="view"/>"><fmt:message key="button.home"/></a-->
-</p>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>

<!--p style="text-align:center;"><a href="<portlet:renderURL portletMode="view"/>">- <spring:message code="button.home"/> -</a></p-->


