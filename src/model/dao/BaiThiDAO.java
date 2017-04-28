package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.BaiThiBean;

public class BaiThiDAO extends DataAccessObject{
	public boolean insert(BaiThiBean baiThi) {
	boolean result = false;
	Connection cnn = getConnection();
	PreparedStatement pstm = null;
	try {
		if(baiThi.getTrangThaiDuThi()==5){
			baiThi.setGhiChu("Vắng thi");
		}
		if(baiThi.getTrangThaiDuThi()==4){
			baiThi.setGhiChu("Đình chỉ thi");
		}
		if(baiThi.getTrangThaiDuThi()==3){
			baiThi.setGhiChu("Cảnh cáo");
		}
		if(baiThi.getTrangThaiDuThi()==2){
			baiThi.setGhiChu("Khiển trách");
		}
		String sql = "INSERT INTO BAITHI VALUES (?,?,?,?,?,?,?,?,?) ";
		pstm = cnn.prepareStatement(sql);
		pstm.setString(1, baiThi.getMaKyThi());
		pstm.setString(2, baiThi.getMaMonThi());
		pstm.setString(3, baiThi.getMaThiSinh());
		pstm.setInt(4, baiThi.getSoPhach());
		pstm.setInt(5, baiThi.getTuiSo());
		pstm.setInt(6, baiThi.getTrangThaiDuThi());
		pstm.setFloat(7, baiThi.getDiemChamThi());
		pstm.setFloat(8, baiThi.getDiemChinhThuc());
		pstm.setNString(9, baiThi.getGhiChu());
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
	public List<BaiThiBean> getList(String maKyThi, String maMonThi, String maThiSinh){
		List<BaiThiBean> lst=new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM BAITHI WHERE maKyThi = ? and maMonThi = ? and maThiSinh = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maMonThi);
			pstm.setString(3, maThiSinh);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getString("maKyThi"), rs.getString("maMonThi"), rs.getString("maThiSinh"),
						rs.getInt("soPhach"), rs.getInt("tuiSo"), rs.getInt("trangThaiDuThi"), rs.getFloat("diemChamThi"),
						rs.getFloat("diemChinhThuc"), rs.getString("ghiChu"));
				lst.add(bt);
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
	public boolean update(String maKyThi, String maMonThi, String maThiSinh, int trangThaiDuThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		String ghiChu = null;
		try {
			if(trangThaiDuThi==5){
				ghiChu = "Vắng thi";
			}
			if(trangThaiDuThi==4){
				ghiChu = "Đình chỉ thi";
			}
			if(trangThaiDuThi==3){
				ghiChu = "Cảnh cáo";
			}
			if(trangThaiDuThi==2){
				ghiChu = "Khiển trách";
			}
			String sql = "Update BAITHI Set trangThaiDuThi = ?, ghiChu = ? where maKyThi = ? and maMonThi = ? and maThiSinh = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, trangThaiDuThi);
			pstm.setNString(2, ghiChu);
			pstm.setString(3, maKyThi);
			pstm.setString(4, maMonThi);
			pstm.setString(5, maThiSinh);
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
	public List<BaiThiBean> getListTheoTui(String maKyThi, String maMonThi, int tuiSo){
		List<BaiThiBean> lst=new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM BAITHI WHERE maKyThi = ? and maMonThi = ? and tuiSo = ? and trangThaiDuThi <> 5 ORDER BY soPhach";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maMonThi);
			pstm.setInt(3, tuiSo);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getString("maKyThi"), rs.getString("maMonThi"), rs.getString("maThiSinh"),
						rs.getInt("soPhach"), rs.getInt("tuiSo"), rs.getInt("trangThaiDuThi"), rs.getFloat("diemChamThi"),
						rs.getFloat("diemChinhThuc"), rs.getString("ghiChu"));
				lst.add(bt);
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
	public List<Integer> getListTui(String maKyThi){
		List<Integer> lst = new ArrayList<>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT distinct tuiSo FROM BAITHI where maKyThi = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int tui = rs.getInt("tuiSo");
				lst.add(tui);
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
	public void nhapDiem(String maKyThi, String maMonThi, int soPhach, float diemSo) {
		//boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update BAITHI Set diemChamThi = ? where maKyThi = ? and maMonThi = ? and soPhach = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setFloat(1, diemSo);
			pstm.setString(2, maKyThi);
			pstm.setString(3, maMonThi);
			pstm.setInt(4, soPhach);
			pstm.executeUpdate();
			//result = true;
		} catch (Exception ex) {
			//result = false;
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
		//return result;
	}
	public List<BaiThiBean> getListTheoMon(String maKyThi, String maMonThi, String maPhongThi){
		List<BaiThiBean> lst=new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM BAITHI, THISINH WHERE BAITHI.maThiSinh = THISINH.maThiSinh and BAITHI.maKyThi = ?"
					+ " and maMonThi = ? and maPhongThi = ? and trangThaiDuThi <> 5";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maMonThi);
			pstm.setString(3, maPhongThi);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getString("maKyThi"), rs.getString("maMonThi"), rs.getString("maThiSinh"),
						rs.getInt("soPhach"), rs.getInt("tuiSo"), rs.getInt("trangThaiDuThi"), rs.getFloat("diemChamThi"),
						rs.getFloat("diemChinhThuc"), rs.getString("ghiChu"));
				lst.add(bt);
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
	public boolean updateDonTui(String maKyThi, String maMonThi, String maThiSinh, int tuiSo, int soPhach) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {		
			String sql = "Update BAITHI Set soPhach = ?, tuiSo = ? where maKyThi = ? and maMonThi = ? and maThiSinh = ? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, soPhach);
			pstm.setInt(2, tuiSo);
			pstm.setString(3, maKyThi);
			pstm.setString(4, maMonThi);
			pstm.setString(5, maThiSinh);
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
	public List<BaiThiBean> getListDonTui(String maKyThi, String maMonThi){
		List<BaiThiBean> lst=new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM BAITHI, THISINH, PHONGTHI WHERE BAITHI.maThiSinh = THISINH.maThiSinh "
					+ "and THISINH.maPhongThi = PHONGTHI.maPhongThi and BAITHI.maKyThi = ? and BAITHI.maMonThi = ? ORDER BY soHieuPhongThi, soBaoDanh, tuiSo";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maMonThi);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getInt("soPhach"), rs.getInt("tuiSo"), rs.getString("soHieuPhongThi"), rs.getString("soBaoDanh"));
				lst.add(bt);
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

	public boolean deleteAllScore(String maKyThi, String maMonThi, int tuiSo) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "update BAITHI set diemChamThi=0.0, diemChinhThuc = 0.0 where maKyThi=? and maMonThi=? and tuiSo=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maMonThi);
			pstm.setInt(3, tuiSo);
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
	public List<BaiThiBean> getListXuLy(String maKyThi, String maMonThi, String maPhongThi){
		List<BaiThiBean> lst=new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM BAITHI, THISINH WHERE BAITHI.maThiSinh = THISINH.maThiSinh and BAITHI.maKyThi = ?"
					+ " and maMonThi = ? and maPhongThi = ? ORDER BY ten, hoDem";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maMonThi);
			pstm.setString(3, maPhongThi);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getString("maThiSinh"), rs.getInt("trangThaiDuThi"), rs.getString("soBaoDanh"), rs.getString("hoDem"),
						rs.getString("ten"), rs.getString("ngaySinh"));
				lst.add(bt);
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
	public boolean updateDiemChinhThuc(String maKyThi, String maMonThi, String maThiSinh, float diemChinhThuc){
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update BAITHI Set diemChinhThuc = ? where maKyThi = ? and maMonThi = ? and maThiSinh = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setFloat(1, diemChinhThuc);
			pstm.setString(2, maKyThi);
			pstm.setString(3, maMonThi);
			pstm.setString(4, maThiSinh);
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
	public List<BaiThiBean> getListDiem(String maKyThi, String maMonThi){
		List<BaiThiBean> lst=new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM BAITHI WHERE maKyThi = ? and maMonThi = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maMonThi);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getString("maKyThi"), rs.getString("maMonThi"), rs.getString("maThiSinh"),
						rs.getInt("soPhach"), rs.getInt("tuiSo"), rs.getInt("trangThaiDuThi"), rs.getFloat("diemChamThi"),
						rs.getFloat("diemChinhThuc"), rs.getString("ghiChu"));
				lst.add(bt);
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
