<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<h1>All category</h1>

<table>
	<tr>
		<th>Name</th>
		<th>Show</th>
	</tr>
	<c:forEach items="${categories}" var="category">
		<tr>
			<form name="editCategories" method="post">
			<td>
				<input type="hidden" name="id" value="${category.id}">
				<input type="text" name="name" value="${category.name}">
			</td>
			<td>
				<input type="checkbox" name="show" value="1" checked>
			</td>
			<td><input type="submit" name="delete" value="Delete"></td>
			<td><input type="submit" name="update" value="Update"></td>
			<security:csrfInput />
			</form>
		</tr>
	</c:forEach>
	<tr>
		<form name="editCategories" method="post">
		<td> 
			<input type="submit" name="add" value="Add"> 
			<security:csrfInput />
		</td>
		</form>
	</tr>
</table>
