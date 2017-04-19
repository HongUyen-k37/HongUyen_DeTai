package model.bo;

import java.util.List;

import model.bean.ThongKeBangDiemTheoMonBean;
import model.dao.ThongKeBangDiemTheoMonDAO;

public class ThongKeBangDiemTheoMonBO {
	ThongKeBangDiemTheoMonDAO tk =new ThongKeBangDiemTheoMonDAO();
	public List<ThongKeBangDiemTheoMonBean> tkBangDiemTheoMon(){
		return tk.tkBangDiemTheoMon();
	}
}
