package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.MonThiBean;

public class MonThiDAO extends DataAccessObject {
	public List<MonThiBean> getListMonThi(String maKyThi){
		List<MonThiBean> lst = new ArrayList<MonThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM MONTHI WHERE maKyThi = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			rs = pstm.executeQuery();
			MonThiBean mt = null;
			while (rs.next()) {
				mt = new MonThiBean(rs.getString("maMonThi"), rs.getString("maKyThi"), rs.getString("tenMonThi"), rs.getInt("trangThaiMonThi"), 
						 rs.getInt("coSoPhongThi"),rs.getInt("coSoTui"), rs.getInt("soLuot"), rs.getInt("heSo"));
				lst.add(mt);
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
	public MonThiBean getMonThi(String maMonThi){		
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;	
		MonThiBean mt = null;
		try {
			String sql = "SELECT * FROM MONTHI WHERE maMonThi = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maMonThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				mt = new MonThiBean(rs.getString("maMonThi"), rs.getString("maKyThi"), rs.getString("tenMonThi"), rs.getInt("trangThaiMonThi"), 
						 rs.getInt("coSoPhongThi"),rs.getInt("coSoTui"), rs.getInt("soLuot"), rs.getInt("heSo"));
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return mt;
	}
	public boolean insert(String maKyThi, MonThiBean monThi){
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO MONTHI VALUES(?,?,?,?,?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setNString(2, monThi.getTenMonThi());
			pstm.setInt(3, 0);
			pstm.setInt(4, 0);
			pstm.setInt(5, 0);
			pstm.setInt(6, 0);
			pstm.setInt(7, monThi.getHeSo());
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
	public boolean update(String maKyThi, MonThiBean monThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update MONTHI Set tenMonThi=?, trangThaiMonThi=?, coSoPhongThi=?, coSoTui=?, heSo=?, soLuot=? where maMonThi=? and maKyThi=? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(7, monThi.getMaMonThi());
			pstm.setString(8, maKyThi);
			pstm.setString(1, monThi.getTenMonThi());
			pstm.setInt(2, monThi.getTrangThaiMonThi());
			pstm.setInt(3, monThi.getCoSoPhongThi());
			pstm.setInt(4, monThi.getCoSoTui());
			pstm.setInt(5, monThi.getHeSo());
			pstm.setInt(6, monThi.getSoLuot());
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
	public boolean delete(String maKyThi){
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Delete from MONTHI where maKyThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
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
	public boolean updateDonTui(String maMonThi, int coSoPhongThi, int coSoTui, int soLuot){
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update MONTHI Set coSoPhongThi = ?, coSoTui = ?, soLuot = ? where maMonThi=? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, coSoPhongThi);
			pstm.setInt(2, coSoTui);
			pstm.setInt(3, soLuot);
			pstm.setString(4, maMonThi);	
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
	public boolean updateTrangThai(String maMonThi, int trangThai){
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update KYTHI Set trangThai=? where maKyThi=? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, trangThai);
			pstm.setString(2, maMonThi);		
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
}
