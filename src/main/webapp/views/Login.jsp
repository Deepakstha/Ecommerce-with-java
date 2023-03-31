<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="../css/Login.css">
</head>
<body>
<div class="formcontainer">
	<form action="registration" method="post">
		<h1>Login</h1>
		<div class="email">
			<label for="email">Email or Phone number</label>
			<input type="email" name="email" id="email" placeholder="Enter Phone number or email"/>
		</div>
		
		<div class="password">
			<label for="pass">Password</label>
			<input type="password" name="password" id="pass" placeholder="Enter Password"/>
		</div>
		
		<div>
			<input type="submit" value="Login"/>
		</div>
		<p>Don't have account <a href="Signup.jsp">Create an account</a> </p>
	</form>
</div>
</body>
</html>