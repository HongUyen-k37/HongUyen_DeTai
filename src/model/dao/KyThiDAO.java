package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.KyThiBean;
import model.bean.MonThiBean;

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
						rs.getDouble("diemLiet"),rs.getBoolean("nhoHonDiemLiet"));
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
	
	public void insert(KyThiBean kyThi, List<MonThiBean> listMonThi) {
		ResultSet rs = null;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		String maKyThi = null;
		try {
			String sql = "INSERT INTO KYTHI OUTPUT Inserted.maKyThi VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, kyThi.getTenKyThi());
			pstm.setString(2, kyThi.getNgayThi());
			pstm.setInt(3, kyThi.getNamTuyenSinh());
			pstm.setString(4, kyThi.getNganh());
			pstm.setString(5, kyThi.getHinhThucDT());
			pstm.setString(6, kyThi.getCoSoLKDT());
			pstm.setInt(7, kyThi.getSoMonThi());
			pstm.setInt(8, kyThi.getTrangThai());
			pstm.setString(9, kyThi.getTiepDauNgu());
			pstm.setInt(10, kyThi.getSoBatDau());
			pstm.setInt(11, kyThi.getSoLuongChuSo());
			pstm.setDouble(12, (float) kyThi.getDiemChuan());
			pstm.setDouble(13, kyThi.getDiemLiet());
			pstm.setBoolean(14, kyThi.isNhoHonDiemLiet());
			rs = pstm.executeQuery();
			while(rs.next()){
				maKyThi = rs.getString("maKyThi");
				for (MonThiBean monThi : listMonThi) {
					MonThiDAO mt = new MonThiDAO();
					mt.insert(maKyThi, monThi);
				}
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
	}
	
	public boolean update(KyThiBean kyThi, List<MonThiBean> listMonThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update KYTHI Set tenKyThi=?, ngayThi=?, namTuyenSinh=?, nganh=?, hinhThucDT=?, coSoLKDT=?, soMonThi=?,"
					+ "trangThai=?, tiepDauNgu=?, soBatDau=?, soLuongChuSo=?, diemChuan=?, diemLiet=?, nhoHonDiemLiet=? where maKyThi=? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(15, kyThi.getMaKyThi());
			pstm.setString(1, kyThi.getTenKyThi());
			pstm.setString(2, kyThi.getNgayThi());
			pstm.setInt(3, kyThi.getNamTuyenSinh());
			pstm.setString(4, kyThi.getNganh());
			pstm.setString(5, kyThi.getHinhThucDT());
			pstm.setString(6, kyThi.getCoSoLKDT());
			pstm.setInt(7, listMonThi.size());
			pstm.setInt(8, kyThi.getTrangThai());
			pstm.setString(9, kyThi.getTiepDauNgu());
			pstm.setInt(10, kyThi.getSoBatDau());
			pstm.setInt(11, kyThi.getSoLuongChuSo());
			pstm.setDouble(12, (float) kyThi.getDiemChuan());
			pstm.setDouble(13, kyThi.getDiemLiet());
			pstm.setBoolean(14, kyThi.isNhoHonDiemLiet());
			MonThiDAO mt = new MonThiDAO();
			if(listMonThi.size()==mt.getListMonThi(kyThi.getMaKyThi()).size()){
				for (MonThiBean monThi : listMonThi) {
					mt.update(kyThi.getMaKyThi(), monThi);
				}
				pstm.executeUpdate();
			}
			else{
				mt.delete(kyThi.getMaKyThi());
				for (MonThiBean monThi : listMonThi) {
					mt.insert(kyThi.getMaKyThi(), monThi);
				}
			}
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
						rs.getDouble("diemChuan"), rs.getDouble("diemLiet"),rs.getBoolean("nhoHonDiemLiet"));
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
						rs.getDouble("diemChuan"), rs.getDouble("diemLiet"),rs.getBoolean("nhoHonDiemLiet"));
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
	public boolean xacDinhDiemChuan(String maKyThi, float diemChuan, float diemLiet, boolean nhoHonDiemLiet) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update KYTHI Set diemChuan=?, diemLiet=?, nhoHonDiemLiet=? where maKyThi=? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setFloat(1, diemChuan);
			pstm.setFloat(2, diemLiet);
			pstm.setBoolean(3, nhoHonDiemLiet);
			pstm.setString(4, maKyThi);
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
	public boolean updateTrangThai(String maKyThi, int trangThai){
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update KYTHI Set trangThai=? where maKyThi=? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, trangThai);
			pstm.setString(2,maKyThi);		
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
