<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.DriverManager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
<link rel="stylesheet" href="../css/Admin.css">
</head>
<body>

	<div class="container">
    <h1>Welcome to Admin panel page</h1>
    <div class="row">
      <div class="col">
        <div class="box">
          <img src="images/add category.png" alt="Add Category Icon">
           <a href="${pageContext.request.contextPath}/views/AddCategory.jsp"> <button >Add Category </button></a> 
        </div>
      </div>
      <div class="col">
        <div class="box">
          <img src="images/Add Product.png" alt="Add Product Icon">
          <a href="${pageContext.request.contextPath}/views/AddProduct.jsp"> <button>Add Product</button></a>
        </div>
      </div>
      <div class="col">
        <div class="box">
          <img src="images/Add Product.png" alt="View Product Icon">
          <a href="${pageContext.request.contextPath}/ViewProduct"> <button>View Product</button></a>
        </div>
      </div>
      <div class="col">
        <div class="box">
          <img src="images/view order.png" alt="View Orders Icon">
          <form action="${pageContext.request.contextPath}/DisplayOrdersList">
          	<select name="userOrders" id="user">
			<% 
			
				try{
					String url ="jdbc:mysql://localhost/ecommerce";
					String username = "root";
					String password = "";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,username,password);
					
					String query = "SELECT DISTINCT orders.user FROM orders";
					PreparedStatement st = con.prepareStatement(query);
					ResultSet rs = st.executeQuery(query);
					
					while(rs.next()) {
				%>
						
					<option value="<%= rs.getString("user") %>" > <%= rs.getString("user") %> </option>
						
				<%
					}
					

				}catch (Exception e) {
					// TODO Auto-generated catch block					
				}
			%>
				
			</select>
           <button type="submit">View Orders</button> 
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>