<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="left_menu">
	<h1>category</h1>
	<ul>
		<c:forEach items="${categories}" var="category">
			<li><a href="${category.id}">${category.name}</a></li>
		</c:forEach>
	</ul>
</div>