<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home </title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
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
</style>
</head>
<body>


	<header>
	
        <a href="#" class="logo"><img src="${pageContext.request.contextPath}/image/logo.png" alt=""></a>

        <ul class="navmenu">
        	
            <li><a href="Home">Home</a></li>
            <li><a href="">Products</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayCart">View Cart</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayOrdersList">View Orders</a></li>
            <li><a href="${pageContext.request.contextPath}/EditProfile">Edit profile</a></li>

            <c:choose>
            	<c:when test="${sessionScope.loggedInEmail == null }">
            		<li><a href="${pageContext.request.contextPath}/views/Login.jsp">Log In</a></li>
            		<li><a href="${pageContext.request.contextPath}/views/Signup.jsp">Sign Up</a></li>
            	</c:when>
            	<c:otherwise>
            		<li><a href="Logout">Log Out</a></li>
            	</c:otherwise>
            </c:choose>   
            
            <li>
            	<form action="${pageContext.request.contextPath}/search">
            		<input type="search" name="search" placeholder="search" >
            		<input type="submit"  value="search">
            	</form>
            </li>        
            
        </ul>

        <div class="nav-icon">
        <c:choose>
            	<c:when test="${sessionScope.loggedInEmail == null }">

            	</c:when>
            	<c:otherwise>
            		        <h4>You are logedin as <%= session.getAttribute("loggedInEmail") %></h4>
            	</c:otherwise>
            </c:choose>    

            <a href="#"><i class='bx bx-search'></i></a>
            <a href="#"><i class='bx bx-user' ></i></a>
            <a href="#"><i class='bx bx-cart' ></i></a>

            <div class="bx bx-menu" id="menu-icon"></div>
        </div>
    </header>
	<%@include file="../components/message.jsp" %>
	
	<section class="main-home">
        <div class="main-text">
            <h5>Winter Collection</h5>
            <h1>New Winter <br> Collection 2022</h1>
            <p>There's Nothing like Trend</p>

            <a href="#" class="main-btn">Shop Now <i class='bx bx-right-arrow-alt' ></i></a>
        </div>

        <div class="down-arrow">
            <a href="#trending" class="down"><i class='bx bx-down-arrow-alt' ></i></a>
        </div>
    </section>
    <br/>
    <div class="center-text">
            <h2>Our <span>Category</span></h2>
        </div>
        <div>
        <a href="${pageContext.request.contextPath}/Home?catagory=Men">Men</a>
        <a href="${pageContext.request.contextPath}/Home?catagory=Women">Women</a>
        <a href="${pageContext.request.contextPath}/Home?catagory=Kids">Kids</a>
        </div>
        <form method="get" style="display:flex; gap:8px;">
        <div class="category">
			<label>Category</label>
			<select name="catagory" id="category">
			<% 
			
				try{
					String url ="jdbc:mysql://localhost/ecommerce";
					String username = "root";
					String password = "";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,username,password);
					
					String query = "SELECT * FROM  category";
					PreparedStatement st = con.prepareStatement(query);
					ResultSet rs = st.executeQuery(query);
					
					while(rs.next()) {
				%>
						
					<option value="<%= rs.getString("title") %>" > <%= rs.getString("title") %> </option>
						
				<%
					}
					

				}catch (Exception e) {
					// TODO Auto-generated catch block					
				}
			%>
				
			</select>
		</div>
		<input type="submit" value="search"/>
        </form>
    <br/>
    <div class="center-text">
            <h2>Our <span>products</span></h2>
        </div>
		<div class="grid-container">
			<c:forEach var="prod" items="${productList}">
			  <div class="grid-item">
			  <img src="image/${prod.image}" height="100px" width="100px">
				  <p> ${prod.productTitle} </p>
				  <p> ${prod.productDescription} </p>
				  <p> $ ${prod.price} </p>
				  <p>Qnt: ${prod.quantity}</p>
				  <p> ${prod.category}</p>
				  <a href="${pageContext.request.contextPath}/AddToCart?id=${prod.productId}" class="main-btn">Add to Cart<i class='bx bx-right-arrow-alt' ></i></a>
				  <a href="${pageContext.request.contextPath}/BuyProduct?id=${prod.productId}" class="main-btn">Buy</a>
			  </div>
			</c:forEach>
		</div>
		
		
<script >
const header = document.querySelector("header");

window.addEventListener ("scroll", function(){
    header.classList.toggle ("sticky", this.window.scrollY > 0);
})

let menu = document.querySelector('#menu-icon');
let navmenu = document.querySelector('.navmenu');

menu.onclick = () => {
    menu.classList.toggle('bx-x');
    navmenu.classList.toggle('open');
}
</script>
</body>
</html>