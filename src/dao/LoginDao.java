package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Admin;

public class LoginDao {

	private static final String SQL_SELECT_BY_ID_AND_PASS = "SELECT admin_id,admin_name,password FROM admin WHERE admin_id = ? AND password = ?";

	private Connection connection;

	public LoginDao(Connection connection) {
		this.connection = connection;
	}

	public Admin findByIdAndPassword(String adminId, String password) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_ID_AND_PASS)) {
			stmt.setString(1, adminId);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Admin(rs.getString("admin_id"), rs.getString("admin_name"), rs.getString("password"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
