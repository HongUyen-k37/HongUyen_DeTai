package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
						rs.getString("soBaoDanh"),rs.getInt("soPhach"), rs.getFloat("diemChamThi"), "", rs.getString("ghiChu"));
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
}