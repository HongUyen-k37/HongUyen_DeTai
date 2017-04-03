package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.bean.CauHoiBean;
public class BaiThi_CauHoiDao extends DataAccessObject{
	
	public boolean insert(String idBaiThi,String idCauHoi){
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO BaiThi_CauHoi VALUES(?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idBaiThi);
			pstm.setString(2, idCauHoi);
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
	public boolean delete(String idBaiThi,String idCauHoi){
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "DELETE FROM BaiThi_CauHoi WHERE IDBaiThi=? AND IDCauHoi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idBaiThi);
			pstm.setString(2, idCauHoi);
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
	/**
	 * Insert cau hoi lay ID bai thi ve
	 * @param cauHoi
	 * @return
	 */
	public void insertCH(CauHoiBean cauHoi,String idBaiThi) {
		ResultSet rs = null;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		String idCauHoi = null;
		try {
			String sql = "insert into CauHoi OUTPUT Inserted.IDCauHoi values (?,?,?,?,?,?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, cauHoi.getNoiDung());
			pstm.setString(2, cauHoi.getDapAn());
			pstm.setString(3, cauHoi.getTraLoiMot());
			pstm.setString(4, cauHoi.getTraLoiHai());
			pstm.setString(5, cauHoi.getTraLoiBa());
			pstm.setString(6, cauHoi.getTraLoiBon());
			pstm.setString(7, cauHoi.getIdUser());
			pstm.setString(8, cauHoi.getIdLoai()==null?"L0007":cauHoi.getIdLoai());
			rs = pstm.executeQuery();
			while(rs.next()){
				idCauHoi = rs.getString("IDCauHoi");
				insert(idBaiThi, idCauHoi);
				
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
	}
	/*"insert into CauHoi OUTPUT Inserted.IDCauHoi values (@noiDung,@dapAn,@traLoi1,@traLoi2,@traLoi3,@traLoi4,@idUser)"*/
}


