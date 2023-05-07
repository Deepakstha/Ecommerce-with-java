<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<!-- <link rel="stylesheet" href="../css/viewProductList.css">-->
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewProductList.css">
</head>
<body>
	<h1 class="title">All Products</h1>
	<%@include file="../components/message.jsp" %>
	<table id="products">
	  <tr>
	    <th>Product ID</th>
	    <th>Product Title</th>
	    <th>Product Description</th>
	    <th>Price</th>
	    <th>Discount</th>
	    <th>Quantity</th>
	    <th>Category</th>
	    <th>Image</th>
	    <th>Action</th>
	  </tr>
	  
	  <c:forEach var="prod" items="${productList}">
			<tr>
				<td><c:out value="${prod.productId}"/></td>
				<td>${prod.productTitle}</td>
				<td>${prod.productDescription}</td>
				<td>${prod.price}</td>
				<td>${prod.discount}</td>
				<td>${prod.quantity}</td>
				<td>${prod.category}</td>
				<td><img src="image/${prod.image}" height="100px" width="100px"></td>
				<td><a href="${pageContext.request.contextPath}/EditProduct?id=${prod.productId}">Edit</a> <a href="${pageContext.request.contextPath}/DeleteProduct?id=${prod.productId}">Delete</a></td>
			</tr>	
		</c:forEach>
		
	</table>
</body>
</html>