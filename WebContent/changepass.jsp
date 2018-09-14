<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<script type="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<jsp:include page="banner.jsp"/>

<body>
	<div class="container">
		<h1>Change Password</h1>
			<div class="col-lg-6">
		
		<form action="user.quiz">
			<table class="table table-hover">
				<tr>
					<td>Ree nter email</td>
					<td><input name="user" required></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td><input name="pass" required></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input name="cnf_pass" required></td>
				</tr>
			</table>
			<a href=""><input type="submit" value="Change" class="btn btn-default"></a> <br>

		</form>
		</div>
		</div>
</body>
</html>