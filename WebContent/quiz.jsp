<%@page import="lti.quiz.bean.OptionBean"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="lti.quiz.bean.QuizBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="container">
<% QuizBean quiz = (QuizBean)request.getAttribute("Question"); %>

<%=quiz.getQuestion() %>

<br>
<ul>
<% for(OptionBean option : quiz.getOptions()) { %>

<li> <%= option.getOption() %>  </li>

<% } %>

</ul>
</div>
</body>
</html>