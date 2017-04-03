package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.bean.LanThi_CauHoiBean;

public class LanThi_CauHoiDao extends DataAccessObject {
	/*
	Lưu kết quả làm bài thi: IDLanThi, IDCauHoi và CauTraLoi
	
	*/
	//Lưu kết quả thì nên là Update.
	public boolean insert(LanThi_CauHoiBean lt_ch) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO LanThi_CauHoi VALUES(?,?,?,?,?,?,?,?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, lt_ch.getIdLanThi());
			pstm.setString(2, lt_ch.getIdCauHoi());
			pstm.setString(3, lt_ch.getCauTraLoi());
			pstm.setString(4, lt_ch.getNoiDung());
			pstm.setString(5, lt_ch.getDapAn());
			pstm.setString(6, lt_ch.getTraLoiMot());
			pstm.setString(7, lt_ch.getTraLoiHai());
			pstm.setString(8, lt_ch.getTraLoiBa());
			pstm.setString(9, lt_ch.getTraLoiBon());
			pstm.setInt(10, lt_ch.getViTri());
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
}
