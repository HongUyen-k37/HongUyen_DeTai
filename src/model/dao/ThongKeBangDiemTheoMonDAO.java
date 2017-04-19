package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.ThongKeBangDiemTheoMonBean;

public class ThongKeBangDiemTheoMonDAO extends DataAccessObject{
	public List<ThongKeBangDiemTheoMonBean> tkBangDiemTheoMon(){
		List<ThongKeBangDiemTheoMonBean> lst= new ArrayList<ThongKeBangDiemTheoMonBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM TKBangDiemTheoMon ORDER BY soBaoDanh ASC";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ThongKeBangDiemTheoMonBean tk =  new ThongKeBangDiemTheoMonBean(rs.getString("hoDem"),rs.getString("ten"),rs.getString("ngaySinh"),
						rs.getString("soBaoDanh"),rs.getInt("soPhach"), rs.getFloat("diemChamThi"));
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