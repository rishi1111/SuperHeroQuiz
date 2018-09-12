<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>

<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<script type="text/javascript" src="bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Register Screen</h1>

		<%
			if (request.getParameter("invalid") != null) {
		%>

		<div class="alert-danger">Invalid User / Pass</div>
		<%
			}
		%>

		<form action="user.quiz">
			<div class="col-lg-6">
				<table class="table table-hover">
					<tr>

						<td>User Name</td>
						<td><input type="email" name="user" required></td>

					</tr>
					<tr>



					</tr>
					<tr>
						<td> Password</td>
						<td><input type="password" name="pass" required></td>

					</tr>
					<tr>
						<td><select class="form-control">
								<option value="opt1">What is your Favourite Color?</option>
								<option value="opt2">What is your Mother's Maiden Name?</option>
								<option value="opt3">What brand was your first Car?</option>
						</select></td>
						<td><input name="answer" required></td>

					</tr>

					<tr>

						<td colspan=2>
							<center>
								<input type="submit" value="Register" class="btn btn-default">
							</center>
						</td>

					</tr>


				</table>
			</div>
		</form>
	</div>
</body>
</html>