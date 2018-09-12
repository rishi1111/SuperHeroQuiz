<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<h2>Welcome to Java Server Pages</h2>
	<h2>Visit Date: <%= LocalDate.now()%></h2>
    <%! int visitor=12001; %>
	
	<h2> Visitor No: <%=visitor++ %> </h2>
</body>
</html>