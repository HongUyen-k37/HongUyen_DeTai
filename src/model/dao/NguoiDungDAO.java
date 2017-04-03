package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.bean.NguoiDungBean;

public class NguoiDungDAO extends DataAccessObject{
	public boolean checkLogin(String userName, String password) {
		boolean result = false;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM [NGUOIDUNG] where tenDangNhap=? AND matKhau=?";
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
	public NguoiDungBean getUserByUsername(String username) {
		NguoiDungBean user = null;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM [NguoiDung] where tenDangNhap=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, username);
			rs = pstm.executeQuery();
			while (rs.next()) {
				user = new NguoiDungBean(rs.getString("tenDangNhap"), rs.getString("matKhau"));
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return user;
	}
}
