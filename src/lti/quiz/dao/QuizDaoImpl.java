package lti.quiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lti.quiz.bean.OptionBean;
import lti.quiz.bean.QuizBean;
import oracle.jdbc.OracleDriver;

public class QuizDaoImpl implements QuizDao {

	private Connection getConnection() throws SQLException {
		// registering driver
		DriverManager.registerDriver(new OracleDriver());
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		// opening a connection
		Connection conn = DriverManager.getConnection(url, "rishi", "compaq");
		return conn;
	}

	@Override
	public List<QuizBean> loadQuiz() {
		Connection conn = null;

		String sql_quiz = "select * from quiz";
		String sql_answers = "select * from ans where qid = ?";

		ArrayList<QuizBean> list = new ArrayList<QuizBean>();

		try {
			conn = getConnection();
			Statement stmt_quiz = conn.createStatement();

			ResultSet quiz_rs = stmt_quiz.executeQuery(sql_quiz);

			PreparedStatement stmt_ans = conn.prepareStatement(sql_answers);

			while (quiz_rs.next()) {
				ArrayList<OptionBean> options = new ArrayList<>();

				QuizBean bean = new QuizBean();
				bean.setQuestion(quiz_rs.getString(2));

				stmt_ans.setInt(1, quiz_rs.getInt(1));
				ResultSet ans_rs = stmt_ans.executeQuery();

				while (ans_rs.next()) {
					OptionBean optbean = new OptionBean();
					optbean.setOption(ans_rs.getString(2));
					optbean.setScore(ans_rs.getString(3));
					options.add(optbean);
					bean.setOptions(options);
				}
				list.add(bean);
				

			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getResult(String code) {
		String sql = "select hero from result where code = ?";
		Connection conn = null;

		try {
			conn = getConnection();
			String result="";
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setString(1, code);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {

				result = rs.getString(1);
			}

			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
