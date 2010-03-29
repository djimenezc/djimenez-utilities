<%@ include file="/WEB-INF/jsp/include.jsp" %>

<c:set var="page" value="${empty page ? 0 : page}"/>
<c:set var="nextPage" value="${page == 4 ? null : page + 1}"/>
<c:set var="prevPage" value="${page == 0 ? null : page - 1}"/>

<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h1>Add New Book</h1>

<html:errors path="book" fields="true"/>

<form method="post" action="<portlet:actionURL>
			<portlet:param name="action" value="addBook"/>
			<portlet:param name="_page" value="${page}"/>
		</portlet:actionURL>">
	<table border="0" cellpadding="4">
		<tr>
			<c:choose> 
				<c:when test="${page == 0}" > 
					<th>Author</th>
					<td><html:input path="book.author" size="30" maxlength="80"/></td>
				</c:when> 
				<c:when test="${page == 1}" > 
					<th>Title</th>
					<td><html:input path="book.title" size="30" maxlength="80"/></td>
				</c:when> 
				<c:when test="${page == 2}" > 
					<th>Description</th>
					<td><html:textarea path="book.description" rows="10" cols="80"/></td>
				</c:when> 
				<c:when test="${page == 3}" > 
					<th>Availability Date</th>
					<td><html:input path="book.availability" size="30" maxlength="30"/></td>
				</c:when> 
				<c:when test="${page == 4}" > 
					<th>Count</th>
					<td><html:input path="book.count" size="30" maxlength="30"/></td>
				</c:when> 
			</c:choose>  
		<tr>
			<th colspan="2">
				<input type="submit" name="_target${nextPage}" ${empty nextPage ? "disabled" : ""} value="Next"/>
				<input type="submit" name="_finish" value="Finish"/>
				<input type="submit" name="_target${prevPage}" ${empty prevPage ? "disabled" : ""} value="Previous"/>
				<input type="submit" name="_cancel" value="Cancel"/>
			</th>
		</tr>
	</table>
</form>



<%@ include file="/WEB-INF/jsp/footer.jsp" %>

<!-- p style="text-align:center;"><a href="<portlet:renderURL portletMode="view"/>">- <spring:message code="button.home"/> -</a></p-->

