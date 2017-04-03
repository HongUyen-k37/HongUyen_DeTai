package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.CauHoiBean;

public class CauHoiDao extends DataAccessObject{
	public boolean insert(CauHoiBean cauHoi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO CauHoi VALUES(?,?,?,?,?,?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, cauHoi.getNoiDung());
			pstm.setString(2, cauHoi.getDapAn());
			pstm.setString(3, cauHoi.getTraLoiMot());
			pstm.setString(4, cauHoi.getTraLoiHai());
			pstm.setString(5, cauHoi.getTraLoiBa());
			pstm.setString(6, cauHoi.getTraLoiBon());
			pstm.setString(7, cauHoi.getIdUser());
			pstm.setString(8, cauHoi.getIdLoai()==null?"L0007":cauHoi.getIdLoai());
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
	public boolean update(CauHoiBean cauHoi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update CauHoi Set NoiDung=?,DapAn=?,TraLoiMot=?,TraLoiHai=?,TraLoiBa=?,TraLoiBon=?,IDLoai=? Where IDCauHoi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(8, cauHoi.getIdCauHoi());
			pstm.setString(1, cauHoi.getNoiDung());
			pstm.setString(2, cauHoi.getDapAn());
			pstm.setString(3, cauHoi.getTraLoiMot());
			pstm.setString(4, cauHoi.getTraLoiHai());
			pstm.setString(5, cauHoi.getTraLoiBa());
			pstm.setString(6, cauHoi.getTraLoiBon());
			pstm.setString(7, cauHoi.getIdLoai());
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
	
	public boolean delete(String idCauHoi) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Delete from CauHoi where IDCauHoi=? AND IDCauHoi NOT IN (SELECT IDCauHoi FROM LanThi_CauHoi)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idCauHoi);
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
	
	//
	public List<CauHoiBean> getListID(String idBaiThi){
		List<CauHoiBean> lst = new ArrayList<CauHoiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM CauHoi INNER JOIN BaiThi_CauHoi ON CauHoi.IDCauHoi=BaiThi_CauHoi.IDCauHoi Where IDBaiThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idBaiThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				lst.add(new CauHoiBean(rs.getString("IDCauHoi"),rs.getString("NoiDung"), rs.getString("DapAn"), rs.getString("TraLoiMot"), 
						rs.getString("TraLoiHai"), rs.getString("TraLoiBa"), rs.getString("TraLoiBon"), rs.getString("IDUser"), rs.getString("IDLoai")));
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
	
	public List<CauHoiBean> getListViTriThi(String idLanThi){
		List<CauHoiBean> lst = new ArrayList<CauHoiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM CauHoiThi Where IDLanThi=? ORDER BY ViTri ASC";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idLanThi);
			rs = pstm.executeQuery();
			CauHoiBean ch=null;
			while (rs.next()) {
				ch=new CauHoiBean(rs.getString("IDCauHoi"), rs.getString("NoiDung"), rs.getString("DapAn"),
						rs.getString("TraLoiMot"), rs.getString("TraLoiHai"), rs.getString("TraLoiBa"),rs.getString("TraLoiBon"), rs.getString("IDUser"),null);
				ch.setViTri(rs.getInt("ViTri"));
				ch.setTraLoiChon(rs.getString("CauTraLoi"));
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
	//Get Cau Hoi theo user
	public List<CauHoiBean> getListCauHoiUser(String idUser){
		List<CauHoiBean> lst = new ArrayList<CauHoiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM CauHoi Where IDUser=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idUser);
			rs = pstm.executeQuery();
			CauHoiBean ch = null;
			while (rs.next()) {
				ch = new CauHoiBean(rs.getString("IDCauHoi"), 
						rs.getString("NoiDung"), rs.getString("DapAn"), rs.getString("TraLoiMot"), 
						rs.getString("TraLoiHai"), rs.getString("TraLoiBa"), rs.getString("TraLoiBon"),rs.getString("IDUser"),rs.getString("IDLoai"));
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
	//get 1 cau hoi
	public CauHoiBean getCauHoi(String idCauHoi){
		CauHoiBean ch = null;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM CauHoi where IDCauHoi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idCauHoi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ch = new CauHoiBean(idCauHoi,rs.getString("NoiDung"), rs.getString("DapAn"), rs.getString("TraLoiMot"), rs.getString("TraLoiHai"),
						rs.getString("TraLoiBa"),rs.getString("TraLoiBon"),rs.getString("IDUser"),rs.getString("IDLoai"));
			}

		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return ch;
	}
	
	//Tìm kiếm theo loai
	public List<CauHoiBean> searchCauHoi(String key,String idUser,String idLoai){
		List<CauHoiBean> lst = new ArrayList<CauHoiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * from CauHoi inner join LoaiBaiThi on CauHoi.IDLoai = LoaiBaiThi.IDLoai where NoiDung Like N'%"+key+"%' AND IDUser=? AND CauHoi.IDLoai=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idUser);
			pstm.setString(2, idLoai);
			rs = pstm.executeQuery();
			CauHoiBean ch = null;
			while (rs.next()) {
				ch = new CauHoiBean(rs.getString("IDCauHoi"), rs.getString("NoiDung"), rs.getString("DapAn"), rs.getString("TraLoiMot"), rs.getString("TraLoiHai"), rs.getString("TraLoiBa"), rs.getString("TraLoiBon"), rs.getString("IDUser"),rs.getString("IDLoai")) ;
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
	public List<CauHoiBean> searchCauHoiAll(String key,String idUser){
		List<CauHoiBean> lst = new ArrayList<CauHoiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * from CauHoi  where NoiDung Like N'%"+key+"%' AND IDUser=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idUser);
			rs = pstm.executeQuery();
			CauHoiBean ch = null;
			while (rs.next()) {
				ch = new CauHoiBean(rs.getString("IDCauHoi"), rs.getString("NoiDung"), rs.getString("DapAn"), rs.getString("TraLoiMot"), rs.getString("TraLoiHai"), rs.getString("TraLoiBa"), rs.getString("TraLoiBon"), rs.getString("IDUser"),rs.getString("IDLoai")) ;
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
	public List<String> getListStringID(String idBaiThi) {
		List<String> lst = new ArrayList<String>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM BaiThi_CauHoi Where IDBaiThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idBaiThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				lst.add(rs.getString("IDCauHoi"));
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
