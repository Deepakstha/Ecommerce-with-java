<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<style>
.grid-container {
  display: grid;
  grid-template-columns: auto auto auto;
  padding: 10px;
}

.grid-item {
  background-color: rgba(255, 255, 255, 0.8);
  border: 1px solid rgba(0, 0, 0, 0.8);
  margin:10px;
  font-size: 30px;
  text-align: center;
}
.grid-item  img{
width:300px;
height:200px;
}
.btn{
    display: inline-block;
    color: #111;
    font-size: 16px;
    font-weight: 500;
    text-transform: capitalize;
    border: 2px solid #111;
    padding: 12px 25px;
    transition: all .42s ease;
}
.btn:hover{
    background-color: #000;
    color: #fff;
}
</style>
</head>
<body>
<%@include file="nav.jsp" %>
<h2>Your Cart Product</h2>
<div class="grid-container">
		<c:forEach var="cart" items="${cartList}">
		<div class="grid-item">
		<img src="image/${cart.image}" height="100px" width="100px">
		<p>${cart.productTitle}</p>
		<p>${cart.productDescription}</p>
		<p>$ ${cart.price}</p>
		<a href="${pageContext.request.contextPath}/BuyProduct?id=${cart.productId}" class="btn">Buy</a>
			
			</div>
		</c:forEach>
</div>

</body>
</html>