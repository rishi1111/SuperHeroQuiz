package lti.quiz.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lti.quiz.bean.QuizBean;
import lti.quiz.service.QuizServiceImpl;

/**
 * Servlet implementation class QuizController
 */
@WebServlet("/quiz.quiz")
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuizServiceImpl service;
	private int idx;

	public void init() throws ServletException {
		service = new QuizServiceImpl();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		ArrayList<String> scores = (ArrayList<String>) session.getAttribute("SCORE");

		if (scores == null) {
			scores = new ArrayList<>();
		}

		List<QuizBean> questions = (List<QuizBean>) session.getAttribute("QUIZ");

		if (questions == null) {
			questions = service.loadQuiz();
			session.setAttribute("QUIZ", questions);
		}
		
		
		request.setAttribute("Question",questions.get(idx++));
		if(idx>=questions.size()) {
			idx = 0;
		}
		getServletContext().getRequestDispatcher("/quiz.jsp").forward(request, response);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
