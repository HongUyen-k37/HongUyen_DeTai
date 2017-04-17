package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.PhongThiBean;


public class PhongThiDAO extends DataAccessObject {
	public List<PhongThiBean> getListPhongThi(){
		List<PhongThiBean> lst = new ArrayList<PhongThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM PHONGTHI";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			PhongThiBean pt = null;
			while (rs.next()) {
				pt = new PhongThiBean(rs.getString("maPhongThi"), rs.getString("maKyThi"), rs.getString("soHieuPhongThi"), rs.getInt("soLuongThiSinh"));
				lst.add(pt);
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
	public List<PhongThiBean> getListPhongThiTheoMaKyThi(String maKyThi){
		List<PhongThiBean> lst = new ArrayList<PhongThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM PHONGTHI WHERE maKyThi = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			rs = pstm.executeQuery();
			PhongThiBean pt = null;
			while (rs.next()) {
				pt = new PhongThiBean(rs.getString("maPhongThi"), rs.getString("maKyThi"), rs.getString("soHieuPhongThi"), rs.getInt("soLuongThiSinh"));
				lst.add(pt);
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
	public PhongThiBean getPhongThi(String maPhongThi) {
		PhongThiBean pt = null;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM PHONGTHI where maPhongThi = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maPhongThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				pt = new PhongThiBean(rs.getString("maPhongThi"), rs.getString("maKyThi"), rs.getString("soHieuPhongThi"), rs.getInt("soLuongThiSinh"));
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return pt;
	}
	public boolean insert(PhongThiBean phongThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO PHONGTHI VALUES(?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, phongThi.getMaKyThi());
			pstm.setString(2, phongThi.getSoHieuPhongThi());
			pstm.setInt(3, phongThi.getSoLuongThiSinh());
			
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
	
	public boolean update(PhongThiBean phongThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update PHONGTHI Set maKyThi=?, soHieuPhongThi=?, soLuongThiSinh=? where maPhongThi=? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(4, phongThi.getMaPhongThi());
			pstm.setString(1, phongThi.getMaKyThi());
			pstm.setString(2, phongThi.getSoHieuPhongThi());
			pstm.setInt(3, phongThi.getSoLuongThiSinh());	
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
	public boolean delete(String maPhongThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Delete from PHONGTHI where maPhongThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maPhongThi);
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
	
}
