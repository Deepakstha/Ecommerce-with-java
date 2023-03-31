<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<link rel="stylesheet" href="../css/Signup.css">
</head>
<body>
<div class="formcontainer">
	
	
	<form action="registration" method="post">
		<h1>Create an account</h1>
		<div class="fullname">
			<label for="fullname">Fullname</label>
			<input type="text" name="fullname" id="fullname" placeholder="Enter your first and last name"/>
		</div>
		<div class="contact">
			<label for="contact">Phone number</label>
			<input type="text" name="phone" id="contact" placeholder="Please enter your phone number"/>
		</div>
		<div class="email">
			<label for="email">Email</label>
			<input type="email" name="email" id="email" placeholder="example@example.com"/>
		</div>
		<div class="gender">
			<label>Gender:</label>
			<input type="radio" name="gender" value="Male" id="maleRadio"/>
			<label for="maleRadio">Male</label>
			
			<input type="radio" name="gender" value="Female" id="femaleRadio"/>
			<label for="femaleRadio">Female</label>
		</div>
		<div class="password">
			<label for="pass">Password</label>
			<input type="password" name="password" id="pass" placeholder="Enter Password"/>
		</div>
		<div class="re-password">
			<label for="re-pass">Re-enter password</label>
			<input type="password" name="repassword" id="re-pass" placeholder="re-enter password"/>
		</div>
		<div>
			<input type="submit" value="SignUp"/>
		</div>
		<p>Already have an account? <a href="Login.jsp">Login</a> </p>
	</form>
</div>
</body>
</html>