<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/main_menu.css">
<link rel="stylesheet" href="css/left_menu.css">
<title>E-Shop</title>
</head>
<body>
	<div>header</div>
	<tiles:insertAttribute name="admin_menu"/>
	<tiles:insertAttribute name="main_menu" />
	
	<div>
		<img style="width: 100%; height: 150px;" src="images/b_m.jpg" alt="">
	</div>

	<tiles:insertAttribute name="left_menu"/>
	
	<center>
		<tiles:insertAttribute name="content" />
	</center>

	<tiles:insertAttribute name="footer"/>
</body>
</html>