package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.TKBaiThiBean;
import model.bean.TKBaiThiThanhTichBean;
import model.bean.TKChiTietLanThiBean;
import model.bean.TKThanhVienBean;


public class ThongKeDAO extends DataAccessObject{
	
	//Lấy danh sách thống kê thành viên trong cơ sở dữ liệu.
	//Input: NULL -> output List<> | Table ThongKeThanhVien
	public List<TKThanhVienBean> getListThongKeThanhVien(){
		List<TKThanhVienBean> lst= new ArrayList<TKThanhVienBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM ThongKeThanhVien ORDER BY TongCauDung DESC,SoBaiThi DESC,TongCauHoi DESC";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TKThanhVienBean ch =  new TKThanhVienBean(rs.getString("IDUser"),rs.getString("HoTen"),rs.getInt("SoBaiThi"),
						rs.getInt("TongCauHoi"),rs.getInt("TongCauDung"));
				lst.add(ch);
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
	public List<TKThanhVienBean> getListThongKeThanhVien(int top){
		List<TKThanhVienBean> lst= new ArrayList<TKThanhVienBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT TOP(?) * FROM ThongKeThanhVien ORDER BY TongCauDung DESC,SoBaiThi DESC,TongCauHoi DESC";
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, top);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TKThanhVienBean ch =  new TKThanhVienBean(rs.getString("IDUser"),rs.getString("HoTen"),rs.getInt("SoBaiThi"),
						rs.getInt("TongCauHoi"),rs.getInt("TongCauDung"));
				lst.add(ch);
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
	public TKThanhVienBean getThongKeThanhVien(String idUser){
		TKThanhVienBean tk=new TKThanhVienBean(idUser, null, 0, 0, 0);
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM ThongKeThanhVien WHERE IDUser=? ORDER BY TongCauDung DESC,SoBaiThi DESC,TongCauHoi DESC";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idUser);
			rs = pstm.executeQuery();
			while (rs.next()) {
				tk =  new TKThanhVienBean(rs.getString("IDUser"),rs.getString("HoTen"),rs.getInt("SoBaiThi"),
						rs.getInt("TongCauHoi"),rs.getInt("TongCauDung"));
			}

		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}	
		return tk;		
	}
	
	//Lấy danh sách thống kê bài thi trong cơ sở dữ liệu.
	//Input: NULL -> output List<> | Table ThongKeBaiThi
	public List<TKBaiThiBean> getListThongKeBaiThi(){
		List<TKBaiThiBean> lst= new ArrayList<TKBaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM ThongKeBaiThi ORDER BY SoLuotLam DESC,TiLeLamDuoc DESC,SoCauHoi DESC";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TKBaiThiBean ch =  new TKBaiThiBean(rs.getString("IDBaiThi"),rs.getString("TenBaiThi"),
						rs.getInt("SoCauHoi"),rs.getInt("SoLuotLam"),rs.getDouble("TiLeLamDuoc"),rs.getString("idUser"));
				lst.add(ch);
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
	public List<TKBaiThiBean> getListThongKeBaiThi(int top){
		List<TKBaiThiBean> lst= new ArrayList<TKBaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT TOP(?) * FROM ThongKeBaiThi ORDER BY SoLuotLam DESC,TiLeLamDuoc DESC,SoCauHoi DESC";
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, top);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TKBaiThiBean ch =  new TKBaiThiBean(rs.getString("IDBaiThi"),rs.getString("TenBaiThi"),
						rs.getInt("SoCauHoi"),rs.getInt("SoLuotLam"),rs.getDouble("TiLeLamDuoc"),rs.getString("idUser"));
				lst.add(ch);
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
	
	public List<TKBaiThiBean> getListThongKeBaiThi(String idUser){
		List<TKBaiThiBean> lst= new ArrayList<TKBaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM ThongKeBaiThi WHERE IDUser=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1,idUser);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TKBaiThiBean ch =  new TKBaiThiBean(rs.getString("IDBaiThi"),rs.getString("TenBaiThi"),
						rs.getInt("SoCauHoi"),rs.getInt("SoLuotLam"),rs.getDouble("TiLeLamDuoc"),rs.getString("idUser"));

				lst.add(ch);
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
	
	
	//Thống kê Chi tiết 1 lần thi trong cơ sở dữ liệu
	//Input: idLanThi -> output List<> | Table ChiTietLanThi
	public List<TKChiTietLanThiBean> getListThongKeChiTietLanThi(String idLanThi){
		List<TKChiTietLanThiBean> lst= new ArrayList<TKChiTietLanThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM ChiTietLanThi Where IDLanThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idLanThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TKChiTietLanThiBean ch =  new TKChiTietLanThiBean(rs.getString("IDLanThi"),rs.getString("NoiDung"),rs.getString("CauTraLoi"),rs.getString("DapAn"));
				lst.add(ch);
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
	
	//Thống kê Bài thi_Thành tích
	//Thống kê 1 bài thi có: danh sách user làm bài thi
	//Input: idBaiThi -> output List<> | Table BaiThiThanhTich
//	public List<BaiThiThanhTich> getChiTietBaiThi(String idBaiThi){
//		
//	}
	public List<TKBaiThiThanhTichBean> getListThongKeBaiThiThanhTich(String idBaiThi){
		List<TKBaiThiThanhTichBean> lst= new ArrayList<TKBaiThiThanhTichBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM BaiThiThanhTich Where IDBaiThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idBaiThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TKBaiThiThanhTichBean ch =  new TKBaiThiThanhTichBean(rs.getString("IDBaiThi"),rs.getString("TenBaiThi"),rs.getString("IDUser"),
						rs.getString("HoTen"),rs.getInt("SoCauTraLoiDung"),rs.getLong("ThoiGianThi"),rs.getLong("ThoiGianLamBai"), rs.getString("IDLanThi"));
				lst.add(ch);
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
	
	
	//Thống kê 1 user có: danh sách bài thi đã làm
	//Input: idBaiThi -> output List<> | Table BaiThiThanhTich
//	public List<BaiThiThanhTich> getChiTietThanhTich(String idUser){
//		
//	}
	public List<TKBaiThiThanhTichBean> getListThanhTichUser(String idUser){
		List<TKBaiThiThanhTichBean> lst= new ArrayList<TKBaiThiThanhTichBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM BaiThiThanhTich Where IDUser=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idUser);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TKBaiThiThanhTichBean ch =  new TKBaiThiThanhTichBean(rs.getString("IDBaiThi"),rs.getString("TenBaiThi"),rs.getString("IDUser"),rs.getString("HoTen"),rs.getInt("SoCauTraLoiDung"),
						rs.getLong("ThoiGianThi"),rs.getLong("ThoiGianLamBai"), rs.getString("IDLanThi"));
				lst.add(ch);
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
