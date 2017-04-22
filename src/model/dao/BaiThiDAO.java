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
		pstm.setString(9, baiThi.getGhiChu());
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
			String sql = "SELECT * FROM BAITHI WHERE maKyThi = ? and maMonThi = ? and tuiSo = ?";
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
	public boolean nhapDiem(String maKyThi, String maMonThi, int soPhach, float diemSo, String diemChu) {
		boolean result = false;
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
