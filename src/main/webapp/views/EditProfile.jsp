<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Signup.css">
</head>
<body>
<%@include file="nav.jsp" %>
	<form action="${pageContext.request.contextPath}/UpdateProfile"
		method="post" enctype="multipart/form-data">
		<h1>Update Product</h1>
		<input type="text" name="userId" id="id"
			value="${userDetails.userId }" readonly />
		<div class="fullname">
			<label for="fullname">Fullname</label> 
			<input type="text"
				name="fullname" id="fullname"
				placeholder="Enter your first and last name" value="${userDetails.fullname }" required="required" />
		</div>
		<div class="contact">
			<label for="contact">Phone number</label>
			<input type="text" name="phone" id="contact" placeholder="Please enter your phone number" value="${userDetails.phonenumber }"/>
		</div>
		
		<div class="email">
			<label for="email">Email</label>
			<input type="email" name="email" id="email" placeholder="example@example.com" value="${userDetails.email}" readonly/>
		</div>
		<div class="gender">
			<label>Gender:</label>
			<input type="radio" name="gender" value="Male" id="maleRadio" <c:if test="${fn:toLowerCase(userDetails.gender) eq 'male' }">checked</c:if>  />
			<label for="maleRadio">Male</label>
			
			<input type="radio" name="gender" value="Female" id="femaleRadio"  <c:if test="${fn:toLowerCase(userDetails.gender) eq 'female'}">checked</c:if> />
			<label for="femaleRadio">Female</label>
		</div>
		<div class="password">
			<label for="pass">Password</label>
			<input type="text" name="password" id="pass" placeholder="Enter Password" value="${userDetails.password }" />
		</div>
		<div class="userType">
			<label for="userType">User Type</label>
			<input type="text" name="userType" id="userType" placeholder="UserType" value="${userDetails.userType }" readonly />
		</div>
		
		<div class="image">
				<label>Add Image</label> 
				<input type="file" name="image" onchange="onImageChange()" id="imageChooser" required class="hide_file" /> 
				<img id="image" src="image/${userType.image}" height="100px" width="100px">
		</div>

		<div>
			<input type="submit" value="Update"/>
		</div>
	</form>
	<script>
		function onImageChange(){
			var imageChooser = document.getElementById("imageChooser");
			var image = document.getElementById("image");
			image.src = URL.createObjectURL(imageChooser.files[0]);
		}
	</script>
</body>
</html>