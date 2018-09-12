<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<script type="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SuperHero Quiz</title>
</head>
<body><div class="container">
	<h1>SuperHero Quiz</h1>
	<h3>Find out which hero do you resemble the most.</h3>
	
	
	<div class="col-lg-4 col-md-offset-4" >
	
	<form action="user.quiz">
		<table class="table table-hover">
			<tr>
				<td>User Name</td>
				<td><input name="user" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pass" required></td>
			</tr>
			<tr>
			<td>
			<input type="submit" value="Login" class="btn btn-default"> <br>
			</td>
			</tr>
		</table>
		
		<a href="register.jsp">Register here</a><br>
		<a href="forgotpass.jsp">Did you forget password?</a>


	</form>

</div>
</div>
</body>
</html>