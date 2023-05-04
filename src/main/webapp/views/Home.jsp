<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home </title>
</head>
<body>
	<h1>Home page <%= session.getAttribute("loggedInEmail") %> Login Succesfull</h1>
	
	<a href="../view">Viewjsp</a>
</body>
</html>