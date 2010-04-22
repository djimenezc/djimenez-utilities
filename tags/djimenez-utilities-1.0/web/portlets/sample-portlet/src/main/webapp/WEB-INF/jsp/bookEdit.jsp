<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h1>${book.key == null ? 'Add New Book' : 'Edit Book Details'}</h1>

<html:errors path="book" fields="true"/>

<form method="post" action="<portlet:actionURL>
			<portlet:param name="action" value="editBook"/>
			<portlet:param name="book" value="${book.key}"/>
		</portlet:actionURL>">
	<table border="0" cellpadding="4">
		<tr>
			<th>Author</th>
			<td><html:input path="book.author" size="30" maxlength="80"/></td>
		</tr>
		<tr>
			<th>Title</th>
			<td><html:input path="book.title" size="30" maxlength="80"/></td>
		</tr>
		<tr>
			<th>Description</th>
			<td><html:textarea path="book.description" rows="10" cols="80"/></td>
		</tr>
		<tr>
			<th>Availability Date</th>
			<td><html:input path="book.availability" size="30" maxlength="30"/></td>
		</tr>
		<tr>
			<th>Count</th>
			<td><html:input path="book.count" size="30" maxlength="30"/></td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="submit">${book.key == null ? 'Add' : 'Save'}</button>
			</th>
		</tr>
	</table>
</form>

<!-- p style="text-align:center;"><a href="<portlet:renderURL portletMode="view"/>">- <spring:message code="button.home"/> -</a></p-->


<%@ include file="/WEB-INF/jsp/footer.jsp" %>