package model.bo;

import java.util.List;

import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.dao.KyThiDAO;
import model.dao.MonThiDAO;

public class KyThiBO {
	KyThiDAO kt = new KyThiDAO();
	MonThiDAO mt = new MonThiDAO();
	public List<KyThiBean> getListKyThi(){
		return kt.getListKyThi();
	}
	public KyThiBean getKyThi(String MaKyThi) {
		return kt.getKyThi(MaKyThi);
	}
	public boolean delete(String maKyThi) {
		mt.delete(maKyThi);
		return kt.delete(maKyThi);
	}
	public boolean update(KyThiBean kyThi, List<MonThiBean> listMonThi) {
		return kt.update(kyThi, listMonThi);
	}
	public void insert(KyThiBean kyThi, List<MonThiBean> listMonThi) {
		kt.insert(kyThi, listMonThi);
	}
	public List<KyThiBean> searchKyThi(String key){
		return kt.searchKyThi(key);
	}
	public boolean xacDinhDiemChuan(String maKyThi, float diemChuan, float diemLiet, boolean nhoHonDiemLiet) {
		return kt.xacDinhDiemChuan(maKyThi, diemChuan, diemLiet, nhoHonDiemLiet);
	}
	public boolean updateTrangThai(String maKyThi, int trangThai){
		return kt.updateTrangThai(maKyThi, trangThai);
	}
}
