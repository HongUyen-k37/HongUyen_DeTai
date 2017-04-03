
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bean.TKChiTietLanThiBean;

//Nên chuyển qua ThongKeDAO
public class KetQuaThiDao extends DataAccessObject{


	//Get all kết quả thi
	//Đức: get hết ra rứa biết cái mô của ai, lần thi mô mà hiển thị. 
	//VD: Lần Thi 001, Câu hfasd, trả lời 1|Lần thi 002, câu aisfdhasd, trả lời tsa|
	//1. input (idLanThi) => output (danh sách câu hỏi, trả lời của user trong lần thi đó) 


	
	//Sau khi click button Hoàn tất -> trả về danh sách kết quả thi
	// Trên dưới giống nhau.

	
	
	public List<TKChiTietLanThiBean> getListKetQua(String idLanThi){
		List<TKChiTietLanThiBean> lst= new ArrayList<TKChiTietLanThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM CauHoiThi where idLanThi=? ORDER BY ViTri";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, idLanThi);
			rs = pstm.executeQuery();
			TKChiTietLanThiBean ch = null;
			while (rs.next()) {
				ch =  new TKChiTietLanThiBean(idLanThi,rs.getString("NoiDung"), rs.getString("CauTraLoi"), rs.getString("DapAn"));
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
