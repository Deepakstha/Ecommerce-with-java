<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Uplode</title>
<link rel="stylesheet" href="../css/Signup.css">
</head>
<body>
<div class="formcontainer">

<div class="message">
</div>
	
	
	<form action="../Uplode" method="post">
		<h1>File Uplode</h1>
		<div class="fullname">
			<label for="fullname">Fullname</label>
			<input type="text" name="fullname" id="fullname" placeholder="Enter your first and last name" required="required"/>
			<input type="password" name="password" id="password" placeholder="password" required="required"/>
		</div>
		<input type="file" name="image"/>
		<input type="submit">
		<p>Already have an account? <a href="Login.jsp">Login</a> </p>
	</form>
</div>
</body>
</html>