package dao;

hanahanaわああああああ

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.UserInfo;

public class UserInfoDao {
	//idの最大値を取得
	private final String SELECT_ID_MAX = "SELECT MAX(user_id) AS max FROM user_info";


	//全て表示
	private static final String SQL_SELECT_ALL = "SELECT user_id,user_name,telephone,password FROM user_info";

	//user_idのみでレコード指定
	private static final String SQL_SELECT_BY_ID = "SELECT user_id,user_name,telephone,password FROM user_info WHERE user_id = ?";

	//user_nameのみでレコード指定
	private static final String SQL_SELECT_BY_NAME = "SELECT user_id,user_name,telephone,password FROM user_info WHERE user_name = ?";

	//telephoneのみでレコード指定
	private static final String SQL_SELECT_BY_TEL = "SELECT user_id,user_name,telephone,password FROM user_info WHERE telephone = ?";

	//user_idとuser_nameでレコード指定
	private static final String SQL_SELECT_BY_ID_AND_NAME = "SELECT user_id,user_name,telephone,password FROM user_info WHERE user_id = ? AND user_name = ?";

	//user_nameとtelephoneでレコード指定
	private static final String SQL_SELECT_BY_ID_AND_TEL = "SELECT user_id,user_name,telephone,password FROM user_info WHERE user_id = ? AND telephone = ?";

	//user_idとtelephoneでレコード指定
	private static final String SQL_SELECT_BY_NAME_AND_TEL = "SELECT user_id,user_name,telephone,password FROM user_info WHERE user_name = ? AND telephone = ?";

	//全部でレコード指定
	private static final String SQL_SELECT_BY_ID_AND_NAME_AND_TEL = "SELECT user_id,user_name,telephone,password FROM user_info WHERE user_id=? AND user_name = ? AND telephone = ?";


	//登録
	private static final String SQL_INSERT = "INSERT INTO user_info(user_name,telephone,password) VALUES(?, ?, ?)";
	//更新
	private static final String SQL_UPDATE = "UPDATE user_info SET user_name = ?, telephone = ?, password=? WHERE user_id = ?";
	//削除
	private final String SQL_DELETE = "DELETE FROM user_info WHERE user_id = ?";

	private Connection connection;

	public UserInfoDao() {

	}

	public UserInfoDao(Connection connection) {
		this.connection = connection;
	}

	public int getMaxId() {//idの最大値を取得するメソッド

		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SELECT_ID_MAX);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("max");
			}

			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public void register(UserInfo userInfo) {//登録メソッド
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQL_INSERT);
			stmt.setString(1, userInfo.getUserName());
			stmt.setString(2, userInfo.getTelephone());
			stmt.setString(3, userInfo.getPassword());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void update(UserInfo userInfo) {//更新メソッド

		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQL_UPDATE);
			stmt.setString(1, userInfo.getUserName());
			stmt.setString(2, userInfo.getTelephone());
			stmt.setString(3, userInfo.getPassword());
			stmt.setInt(4, userInfo.getUserId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void delete(Integer id) {//削除のメソッド

		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public List<UserInfo> findAll() {//全てのレコードを取得
		List<UserInfo> list = new ArrayList<UserInfo>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				UserInfo ui = new UserInfo(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(ui);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<UserInfo> findById(Integer iId) {//IDからレコードを取得
		List<UserInfo> list = new ArrayList<UserInfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_ID)) {
			stmt.setInt(1, iId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				UserInfo ui = new UserInfo(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(ui);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<UserInfo> findByName(String name) {//user_nameからレコードを取得
		List<UserInfo> list = new ArrayList<UserInfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_NAME)) {
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				UserInfo ui = new UserInfo(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(ui);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	public List<UserInfo> findByTel(String tel) {//telephoneからレコードを取得
		List<UserInfo> list = new ArrayList<UserInfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_TEL)) {
			stmt.setString(1, tel);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				UserInfo ui = new UserInfo(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(ui);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	public List<UserInfo> findByIdAndName(Integer iId,String name) {//user_idとuser_nameからレコードを取得
		List<UserInfo> list = new ArrayList<UserInfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_ID_AND_NAME)) {
			stmt.setInt(1, iId);
			stmt.setString(2, name);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				UserInfo ui = new UserInfo(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(ui);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	public List<UserInfo> findByIdAndTel(Integer iId,String tel) {//user_idとtelephoneからレコードを取得
		List<UserInfo> list = new ArrayList<UserInfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_ID_AND_TEL)) {
			stmt.setInt(1, iId);
			stmt.setString(2, tel);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				UserInfo ui = new UserInfo(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(ui);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	public List<UserInfo> findByNameAndTel(String name,String tel) {//user_nameとtelephoneからレコードを取得
		List<UserInfo> list = new ArrayList<UserInfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_NAME_AND_TEL)) {
			stmt.setString(1, name);
			stmt.setString(2, tel);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				UserInfo ui = new UserInfo(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(ui);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	public List<UserInfo> findByIdAndNameAndTel(Integer iId,String name,String tel) {//idとuser_nameとtelephoneからレコードを取得
		List<UserInfo> list = new ArrayList<UserInfo>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_ID_AND_NAME_AND_TEL)) {
			stmt.setInt(1, iId);
			stmt.setString(2, name);
			stmt.setString(3, tel);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				UserInfo ui = new UserInfo(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(ui);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}





}
