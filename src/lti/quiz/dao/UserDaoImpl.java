package lti.quiz.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.bean.RegisterBean;
import oracle.jdbc.OracleDriver;

public class UserDaoImpl implements UserDao {

	@Override
	public RegisterBean authenticate(LoginBean login) {
		String sql = "select  * from users where email = ? and password =?";
		Connection conn = null;
		try {
			// getting connection object
			conn = getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);

			//
			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getPassword());
			ResultSet rs = stmt.executeQuery();
			RegisterBean register = null;

			// Traversing through ResultSet object and retrieving values
			if (rs.next()) {
				register = new RegisterBean();
				register.setEmail(rs.getString(1)); // setting RegisterBean properties

				register.setProfile(rs.getString(4));

				return register;

			}
			// returning object of RegisterBean
			return register;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					// closing connection
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private Connection getConnection() throws SQLException {
		// registering driver
		DriverManager.registerDriver(new OracleDriver());
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		// opening a connection
		Connection conn = DriverManager.getConnection(url, "rishi", "compaq");
		return conn;
	}

	@Override
	public boolean register(RegisterBean register) {
		String sql = "insert into users values (?,?,?,?)";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, register.getEmail());
			stmt.setString(2, register.getPassword());
			stmt.setString(3, register.getAnswer());
			stmt.setString(4, register.getProfile());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {
			// clean up
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean validate(ForgetBean forget) {

		String sql = "select * from users where email = ?  and answer = ?";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, forget.getEmail());
			stmt.setString(2, forget.getAnswer());

			int count = stmt.executeUpdate();

			if (count == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

	@Override
	public boolean update(LoginBean change) {
		String sql = "update users set password = ? where email =?";
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, change.getPassword());
			stmt.setString(2, change.getEmail());
			int count = stmt.executeUpdate();

			if (count == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	@Override
	public boolean updateProfile(RegisterBean user) {
		String sql = "update users set profile =? where email =?";
		Connection conn = null;

		
		try {
			conn = getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String)user.getProfile());
			pstmt.setString(2, (String)user.getEmail());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
