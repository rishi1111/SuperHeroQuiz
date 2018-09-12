<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<script type="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
</head>
<body><div class="container">
	<h1>Forgot Password</h1>
	<h3>Reset Your Password</h3>
		<div class="col-lg-6">
	
	<form action="user.quiz">
	
		<table class="table table-hover">
			<tr>
				<td>User Name</td>
				<td><input name="user" required></td>
			</tr>
			<tr>
				<td>Security Question </td>
				<td><input name="answer" required></td>
			</tr>
		</table>
		<input type="submit" value="Change" class="btn btn-default"> <br>
		
	</form>
</div>
</div>

</body>
</html>