package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.BaiThiBean;
import model.bean.ThongKeBean;

public class ThongKeDAO extends DataAccessObject{
	public List<ThongKeBean> tkBangDiemTheoMon(String maKyThi, String maMonThi){
		List<ThongKeBean> lst= new ArrayList<ThongKeBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM TKBangDiemTheoMon WHERE maKyThi=? and maMonThi=? ORDER BY ten, hoDem";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maMonThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ThongKeBean tk =  new ThongKeBean(rs.getString("hoDem"),rs.getString("ten"),rs.getString("ngaySinh"),
						rs.getString("soBaoDanh"),rs.getInt("soPhach"), rs.getFloat("diemChinhThuc"), rs.getString("ghiChu"));
				lst.add(tk);
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
	public List<BaiThiBean> tkBienBanChamThi(String maKyThi, String maMonThi){
		List<BaiThiBean> lst= new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM BAITHI WHERE maKyThi=? and maMonThi=? order by soPhach";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maMonThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				BaiThiBean bt = new BaiThiBean(maKyThi, maMonThi, rs.getString("maThiSinh"), rs.getInt("soPhach"),
						rs.getInt("tuiSo"), rs.getInt("trangThaiDuThi"), rs.getFloat("diemChamThi"), rs.getFloat("diemChinhThuc"), rs.getString("ghiChu"));
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
	public List<BaiThiBean> tkBienBanTongHopChamThi(String maKyThi, String maMonThi, int tuiSo){
		List<BaiThiBean> lst= new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM BAITHI WHERE maKyThi=? and maMonThi=? and tuiSo = ? order by soPhach";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maMonThi);
			pstm.setInt(3, tuiSo);
			rs = pstm.executeQuery();
			while (rs.next()) {
				BaiThiBean bt = new BaiThiBean(maKyThi, maMonThi, rs.getString("maThiSinh"), rs.getInt("soPhach"),
						rs.getInt("tuiSo"), rs.getInt("trangThaiDuThi"), rs.getFloat("diemChamThi"), rs.getFloat("diemChinhThuc"), rs.getString("ghiChu"));
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