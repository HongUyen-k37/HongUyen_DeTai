package model.bo;

import java.util.List;

import model.bean.ThongKeBean;
import model.dao.ThongKeDAO;

public class ThongKeBO {
	ThongKeDAO tk =new ThongKeDAO();
	public List<ThongKeBean> tkBangDiemTheoMon(String maKyThi, String maMonThi){
		return tk.tkBangDiemTheoMon(maKyThi, maMonThi);
	}
}
