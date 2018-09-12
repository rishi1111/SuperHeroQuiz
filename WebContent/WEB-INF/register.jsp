<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>

<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<script type="text/javascript" src="bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Screen</h1>

	<%
		if (request.getParameter("invalid") != null) {
	%>

	<div class="alert-danger">Invalid User / Pass</div>
	<%
		}
	%>

	<form action="register">
		<table border=1>
			<tr>
				<td>User Name</td>
				<td><input name="user"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="pass"></td>

			</tr>

			<tr>

				<td><input type="submit" value="Register"></td>

			</tr>


		</table>
	</form>

</body>
</html>