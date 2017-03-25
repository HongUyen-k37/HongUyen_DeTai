package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.ThiSinhBean;

public class ThiSinhDAO extends DataAccessObject{
	public List<ThiSinhBean> getListThiSinh(long maKyThi){
		List<ThiSinhBean> lst = new ArrayList<ThiSinhBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM THISINH WHERE maKyThi = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setLong(1, maKyThi);
			rs = pstm.executeQuery();
			ThiSinhBean ts = null;
			while (rs.next()) {
				ts = new ThiSinhBean(rs.getLong("maThiSinh"), rs.getLong("maKyThi"), rs.getLong("maPhongThi"), rs.getString("hoDem"),
						rs.getString("ten"), rs.getString("ngaySinh"), rs.getString("noiSinh"), rs.getString("khuVuc"),
						rs.getString("doiTuong"), rs.getString("dienThoai"), rs.getString("email"), rs.getString("diaChi"),
						rs.getString("soBaoDanh"));
				lst.add(ts);
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
