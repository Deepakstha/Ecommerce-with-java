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
<title>Add Product</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AddProduct.css">
</head>
<body>
<div>
<%@include file="../components/message.jsp" %>
	<form action="../ProductOperationServlet" method="post" enctype="multipart/form-data">
		<h1>Add Product</h1>
		<input type="hidden" name="operation" value="addproduct"/>
		<div class="title">
			<label for="title">Product Title</label>
			<input type="text" name="productTitle" id="title" placeholder="Enter Product Title" required />
		</div>
		<div class="desc">
			<label for="desc">Product Description</label>
			<textarea rows="" cols="" name="productDesc" id="desc"></textarea>
		</div>
		<div class="price">
			<label for="price">Price</label>
			<input type="number" name="price" id="price" required />
		</div>
		
		<div class="discount">
			<label for="discount">Discount</label>
			<input type="number" name="discount" id="discount" required />
		</div>
		
		<div class="quantity">
			<label for="quantity">Quantity</label>
			<input type="number" name="quantity" id="quantity" required />
		</div>
		
		<div class="category">
			<label>Category</label>
			<select name="catId" id="category">
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
		
		<div class="image">
		<label>Add Image</label>
			<input type="file" name="image" required class="hide_file" />
		</div>
		
		
		
		<div>
			<input type="submit" value="Add Product"/>
		</div>
	</form>

</div>
</body>
</html>