package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.KyThiBean;

public class KyThiDAO extends DataAccessObject{
	public List<KyThiBean> getListKyThi(){
		List<KyThiBean> lst = new ArrayList<KyThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM KYTHI";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			KyThiBean kt = null;
			while (rs.next()) {
				kt = new KyThiBean(rs.getString("maKyThi"), rs.getString("tenKyThi"), rs.getString("ngayThi"), rs.getInt("namTuyenSinh"),
						rs.getString("nganh"), rs.getString("hinhThucDT"), rs.getString("coSoLKDT"), rs.getInt("soMonThi"),
						rs.getInt("trangThai"), rs.getString("tiepDauNgu"),
						rs.getInt("soBatDau"), rs.getInt("soLuongChuSo"), rs.getDouble("diemChuan"),
						rs.getDouble("diemLiet"));
				lst.add(kt);
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
	
	public boolean insert(KyThiBean kyThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO KYTHI VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, kyThi.getTenKyThi());
			pstm.setString(2, kyThi.getNgayThi());
			pstm.setInt(3, kyThi.getNamTuyenSinh());
			pstm.setString(4, kyThi.getNganh());
			pstm.setString(5, kyThi.getHinhThucDT());
			pstm.setString(6, kyThi.getCoSoLKDT());
			pstm.setInt(7, kyThi.getSoMonThi());
			pstm.setString(8, kyThi.getTiepDauNgu());
			pstm.setInt(9, kyThi.getSoBatDau());
			pstm.setInt(10, kyThi.getSoLuongChuSo());
			pstm.setDouble(11, (float) kyThi.getDiemChuan());
			pstm.setDouble(12, kyThi.getDiemLiet());
			pstm.setInt(13, kyThi.getTrangThai());
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
	
	public boolean update(KyThiBean kyThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update KYTHI Set tenKyThi=?, ngayThi=?, namTuyenSinh=?, nganh=?, hinhThucDT=?, coSoLKDT=?, soMonThi=?,"
					+ "trangThai=?, tiepDauNgu=?, soBatDau=?, soLuongChuSo=?, diemChuan=?, diemLiet=? where maKyThi=? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(14, kyThi.getMaKyThi());
			pstm.setString(1, kyThi.getTenKyThi());
			pstm.setString(2, kyThi.getNgayThi());
			pstm.setInt(3, kyThi.getNamTuyenSinh());
			pstm.setString(4, kyThi.getNganh());
			pstm.setString(5, kyThi.getHinhThucDT());
			pstm.setString(6, kyThi.getCoSoLKDT());
			pstm.setInt(7, kyThi.getSoMonThi());
			pstm.setString(8, kyThi.getTiepDauNgu());
			pstm.setInt(9, kyThi.getSoBatDau());
			pstm.setInt(10, kyThi.getSoLuongChuSo());
			pstm.setDouble(11, (float) kyThi.getDiemChuan());
			pstm.setDouble(12, kyThi.getDiemLiet());
			pstm.setInt(13, kyThi.getTrangThai());
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
	
	public boolean delete(String maKyThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Delete from KYTHI where maKyThi=?";
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
	
	public KyThiBean getKyThi(String maKyThi) {
		KyThiBean kt=null;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM KYTHI where maKyThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				kt = new KyThiBean(rs.getString("maKyThi"), rs.getString("tenKyThi"), rs.getString("ngayThi"), rs.getInt("namTuyenSinh"),
						rs.getString("nganh"), rs.getString("hinhThucDT"), rs.getString("coSoLKDT"), rs.getInt("soMonThi"), 
						rs.getInt("trangThai"), rs.getString("tiepDauNgu"), rs.getInt("soBatDau"), rs.getInt("soLuongChuSo"), 
						rs.getDouble("diemChuan"), rs.getDouble("diemLiet"));
			}
	
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return kt;
	}
	public List<KyThiBean> searchKyThi(String key){
		List<KyThiBean> lst = new ArrayList<KyThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM KYTHI where tenKyThi Like N'%"+key+"%' or nganh Like N'%"+key+"%'";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			KyThiBean kt = null;
			while (rs.next()) {
				kt = new KyThiBean(rs.getString("maKyThi"), rs.getString("tenKyThi"), rs.getString("ngayThi"), rs.getInt("namTuyenSinh"),
						rs.getString("nganh"), rs.getString("hinhThucDT"), rs.getString("coSoLKDT"), rs.getInt("soMonThi"), 
						rs.getInt("trangThai"), rs.getString("tiepDauNgu"), rs.getInt("soBatDau"), rs.getInt("soLuongChuSo"), 
						rs.getDouble("diemChuan"), rs.getDouble("diemLiet"));
				lst.add(kt);
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
