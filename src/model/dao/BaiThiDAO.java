package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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


}
