<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<h1>Add product</h1>
<c:if test="${not empty successful}">
	<div>Successful!</div>
</c:if>
<form name="addProduct" method="post">
	<label>Name: <input type="text" name="name"></label><br>
	<select name="categories">
	    <option disabled>Category</option>
	    <c:forEach items="${categories}" var="category">
			<option value="${category.id}">${category.name}</option>
		</c:forEach>
    </select><br>
	<label>Description: <input type="text" name="description"></label><br>
	<label>Price: <input type="number" name="price"></label><br>
	<label>Units in stock: <input type="number" name="unitsInStock"></label><br>
	<label>Image: <input type="file" name="image"></label><br>
	<label>Show: <input type="radio" name="show" value="1"> </label>
	<label>Hidden: <input type="radio" name="show" value="0"> </label><br>
	<input type="submit" name="add" value="Add">
	<security:csrfInput />
</form>
