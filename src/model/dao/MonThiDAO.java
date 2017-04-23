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
			String sql = "INSERT INTO MONTHI VALUES(?,?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setNString(2, monThi.getTenMonThi());
			pstm.setInt(3, monThi.getTrangThaiMonThi());
			pstm.setInt(4, monThi.getHeSo());
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
