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
import lti.quiz.bean.RegisterBean;
import lti.quiz.service.QuizService;
import lti.quiz.service.QuizServiceImpl;
import lti.quiz.service.UserService;
import lti.quiz.service.UserServiceImpl;

/**
 * Servlet implementation class QuizController
 */
@WebServlet("/quiz.quiz")
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuizService service;
	private UserService usr_service;

	private int idx = 0;

	@Override
	public void init() throws ServletException {
		service = new QuizServiceImpl();
		usr_service = new UserServiceImpl();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String referer = request.getHeader("referer");

		List<String> scores = (List<String>) session.getAttribute("SCORE");
		if (scores == null)
			scores = new ArrayList<>();

		String choice = request.getParameter("choice");
		System.out.println(choice);
		if (choice != null) {
			scores.add(choice);
			session.setAttribute("SCORE", scores);
		}

		List<QuizBean> questions = (List<QuizBean>) session.getAttribute("QUIZ");
		if (questions == null) {
			questions = service.loadQuiz();
			session.setAttribute("QUIZ", questions);
		}

		request.setAttribute("Question", questions.get(idx));
		idx++;

		if (idx < 12)
			getServletContext().getRequestDispatcher("/quiz.jsp").forward(request, response);
		else {
			idx = 0;
			String hero = service.getResult(scores);
			request.setAttribute("Hero", hero);

			RegisterBean user = (RegisterBean) session.getAttribute("USER");

			usr_service.updateProfile(hero, (String) user.getEmail());
			getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
