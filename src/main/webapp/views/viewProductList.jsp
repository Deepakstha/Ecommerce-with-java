<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<!-- <link rel="stylesheet" href="../css/viewProductList.css">-->
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 <style>
 .title{
	text-align: center;
	font: bold;
}
#products {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#products td, #products th {
  border: 1px solid #ddd;
  padding: 8px;
}

#products tr:nth-child(even){background-color: #f2f2f2;}

#products tr:hover {background-color: #ddd;}

#products th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AAaD;
  color: white;
}
 </style>
</head>
<body>
	<h1 class="title">All Products</h1>
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