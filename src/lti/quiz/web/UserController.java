package lti.quiz.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.bean.RegisterBean;
import lti.quiz.service.UserService;
import lti.quiz.service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user.quiz")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;

	@Override
	public void init() throws ServletException {

		service = new UserServiceImpl();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// referer header contains the url of the page that sent request object
		String referer = request.getHeader("referer");
		// Creates a fresh new session in the server if no session id found in request
		// header
		// otherwise old session identified as id in request header
		HttpSession session = request.getSession();

		if(request.getParameter("logout")!=null) {
			session.invalidate(); //destroying session
			response.sendRedirect("index.jsp");

		}
		
		else if (referer.contains("index")) {
			// Request is for login authentication
			// creating a LoginBean
			LoginBean login = new LoginBean();
			// getting parameters from request
			login.setEmail(request.getParameter("user"));
			login.setPassword(request.getParameter("pass"));
			// returns a login bean
			RegisterBean user = service.authenticate(login);

			if (user != null) {
				//login successful
				//we pass the user object in session so that we can access it in the dashboard page
				session.setAttribute("USER", user);
				response.sendRedirect("dashboard.jsp");
			} else {
				response.sendRedirect("index.jsp?invalid=yes");
			}

		} 
		else if (referer.contains("register")) {
			// Request is from register.jsp page

			RegisterBean register = new RegisterBean();
			register.setAnswer(request.getParameter("answer"));
			register.setEmail(request.getParameter("user"));
			register.setPassword(request.getParameter("pass"));
			if (service.register(register)) {
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("register.jsp?exists=yes");
			}
		}

		else if (referer.contains("forgotpass")) {

			ForgetBean forget = new ForgetBean();
			forget.setAnswer(request.getParameter("answer"));
			forget.setEmail(request.getParameter("user"));

			if (service.validate(forget)) {
				//set email_Id in session , so that we can use it in next changepass.jsp
				session.setAttribute("EMAIL", forget.getEmail());
				
				response.sendRedirect("changepass.jsp");
			} else {
				response.sendRedirect("q.jsp");

			}

		} else if (referer.contains("changepass")) {

			LoginBean change = new LoginBean();
			change.setEmail((String)session.getAttribute("EMAIL"));
			change.setPassword(request.getParameter("pass"));

			if (service.update(change)) {
				session.removeAttribute("EMAIL");
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("changepass.jsp");
			}

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
