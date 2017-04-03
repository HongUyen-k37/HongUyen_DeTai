package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.LoaiBaiThiBean;


public class LoaiBaiThiDao extends DataAccessObject{
	
	//get ra list loại bài thi ở comboBox
	public List<LoaiBaiThiBean> getList() {
		List<LoaiBaiThiBean> lst = new ArrayList<LoaiBaiThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM LoaiBaiThi";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			String idLoai, tenLoai;
			while (rs.next()) {
				idLoai = rs.getString("IDLoai");
				tenLoai = rs.getString("TenLoai");
				lst.add(new LoaiBaiThiBean(idLoai, tenLoai));
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
