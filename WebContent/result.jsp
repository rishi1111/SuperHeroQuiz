<%@page import="lti.quiz.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<script type="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	RegisterBean user = (RegisterBean) session.getAttribute("USER");
%>

</head>
<body style="background-color: indianred; color: azure">
	<jsp:include page="banner.jsp" />
	<div class="container">
		<h1>You resemble this superhero B)</h1>
		<%
			String hero = (String) request.getAttribute("Hero");
			user.setProfile(hero);
			session.setAttribute("hero",null);
		%>
		<img src="<%=hero%>"> <a href="quiz.quiz">Retake this quiz</a>
		<%@ include file="footer.html"%>
	</div>
</body>
</html>