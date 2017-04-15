package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.ThiSinhBean;

public class ThiSinhDAO extends DataAccessObject{
	public List<ThiSinhBean> getListThiSinh(String maKyThi){
		List<ThiSinhBean> lst = new ArrayList<ThiSinhBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM THISINH WHERE maKyThi = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			rs = pstm.executeQuery();
			ThiSinhBean ts = null;
			while (rs.next()) {
				ts = new ThiSinhBean(rs.getString("maThiSinh"), rs.getString("maKyThi"), rs.getString("maPhongThi"), rs.getString("hoDem"),
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
				ts = new ThiSinhBean(rs.getString("maThiSinh"), rs.getString("maKyThi"), rs.getString("maPhongThi"), rs.getString("hoDem"),
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
	public boolean danhSoBaoDanh(String tiepDauNgu, int soBatDau, int soLuong, String maKyThi){
		if(tiepDauNgu==null || tiepDauNgu.equals("")) System.out.println("Nothing");
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "EXEC DanhSoBaoDanh ?, ?, ?, ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, tiepDauNgu);
			pstm.setInt(2, soBatDau);
			pstm.setInt(3, soLuong);
			pstm.setString(4, maKyThi);
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
	
	public boolean insert(ThiSinhBean thiSinh) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO THISINH VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, thiSinh.getMaKyThi());
			pstm.setString(2, thiSinh.getMaPhongThi());
			pstm.setString(3, thiSinh.getHoDem());
			pstm.setString(4, thiSinh.getTen());
			pstm.setString(5, thiSinh.getNgaySinh());
			pstm.setString(6, thiSinh.getNoiSinh());	
			pstm.setString(7, thiSinh.getKhuVuc());
			pstm.setString(8, thiSinh.getDoiTuong());
			pstm.setString(9, thiSinh.getDienThoai());
			pstm.setString(10, thiSinh.getEmail());
			pstm.setString(11, thiSinh.getDiaChi());
			pstm.setString(12, thiSinh.getSoBaoDanh());
			
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
	
	public boolean update(ThiSinhBean thiSinh) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update THISINH Set hoDem=?, ten=?, ngaySinh=?, noiSinh=?, khuVuc=?, doiTuong=?, dienThoai=?,"
					+ "email=?, diaChi=? where maThiSinh=? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(10, thiSinh.getMaThiSinh());
			pstm.setString(1, thiSinh.getHoDem());
			pstm.setString(2, thiSinh.getTen());
			pstm.setString(3, thiSinh.getNgaySinh());
			pstm.setString(4, thiSinh.getNoiSinh());	
			pstm.setString(5, thiSinh.getKhuVuc());
			pstm.setString(6, thiSinh.getDoiTuong());
			pstm.setString(7, thiSinh.getDienThoai());
			pstm.setString(8, thiSinh.getEmail());
			pstm.setString(9, thiSinh.getDiaChi());	
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
	
	public boolean delete(String maThiSinh) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Delete from THISINH where maThiSinh=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maThiSinh);
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
	public List<ThiSinhBean> searchThiSinh(String key){
		List<ThiSinhBean> lst = new ArrayList<ThiSinhBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM THISINH where ten Like N'%"+key +"%' or khuVuc Like N'%"+key+"%'";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			ThiSinhBean ts = null;
			while (rs.next()) {
				ts = new ThiSinhBean(rs.getString("maThiSinh"), rs.getString("maKyThi"), rs.getString("maPhongThi"), rs.getString("hoDem"),
						rs.getString("ten"), rs.getString("ngaySinh"), rs.getString("noiSinh"), rs.getString("khuVuc"),
						rs.getString("doiTuong"), rs.getString("dienThoai"), rs.getString("email"), rs.getString("diaChi"),
						rs.getString("soBaoDanh")) ;
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
	public List<ThiSinhBean> getListThiSinhTheoPhongThi(String maPhongThi){
		List<ThiSinhBean> lst = new ArrayList<ThiSinhBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM THISINH WHERE maPhongThi = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maPhongThi);
			rs = pstm.executeQuery();
			ThiSinhBean ts = null;
			while (rs.next()) {
				ts = new ThiSinhBean(rs.getString("maThiSinh"), rs.getString("maKyThi"), rs.getString("maPhongThi"), rs.getString("hoDem"),
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
}
