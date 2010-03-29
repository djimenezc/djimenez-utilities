<%@ include file="/WEB-INF/jsp/include.jsp" %>


<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h1>Book Inventory</h1>

<table border="0" cellpadding="4">
	<tr><th>Author</th><th>Title</th><th>Count</th><th></th></tr>
	<c:forEach items="${model.books}" var="book">
		<tr>
			<td>${book.author}</td>
			<td><a href="<portlet:renderURL>
						<portlet:param name="action" value="viewBook"/>
						<portlet:param name="book" value="${book.key}"/>
					</portlet:renderURL>">${book.title}</a></td>
			<td align="right">${book.count}</td>
			<td>
				<a href="<portlet:actionURL>
						<portlet:param name="action" value="incrementBook"/>
						<portlet:param name="book" value="${book.key}"/>
						<portlet:param name="increment" value="1"/>
					</portlet:actionURL>"><img title="Increase Count" src="<html:imagesPath/>increase.png" border=0 /></a>
				<a href="<portlet:actionURL>
						<portlet:param name="action" value="incrementBook"/>
						<portlet:param name="book" value="${book.key}"/>
						<portlet:param name="increment" value="-1"/>
					</portlet:actionURL>"><img title="Decrease Count" src="<html:imagesPath/>decrease.png" border=0 /></a>
				<a href="<portlet:renderURL>
						<portlet:param name="action" value="editBook"/>
						<portlet:param name="book" value="${book.key}"/>
					</portlet:renderURL>"><img title="Edit Book Details" src="<html:imagesPath/>edit.png" border=0 /></a>
				<a href="<portlet:actionURL>
						<portlet:param name="action" value="deleteBook"/>
						<portlet:param name="book" value="${book.key}"/>
					</portlet:actionURL>"><img title="Delete Book" src="<html:imagesPath/>delete.png" border=0 /></a>
			</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="4">
				<a href="<portlet:renderURL>
						<portlet:param name="action" value="addBook"/>
					</portlet:renderURL>"><img title="Add New Book" src="<html:imagesPath/>new.png" border=0 /> Add New Book</a>
			</td>
		</tr>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
