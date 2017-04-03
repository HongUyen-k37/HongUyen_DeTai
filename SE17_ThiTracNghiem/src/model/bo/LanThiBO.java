package model.bo;

import java.util.Collections;
import java.util.List;

import model.bean.CauHoiBean;
import model.bean.LanThiBean;
import model.bean.LanThi_CauHoiBean;
import model.dao.LanThiDao;

public class LanThiBO {
	private LanThiDao dao = new LanThiDao();
	public void taoLanThi(String idUser,String idBaiThi) {
		dao.insert(idUser,idBaiThi);
		CauHoiBO cauHoiBO=new CauHoiBO();
		LanThi_CauHoiBO lanThi_CauHoiBO=new LanThi_CauHoiBO();
		List<CauHoiBean> lst=cauHoiBO.getListID(idBaiThi);
		LanThiBean lanThi=getLanThi(idUser, idBaiThi);
		String idLanThi=lanThi.getIdLanThi();
		Collections.shuffle(lst);
		int i=1;
		for (CauHoiBean cauHoi : lst) {
			lanThi_CauHoiBO.insert(new LanThi_CauHoiBean(idLanThi, cauHoi.getIdCauHoi(),null,cauHoi.getTraLoiMot(),cauHoi.getTraLoiHai(),cauHoi.getTraLoiBa(),cauHoi.getTraLoiBon(),cauHoi.getNoiDung(),cauHoi.getDapAn(), i));
			i++;
		}
	}
	public LanThiBean getLanThi(String idLanThi){
		return dao.getLanThi(idLanThi);
	}
	public LanThiBean getLanThi(String idUser,String idBaiThi){
		return dao.getLanThi(idUser, idBaiThi);
	}
	public void luuDapAn(String idLanThi,String idCauHoi,String traLoiChon){
		dao.luuDapAn(idLanThi, idCauHoi, traLoiChon);
	}
	public List<LanThiBean> getTop(String idBaiThi){
		return dao.getTop(idBaiThi);
	}
	public void setThoiGianKetThuc(String idLanThi){
		dao.setThoiGianKetThuc(idLanThi);
	}
	public void hoanTatLanThi(String idLanThi){
		dao.hoanTatLanThi(idLanThi);
	}
	public void delete(String idUser,String idBaiThi){
		dao.delete(idUser, idBaiThi);
	}
}
