package model.bo;

import java.util.List;

import model.bean.TKChiTietLanThiBean;
import model.dao.KetQuaThiDao;

public class KetQuaThiBO {
	KetQuaThiDao kq = new KetQuaThiDao();
	public List<TKChiTietLanThiBean> getListKetQua(String idLanThi){
		return kq.getListKetQua(idLanThi);
	}

}
