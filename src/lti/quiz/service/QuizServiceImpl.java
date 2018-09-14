package lti.quiz.service;

import java.util.List;

import lti.quiz.bean.QuizBean;
import lti.quiz.dao.QuizDao;
import lti.quiz.dao.QuizDaoImpl;

public class QuizServiceImpl implements QuizService {

	private QuizDao dao;

	public QuizServiceImpl() {
		dao = new QuizDaoImpl();
	}

	@Override
	public List<QuizBean> loadQuiz() {
		return dao.loadQuiz();

	}

	@Override
	public String getResult(String code) {
		// TODO Auto-generated method stub
		return dao.getResult(code);
	}

}
