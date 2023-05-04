<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
</head>
<body>
	<div>
		<%@include file="../components/message.jsp"%>
		<form action="${pageContext.request.contextPath}/UpdateProduct"
			method="post" enctype="multipart/form-data">
			<h1>Update Product</h1>
			<input type="text" name="productId" id="id"
				placeholder="Enter Product ID"
				value="<%=request.getParameter("id")%>" hidden />


			<div class="title">
				<label for="title">Product Title</label> <input type="text"
					name="productTitle" id="title" placeholder="Enter Product Title"
					value=" ${product.productTitle}" required />
			</div>



			<div class="desc">
				<label for="desc">Product Description</label>
				<textarea rows="" cols="" name="productDesc" id="desc">${product.productDescription}</textarea>
			</div>
			<div class="price">
				<label for="price">Price</label> <input type="number" name="price"
					id="price" value="${product.price}" required />
			</div>

			<div class="discount">
				<label for="discount">Discount</label> <input type="number"
					name="discount" id="discount" value="${product.discount}" required />
			</div>


			<div class="quantity">
				<label for="quantity">Quantity</label> <input type="number"
					name="quantity" id="quantity" value="${product.quantity}" required />
			</div>

			<div class="category">
				<label>Category</label> 
				<select name="catId" id="category">
					<%
					String url = "jdbc:mysql://localhost/ecommerce";
					String username = "root";
					String password = "";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, username, password);
					try {
						String query = "SELECT * FROM  category";
						PreparedStatement st = con.prepareStatement(query);
						ResultSet rs = st.executeQuery(query);

						while (rs.next()) {
					%>


					<option value="<%=rs.getString("title")%>"  >
						<%=rs.getString("title")%>
					</option>

					<%
					}

					} catch (Exception e) {
					// TODO Auto-generated catch block					
					}
					%>

				</select>
			</div>

			<div class="image">
				<label>Add Image</label> <input type="file" name="image"
					onchange="onImageChange()" required class="hide_file" /> 
					<img
					id="image" src="image/${product.image}" height="100px"
					width="100px">
			</div>



			<div>
				<input type="submit" value="Update Product" />
			</div>
		</form>

	</div>
	<script>
		function onImageChange() {
			var imageChooser = document.getElementById("imageChooser");
			var image = document.getElementById("image");
			image.src = URL.createObjectURL(imageChooser.files[0]);
		}
	</script>
</body>
</html>