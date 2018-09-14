<%@page import="lti.quiz.bean.OptionBean"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="lti.quiz.bean.QuizBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SuperHero Quiz</title>
</head>

<jsp:include page="banner.jsp"></jsp:include>
<body>


	<div class="container">
		<%
			QuizBean quiz = (QuizBean) request.getAttribute("Question");
		%>

		<%=quiz.getQuestion()%>

		<br>
		<form action="quiz.quiz">
			<%
				for (OptionBean option : quiz.getOptions()) {
			%>
			<input type="radio" name="choice" value="<%=option.getScore()%>"required><%=option.getOption()%></li>
			<br>
			<%
				}
			%>

			<input type="submit" value="Submit Answer">

		</form>

	</div>
</body>
</html>