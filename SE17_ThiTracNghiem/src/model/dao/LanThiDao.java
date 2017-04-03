package model.dao;
//Uyên, 9:30 am, 17/02/17
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.bean.LanThiBean;

public class LanThiDao extends DataAccessObject{
		/*Lưu idUser, idBaiThi, thoiGianThi vào DB*/
		public boolean insert(String idUser,String idBaiThi) {
			boolean result = false;
			Connection cnn = getConnection();
			PreparedStatement pstm = null;
			try {
				String sql = "INSERT INTO LanThi(IDUser,IDBaiThi,ThoiGianThi) VALUES(?,?,?)";
				pstm = cnn.prepareStatement(sql);
				pstm.setString(1, idUser);
				pstm.setString(2, idBaiThi);
				pstm.setLong(3, new Date().getTime());
				result = pstm.execute();
				result=true;
			} catch (Exception ex) {
				result = false;
				getMessenger(ex);
			} finally {
				tryToClose(cnn);
				tryToClose(pstm);
			}
			return result;
		}
		public boolean delete(String idUser,String idBaiThi) {
			boolean result = false;
			Connection cnn = getConnection();
			PreparedStatement pstm = null;
			try {
				String sql = "DELETE FROM LanThi WHERE IDUser=? AND IDBaiThi=?";
				pstm = cnn.prepareStatement(sql);
				pstm.setString(1, idUser);
				pstm.setString(2, idBaiThi);
				result = pstm.execute();
				result=true;
			} catch (Exception ex) {
				result = false;
				getMessenger(ex);
			} finally {
				tryToClose(cnn);
				tryToClose(pstm);
			}
			return result;
		}
		/*UPDATE soCauTraLoiDung, thoiGianThi vào DB*/
		//coi lại
		//Đã coi lại. Hàm dư thừa.
		public boolean luuDapAn(String idLanThi,String idCauHoi,String traLoiChon) {
			boolean result = false;
			Connection cnn = getConnection();
			PreparedStatement pstm = null;
			try {
				String sql = "Update LanThi_CauHoi Set CauTraLoi=? where IDLanThi = ? AND IDCauHoi=?";
				pstm = cnn.prepareStatement(sql);
				pstm.setString(1, traLoiChon);
				pstm.setString(2, idLanThi);
				pstm.setString(3, idCauHoi);
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
		//Thiếu hàm update giá thị thoiGianKetThuc=thời gian hiện tại cho LanThi co IDLanThi
		public void setThoiGianKetThuc(String idLanThi){
			Connection cnn = getConnection();
			PreparedStatement pstm = null;
			try {
				String sql = "Update LanThi Set ThoiGianKetThuc=? where IDLanThi=?";
				pstm = cnn.prepareStatement(sql);
				pstm.setLong(1, new Date().getTime());
				pstm.setString(2, idLanThi);
				pstm.execute();
			} catch (Exception ex) {
				getMessenger(ex);
			} finally {
				tryToClose(cnn);
				tryToClose(pstm);
			}
		}
		
		public void hoanTatLanThi(String idLanThi){
			Connection cnn = getConnection();
			PreparedStatement pstm = null;
			try {
				String sql = "Update LanThi Set HoanTat=? where IDLanThi=?";
				pstm = cnn.prepareStatement(sql);
				pstm.setBoolean(1, true);
				pstm.setString(2, idLanThi);
				pstm.execute();
			} catch (Exception ex) {
				getMessenger(ex);
			} finally {
				tryToClose(cnn);
				tryToClose(pstm);
			}
		}
		
		public LanThiBean getLanThi(String idLanThi){
			LanThiBean lanThi=null;
			Connection cnn = getConnection();
			ResultSet rs = null;
			PreparedStatement pstm = null;
			try {
				String sql = "SELECT * FROM LanThi where idLanThi=?";
				pstm = cnn.prepareStatement(sql);
				pstm.setString(1, idLanThi);
				rs = pstm.executeQuery();
				while (rs.next()) {
					lanThi = new LanThiBean(idLanThi,rs.getString("IDBaiThi"), rs.getString("IDUser"), 
							rs.getInt("SoCauTraLoiDung"), rs.getLong("ThoiGianThi"), rs.getLong("ThoiGianKetThuc"));
					lanThi.setHoanTat(rs.getBoolean("HoanTat"));
				}
		
			} catch (Exception ex) {
				getMessenger(ex);
			} finally {
				tryToClose(cnn);
				tryToClose(pstm);
				tryToClose(rs);
			}
			return lanThi;
		}
		public LanThiBean getLanThi(String idUser,String idBaiThi){
			LanThiBean lanThi=null;
			Connection cnn = getConnection();
			ResultSet rs = null;
			PreparedStatement pstm = null;
			try {
				String sql = "SELECT * FROM LanThi where idUser=? AND idBaiThi=?";
				pstm = cnn.prepareStatement(sql);
				pstm.setString(1, idUser);
				pstm.setString(2, idBaiThi);
				rs = pstm.executeQuery();
				while (rs.next()) {
					lanThi = new LanThiBean(rs.getString("IDLanThi"),idBaiThi , idUser,
							rs.getInt("SoCauTraLoiDung"), rs.getLong("ThoiGianThi"), rs.getLong("ThoiGianKetThuc"));
					lanThi.setHoanTat(rs.getBoolean("HoanTat"));
				}
		
			} catch (Exception ex) {
				getMessenger(ex);
			} finally {
				tryToClose(cnn);
				tryToClose(pstm);
				tryToClose(rs);
			}
			return lanThi;
		}
		//lấy top thành viên trang ChiTietBaiThi.do
		@SuppressWarnings("null")
		public List<LanThiBean> getTop(String idBaiThi){
			List<LanThiBean> lst = new ArrayList<LanThiBean>();
			Connection cnn = getConnection();
			ResultSet rs = null;
			PreparedStatement pstm = null;		
			try {
				String sql = "SELECT TOP 5 * from LanThi where IDBaiThi=? ORDER BY DESC";
				pstm = cnn.prepareStatement(sql);
				pstm.setString(1, idBaiThi);
				rs = pstm.executeQuery();
				LanThiBean lt = null;
				while (rs.next()) {
					lt = new LanThiBean(null, idBaiThi, rs.getString("IDUser"), rs.getInt("SoCauTraLoiDung"), rs.getLong("ThoiGianThi"), (Long) null);
					lst.add(lt);
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
