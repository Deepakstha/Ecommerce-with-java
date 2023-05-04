<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>
<link rel="stylesheet" href="../css/AddCategory.css">
</head>
<body>
<div>
<%@include file="../components/message.jsp" %>
	<form action="../ProductOperationServlet" method="post">
		<h1>Add Category</h1>
		<input type="hidden" name="operation" value="addcategory"/>
		<div class="title">
			<label for="title">Category Title</label>
			<input type="text" name="categoryTitle" id="title" placeholder="enter Category Title"/>
		</div>
		<div class="desc">
			<label for="desc">Category Description</label>
			<textarea rows="" cols="" name="categoryDesc" id="desc"></textarea>
		</div>
		
		
		
		<div>
			<input type="submit" value="Add Category"/>
		</div>
	</form>
</div>
</body>
</html>