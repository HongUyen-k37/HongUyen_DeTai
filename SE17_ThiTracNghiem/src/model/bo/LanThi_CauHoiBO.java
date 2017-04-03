package model.bo;

import model.bean.LanThi_CauHoiBean;
import model.dao.LanThi_CauHoiDao;

public class LanThi_CauHoiBO {
	LanThi_CauHoiDao lt_ch =new LanThi_CauHoiDao();
	public boolean insert(LanThi_CauHoiBean lt) {
		return lt_ch.insert(lt);
	}
}
