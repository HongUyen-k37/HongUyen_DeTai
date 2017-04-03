package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.UserBean;

public class DEMODao extends DataAccessObject {

	public List<UserBean> getList() {
		List<UserBean> lst = new ArrayList<UserBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
//			String sql = "SELECT * FROM Users";
//			pstm = cnn.prepareStatement(sql);
//			rs = pstm.executeQuery();
//			String userName, password, hoTen, email;
//			int type;
//			boolean active;
//			while (rs.next()) {
//				userName = rs.getString("UserName");
//				password = rs.getString("Password");
//				hoTen = rs.getString("HoTen");
//				email = rs.getString("Email");
//				type = rs.getInt("Type");
//				active = rs.getBoolean("Active");
//				lst.add(new UserBean(userName, password, hoTen, email, type, active));
//			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return lst;
	}

	public boolean checkLogin(String userName, String password) {
		boolean result = false;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM [User] where UserName=? AND Password=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			result = rs.next();
		} catch (Exception ex) {
			getMessenger(ex);
			result = false;
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return result;
	}

//	public boolean insert(UserBean user) {
//		boolean result = false;
//		Connection cnn = getConnection();
//		PreparedStatement pstm = null;
//		try {
//			String sql = "INSERT INTO Users VALUES(?,?,?,?,?,?)";
//			pstm = cnn.prepareStatement(sql);
//			pstm.setString(1, user.getUserName());
//			pstm.setString(2, user.getPassword());
//			pstm.setString(3, user.getHoTen());
//			pstm.setString(4, user.getEmail());
//			pstm.setInt(5, user.getType());
//			pstm.setBoolean(6, user.isActive());
//			result = pstm.execute();
//		} catch (Exception ex) {
//			result = false;
//			getMessenger(ex);
//		} finally {
//			tryToClose(cnn);
//			tryToClose(pstm);
//		}
//		return result;
//	}
//
//	public boolean update(UserBean user) {
//		boolean result = false;
//		Connection cnn = getConnection();
//		PreparedStatement pstm = null;
//		try {
//			String sql = "Update Users Set Password=?,HoTen=?,Email=?,Type=?,Active=? Where UserName=?";
//			pstm = cnn.prepareStatement(sql);
//			pstm.setString(6, user.getUserName());
//			pstm.setString(1, user.getPassword());
//			pstm.setString(2, user.getHoTen());
//			pstm.setString(3, user.getEmail());
//			pstm.setInt(4, user.getType());
//			pstm.setBoolean(5, user.isActive());
//			result = pstm.execute();
//		} catch (Exception ex) {
//			result = false;
//			getMessenger(ex);
//		} finally {
//			tryToClose(cnn);
//			tryToClose(pstm);
//		}
//		return result;
//	}

	public boolean delete(String userName) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Delete from Users where UserName=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, userName);
			result = pstm.execute();
		} catch (Exception ex) {
			result = false;
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
		return result;
	}

//	public UserBean getUser(String userName) {
//		UserBean user = null;
//		Connection cnn = getConnection();
//		ResultSet rs = null;
//		PreparedStatement pstm = null;
//		try {
//			String sql = "SELECT * FROM Users where UserName=?";
//			pstm = cnn.prepareStatement(sql);
//			pstm.setString(1, userName);
//			rs = pstm.executeQuery();
//			while (rs.next()) {
//				user = new UserBean(userName, rs.getString("Password"), rs.getString("HoTen"), rs.getString("Email"),
//						rs.getInt("Type"), rs.getBoolean("Active"));
//			}
//
//		} catch (Exception ex) {
//			getMessenger(ex);
//		} finally {
//			tryToClose(cnn);
//			tryToClose(pstm);
//			tryToClose(rs);
//		}
//		return user;
//	}
}
