package service;

import java.sql.Connection;

import dao.LoginDao;
import entity.Admin;
import util.DbUtil;

public class LoginService {//Loginエンティティに対する操作を提供するServiceクラス

	public Admin authentication(String adminId, String password) {
		try (Connection conn = DbUtil.getConnection()) {
			LoginDao loginDao = new LoginDao(conn);
			Admin admin = loginDao.findByIdAndPassword(adminId, password);

			return admin;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


}
