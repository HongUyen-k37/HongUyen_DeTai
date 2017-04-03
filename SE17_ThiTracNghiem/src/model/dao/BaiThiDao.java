/**
 * Kai
 * 9h30 17/02
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.BaiThiBean;
import model.bean.LoaiBaiThiBean;

public class BaiThiDao extends DataAccessObject{
	
	public boolean insert(BaiThiBean baiThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO BaiThi VALUES(?,?,?,?,?,?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, baiThi.getTenBaiThi());
			pstm.setInt(2, baiThi.getThoiGian());
			pstm.setInt(3, baiThi.getSoCauHoi());
			pstm.setString(4, baiThi.getMoTa());
			pstm.setString(5, baiThi.getIdLoai());
			pstm.setString(6, baiThi.getPassword());
			pstm.setString(7, baiThi.getIdUser());
			pstm.setBoolean(8, baiThi.isActive());
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
	
	public boolean update(BaiThiBean baiThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update BaiThi Set TenBaiThi=?,ThoiGian=?,SoCauHoi=?,MoTa=?,IDLoai=?,Password=?,Active=? Where IDBaiThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(8, baiThi.getIdBaiThi());
			pstm.setString(1, baiThi.getTenBaiThi());
			pstm.setInt(2, baiThi.getThoiGian());
			pstm.setInt(3, baiThi.getSoCauHoi());
			pstm.setString(4, baiThi.getMoTa());
			pstm.setString(5, baiThi.getIdLoai());
			pstm.setString(6, baiThi.getPassword());
			pstm.setBoolean(7, baiThi.isActive());
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
	
	public boolean delete(String idBaiThi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Delete from BaiThi where IDBaiThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idBaiThi);
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
	
	public BaiThiBean getBaiThi(String idBaiThi) {
		BaiThiBean bt=null;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM [BaiThi] where IDBaiThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idBaiThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				bt = new BaiThiBean(idBaiThi, rs.getString("TenBaiThi"), rs.getInt("ThoiGian"),
						rs.getInt("SoCauHoi"), rs.getString("MoTa"), rs.getString("IDLoai"),
						rs.getString("Password"), rs.getString("IDUser"), rs.getBoolean("Active"));
			}
	
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return bt;
	}

	public int getLuotLam(String idBaiThi) {
		int luotLam=0;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM ThongKeBaiThi where IDBaiThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idBaiThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				luotLam=rs.getInt("SoLuotLam");
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return luotLam;
	}

	public List<BaiThiBean> getListBaiThi(String idUser){
		List<BaiThiBean> lst = new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT bt.IDBaiThi,bt.TenBaiThi,bt.ThoiGian,bt.SoCauHoi,bt.MoTa,lbt.TenLoai,bt.Password,bt.IDUser,bt.Active "
					+ "FROM BaiThi AS bt inner join LoaiBaiThi as lbt on bt.IDLoai = lbt.IDLoai"
					+ " where bt.IDUser=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idUser);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getString("IDBaiThi"), rs.getString("TenBaiThi"), rs.getInt("ThoiGian"),
						rs.getInt("SoCauHoi"),rs.getString("MoTa"),rs.getString("TenLoai"),
						rs.getString("Password"),rs.getString("IDUser"), rs.getBoolean("Active"));
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
	public List<BaiThiBean> getListBaiThi(){
		List<BaiThiBean> lst = new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM BaiThiView";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getString("IDBaiThi"), rs.getString("TenBaiThi"), rs.getInt("ThoiGian"),
						rs.getInt("SoCauHoi"),rs.getString("MoTa"),rs.getString("TenLoai"),
						rs.getString("Password"),rs.getString("IDUser"), rs.getBoolean("Active"));
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
	
	public List<LoaiBaiThiBean> getListLoaiBT(){
		List<LoaiBaiThiBean> lst = new ArrayList<LoaiBaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * from LoaiBaiThi";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			LoaiBaiThiBean bt = null;
			while (rs.next()) {
				bt = new LoaiBaiThiBean(rs.getString("IDLoai"),rs.getString("TenLoai"));
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
	public List<BaiThiBean> searchBaiThi(String tenBaiThi,String idLoai,String idUser){
		List<BaiThiBean> lst = new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql =  "SELECT IDBaiThi,TenBaiThi,ThoiGian,SoCauHoi,MoTa,TenLoai,Password,IDUser,Active "
					+ "FROM BaiThi inner join LoaiBaiThi on BaiThi.IDLoai = LoaiBaiThi.IDLoai "
					+ "where TenBaiThi like ? AND BaiThi.IDLoai=? AND IDUser = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setNString(1,'%'+tenBaiThi+'%');
			pstm.setString(2, idLoai);
			pstm.setString(3,idUser);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				
				bt = new BaiThiBean(rs.getString("IDBaiThi"), rs.getString("TenBaiThi"), rs.getInt("ThoiGian"),
						rs.getInt("SoCauHoi"), rs.getString("MoTa"), rs.getString("TenLoai"),
						rs.getString("Password"), rs.getString("IDUser"),rs.getBoolean("Active")) ;
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
	public List<BaiThiBean> searchBaiThiTatCa(String tenBaiThi,String idUser){
		List<BaiThiBean> lst = new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * from BaiThi where TenBaiThi Like N'%"+tenBaiThi+"%' AND IDUser = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1,idUser);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getString("IDBaiThi"), rs.getString("TenBaiThi"), rs.getInt("ThoiGian"),
						rs.getInt("SoCauHoi"), rs.getString("MoTa"), rs.getString("IDLoai"),
						rs.getString("Password"), rs.getString("IDUser"),rs.getBoolean("Active")) ;
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
	public List<BaiThiBean> searchBaiThiALL(String tenBaiThi){
		List<BaiThiBean> lst = new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM BaiThiView where TenBaiThi Like N'%"+tenBaiThi+"%'";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getString("IDBaiThi"), rs.getString("TenBaiThi"), rs.getInt("ThoiGian"),
						rs.getInt("SoCauHoi"), rs.getString("MoTa"), rs.getString("IDLoai"),
						rs.getString("Password"), rs.getString("IDUser"),rs.getBoolean("Active")) ;
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
	public List<BaiThiBean> getListTheoDanhMuc(String idLoai){
		List<BaiThiBean> lst = new ArrayList<BaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM BaiThiView "
					+ "where IDLoai = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1,idLoai);
			rs = pstm.executeQuery();
			BaiThiBean bt = null;
			while (rs.next()) {
				bt = new BaiThiBean(rs.getString("IDBaiThi"), rs.getString("TenBaiThi"), rs.getInt("ThoiGian"),
						rs.getInt("SoCauHoi"), rs.getString("MoTa"), rs.getString("IDLoai"),
						rs.getString("Password"), rs.getString("IDUser"),rs.getBoolean("Active")) ;
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
