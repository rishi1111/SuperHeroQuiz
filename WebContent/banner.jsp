<%@page import="lti.quiz.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<script type="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<%
	RegisterBean user = (RegisterBean) session.getAttribute("USER");
%>
<body>
	<div class="container">
		<div class="col-lg-3" style="border: 2px solid black;">

			<h2>SuperHero Quiz</h2>

		</div>
		<div class="col-lg-7 " style="border: 2px solid red;">Navigation
			Bar</div>

		<div class="col-lg-2 ">
			<div class="col-lg-8">
				<%
					if (user != null) {
				%>
				<%=user.getEmail()%>
				<br> <a href="user.quiz?logout=yes">Logout</a>

				<%
					} else {
				%>

				Welcome Guest
				<%
					}
				%>
			</div>
			<div class="col-lg-4">
				<%
					if (user != null) {
				%>
				<img alt="profilepic" src=<%=(String) user.getProfile()%>
					height="120" width="150">

				<%
					}
				%>
			</div>

		</div>

	</div>
</body>
<hr>
</html>