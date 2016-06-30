<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<h3>Login</h3>
	<c:if test="${not empty error}">
		<div>
			Failed!!!
		</div>
	</c:if>
	<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
		<input placeholder="User name" type="text" name="username"><br>
		<input placeholder="Password" type="password" name="password"><br>
		<input type="submit" value="Login">
		<security:csrfInput/>
	</form>
</div>