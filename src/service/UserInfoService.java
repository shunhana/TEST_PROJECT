package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.UserInfoDao;
import entity.UserInfo;
import util.DbUtil;

public class UserInfoService { //user_infoエンティティに対する操作を提供するServiceクラス
	public List<UserInfo> find() {//未入力の時、全てのレコードを取得
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			return userInfoDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
	public List<UserInfo> findById(Integer iId) {//IDからレコードを取得
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			return userInfoDao.findById(iId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
	public List<UserInfo> findByName(String name) {//user_nameからレコードを取得
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			return userInfoDao.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
	public List<UserInfo> findByTel(String tel) {//telephoneからレコードを取得
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			return userInfoDao.findByTel(tel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
	public List<UserInfo> findByIdAndName(Integer iId,String name) {//idとuser_nameからレコードを取得
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			return userInfoDao.findByIdAndName(iId,name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
	public List<UserInfo> findByIdAndTel(Integer iId,String tel) {//idとtelephoneからレコードを取得
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			return userInfoDao.findByIdAndTel(iId,tel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
	public List<UserInfo> findByNameAndTel(String name,String tel) {//idとtelephoneからレコードを取得
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			return userInfoDao.findByNameAndTel(name,tel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
	public List<UserInfo> findByIdAndNameAndTel(Integer iId,String name,String tel) {//idとuser_nameとtelephoneからレコードを取得
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			return userInfoDao.findByIdAndNameAndTel(iId,name,tel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}


	public int insert(UserInfo userInfo){
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			userInfoDao.register(userInfo);
			return userInfoDao.getMaxId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public void update(UserInfo userInfo){
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			userInfoDao.update(userInfo);
			//return userInfoDao.getMaxId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}
	public void delete(UserInfo userInfo) {
		try (Connection conn = DbUtil.getConnection()) {
			UserInfoDao userInfoDao = new UserInfoDao(conn);
			userInfoDao.delete(userInfo.getUserId());
			//return userInfoDao.getMaxId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}




}
