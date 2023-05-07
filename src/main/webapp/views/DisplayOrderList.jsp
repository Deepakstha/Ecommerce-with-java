<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewProductList.css">
</head>
<body>
	<%@include file="nav.jsp"%>
	<h2>Your Orders Product List</h2>
	
	
	<table id="products">	
	<tr>
	    <th>Order ID</th>
	    <th>Product ID</th>
	    <th>Product Title</th>
	    <th>Product Description</th>
	    <th>Price</th>
	    <th>Image</th>
	  </tr>	
		<c:forEach var="orders" items="${orderList}">
			<tr>
				<td><c:out value="${orders.orderId}"/></td>
				<td><c:out value="${orders.productId}"/></td>
				<td>${orders.productTitle}</td>
				<td>${orders.productDescription}</td>
				<td>${orders.price}</td>
				<td><img src="image/${orders.image}" height="100px" width="100px"></td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>