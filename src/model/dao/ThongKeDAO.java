package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.ThongKeBean;

public class ThongKeDAO extends DataAccessObject{
	public List<ThongKeBean> tkBangDiemTheoMon(){
		List<ThongKeBean> lst= new ArrayList<ThongKeBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM TKBangDiemTheoMon ORDER BY soBaoDanh ASC";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ThongKeBean tk =  new ThongKeBean(rs.getString("hoDem"),rs.getString("ten"),rs.getString("ngaySinh"),
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
/*	public List<ThongKeBean> tkBangDiemTheoMon(){
		List<ThongKeBean> lst= new ArrayList<ThongKeBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM TKBangDiemTheoMon ORDER BY soBaoDanh ASC";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ThongKeBean tk =  new ThongKeBean(rs.getString("hoDem"),rs.getString("ten"),rs.getString("ngaySinh"),
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
	}*/
}