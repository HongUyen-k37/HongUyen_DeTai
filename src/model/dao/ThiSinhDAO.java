package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.ThiSinhBean;

public class ThiSinhDAO extends DataAccessObject{
	public List<ThiSinhBean> getListThiSinh(long maKyThi){
		List<ThiSinhBean> lst = new ArrayList<ThiSinhBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM THISINH WHERE maKyThi = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setLong(1, maKyThi);
			rs = pstm.executeQuery();
			ThiSinhBean ts = null;
			while (rs.next()) {
				ts = new ThiSinhBean(rs.getLong("maThiSinh"), rs.getLong("maKyThi"), rs.getLong("maPhongThi"), rs.getString("hoDem"),
						rs.getString("ten"), rs.getString("ngaySinh"), rs.getString("noiSinh"), rs.getString("khuVuc"),
						rs.getString("doiTuong"), rs.getString("dienThoai"), rs.getString("email"), rs.getString("diaChi"),
						rs.getString("soBaoDanh"));
				lst.add(ts);
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
	public ThiSinhBean getThiSinh(String maThiSinh) {
		ThiSinhBean ts = null;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM THISINH where maThiSinh = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maThiSinh);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ts = new ThiSinhBean(rs.getLong("maThiSinh"), rs.getLong("maKyThi"), rs.getLong("maPhongThi"), rs.getString("hoDem"),
						rs.getString("ten"), rs.getString("ngaySinh"), rs.getString("noiSinh"), rs.getString("khuVuc"),
						rs.getString("doiTuong"), rs.getString("dienThoai"), rs.getString("email"), rs.getString("diaChi"),
						rs.getString("soBaoDanh"));
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return ts;
	}
	public boolean danhSoBaoDanh(String tiepDauNgu, int soBatDau, int soLuong, long maKyThi){
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "EXEC DanhSoBaoDanh ?, ?, ?, ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, tiepDauNgu);
			pstm.setInt(2, soBatDau);
			pstm.setInt(3, soLuong);
			pstm.setLong(4, maKyThi);
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