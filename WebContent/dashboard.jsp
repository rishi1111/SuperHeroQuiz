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
<title>DashBoard</title>
</head>
<%
	RegisterBean user = (RegisterBean) session.getAttribute("USER");
%>
<jsp:include page="banner.jsp"/>

<body>
<div class="container">

		<div class="col-lg-3" style="border-right: 6px solid black;">

		

		</div>
		
		<div class="col-lg-7">
   
		<h3>Have you ever wondered which SuperHero you resemble?<br><br>
		Take this short <a href="quiz.quiz"> Quiz</a> to find out !
		</h3>
		</div>
		
		<div class="col-lg-2">
		</div>
		

</div>
</body>
</html>