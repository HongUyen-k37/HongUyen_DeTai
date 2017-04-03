package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.UserBean;

public class UserDAO extends DataAccessObject{
	
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

	public boolean updateUser(UserBean user) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update [User] Set HoTen=?,Email=?,SDT=?,DonVi=?,DiaChi=?,Role=?,Active=?,Password=? Where IDUser=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(9, user.getIdUser());
			pstm.setString(1, user.getHoTen());
			pstm.setString(2, user.getEmail());
			pstm.setString(3, user.getSdt());
			pstm.setString(4, user.getDonVi());
			pstm.setString(5, user.getDiaChi());
			pstm.setInt(6, user.getRole());
			pstm.setBoolean(7, user.isActive());
			pstm.setString(8, user.getPassword());
			pstm.executeUpdate();
			result=true;
		} catch (Exception ex) {
			result = false;
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
		return result;
	}

	public boolean resetPassword(String iDUser) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update [User] Set Password='12345' Where IDUser=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, iDUser);		
			pstm.executeUpdate();
			result = true;
		} catch (Exception ex) {
			result = false;
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
		return result;
	}
	
	
	public List<UserBean> searchUser(String string)
	{
		List<UserBean> lst = new ArrayList<UserBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM [User] Where UserName like ? OR HoTen like ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, '%'+string+'%');
			pstm.setString(2, '%'+string+'%');
			rs = pstm.executeQuery();
			while (rs.next()) {
				String idUser = rs.getString("IDUser");
				String hoTen = rs.getString("HoTen");
				String diaChi = rs.getString("DiaChi");
				String email = rs.getString("Email");
				String sDT = rs.getString("SDT");
				String donVi = rs.getString("DonVi");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				int role = rs.getInt("Role");
				boolean active = rs.getBoolean("Active");
				UserBean user = new UserBean(idUser, hoTen, diaChi, email, sDT, donVi, username, password, role, active);
				lst.add(user);		
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return lst;		
	}	
	
//Nên để qua ThongKeDAO
	
//	public List<BaiThi_ThanhTichViewBean> getChiTietBaiThi_ThanhTich(String idUser) {
//		List<BaiThi_ThanhTichViewBean> lst = new ArrayList<BaiThi_ThanhTichViewBean>();
//		Connection cnn = getConnection();
//		ResultSet rs = null;
//		PreparedStatement pstm = null;
//		try {
//			String sql = "SELECT * FROM BaiThiThanhTich where IDUser = ?";
//			pstm = cnn.prepareStatement(sql);
//			pstm.setString(1, idUser);
//			rs = pstm.executeQuery();
//			String idBaiThi, tenBaiThi, hoTen;
//			int soCauTraLoiDung;
//			long thoiGianThi, thoiGianLamBai;
//			while (rs.next()) {
//				idBaiThi = rs.getString("IDBaiThi");
//				tenBaiThi = rs.getString("TenBaiThi");
//				idUser = rs.getString("IDUser");
//				hoTen = rs.getString("HoTen");			
//				soCauTraLoiDung = rs.getInt("SoCauTraLoiDung");
//				thoiGianThi = rs.getLong("ThoiGianThi");
//				thoiGianLamBai = rs.getLong("ThoiGianLamBai");
//				lst.add(new BaiThi_ThanhTichViewBean(idBaiThi, tenBaiThi, idUser, hoTen, soCauTraLoiDung, thoiGianThi, thoiGianLamBai));
//			}
//		} catch (Exception ex) {
//			getMessenger(ex);
//		} finally {
//			tryToClose(cnn);
//			tryToClose(pstm);
//			tryToClose(rs);
//		}
//		return lst;
//	}
	
	public List<UserBean> getListUser() {
		List<UserBean> lst = new ArrayList<UserBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM [User] WHERE Role<>1";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();	
			while (rs.next()) {
				String idUser = rs.getString("IDUser");
				String hoTen = rs.getString("HoTen");
				String diaChi = rs.getString("DiaChi");
				String email = rs.getString("Email");
				String sDT = rs.getString("SDT");
				String donVi = rs.getString("DonVi");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				int role = rs.getInt("Role");
				boolean active = rs.getBoolean("Active");
				UserBean user = new UserBean(idUser, hoTen, diaChi, email, sDT, donVi, username, password, role, active);
				lst.add(user);	
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return lst;
	}
	public UserBean getUser(String idUser) {
		UserBean user = null;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM [User] where IDUser=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idUser);
			rs = pstm.executeQuery();
			while (rs.next()) {
				user = new UserBean(rs.getString("IDUser"), 
						rs.getString("HoTen"), rs.getString("DiaChi"), rs.getString("Email"), 
						rs.getString("SDT"), rs.getString("DonVi"), rs.getString("UserName"), 
						rs.getString("Password"),rs.getInt("Role"), rs.getBoolean("Active"));
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
	
	public void changeActive(String idUser) {
		Connection cnn = getConnection();		
		PreparedStatement pstm = null;
		if(getUser(idUser) != null){		
			try {					
				String sql = "Update [User] Set Active = ? Where IDUser=?";
				pstm = cnn.prepareStatement(sql);
				pstm.setBoolean(1, !getUser(idUser).isActive());
				pstm.setString(2, idUser);		
				pstm.executeUpdate();
			} catch (Exception ex) {	
				getMessenger(ex);
			} finally {
				tryToClose(cnn);
				tryToClose(pstm);
			}
		}
	}

	public UserBean getUserByUsername(String username) {
		UserBean user = null;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM [User] where UserName=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, username);
			rs = pstm.executeQuery();
			while (rs.next()) {
				user = new UserBean(rs.getString("IDUser"), 
						rs.getString("HoTen"), rs.getString("DiaChi"), rs.getString("Email"), 
						rs.getString("SDT"), rs.getString("DonVi"), rs.getString("UserName"), 
						rs.getString("Password"),rs.getInt("Role"), rs.getBoolean("Active"));
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
