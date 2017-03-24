package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.KyThiBean;

public class KyThiDAO extends DataAccessObject{
	public List<KyThiBean> getListKyThi(){
		List<KyThiBean> lst = new ArrayList<KyThiBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM KYTHI";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			KyThiBean kt = null;
			while (rs.next()) {
				kt = new KyThiBean(rs.getLong("maKyThi"), rs.getString("tenKyThi"), rs.getString("ngayThi"), rs.getInt("namTuyenSinh"),
						rs.getString("nganh"), rs.getString("hinhThucDT"), rs.getString("coSoLKDT"), rs.getInt("soMonThi"),
						rs.getInt("trangThai"), rs.getInt("coSoPhongThi"), rs.getInt("soLuot"), rs.getString("tiepDauNgu"),
						rs.getInt("soBatDau"), rs.getInt("coSoTui"), rs.getInt("soLuongChuSo"), rs.getDouble("diemChuan"),
						rs.getDouble("diemLiet"));
				lst.add(kt);
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