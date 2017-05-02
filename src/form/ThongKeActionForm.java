package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.BaiThiBean;
import model.bean.KetQuaThiSinhBean;
import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bean.ThongKeBean;

@SuppressWarnings("serial")
public class ThongKeActionForm extends ActionForm {
	private List<ThongKeBean> listTKTheoMon;
	private List<MonThiBean> listMonThi;
	private String maMonThi;
	private String maKyThi;
	private List<KyThiBean> listKyThi;
	private KyThiBean kyThi;
	private MonThiBean monThi;
	private List<Integer> listTui;
	private int soMonThi;
	public List<Integer> getListTui() {
		return listTui;
	}
	public void setListTui(List<Integer> listTui) {
		this.listTui = listTui;
	}
	public int getTuiSo() {
		return tuiSo;
	}
	public void setTuiSo(int tuiSo) {
		this.tuiSo = tuiSo;
	}
	private int tuiSo;
	private List<BaiThiBean> listTKBienBan;
	private List<BaiThiBean> listTKBienBanTH;
	private List<KetQuaThiSinhBean> listTKTongHop;
	private List<KetQuaThiSinhBean> listTrungTuyen;
	public String getMaMonThi() {
		return maMonThi;
	}
	public void setMaMonThi(String maMonThi) {
		this.maMonThi = maMonThi;
	}
	public List<MonThiBean> getListMonThi() {
		return listMonThi;
	}
	public void setListMonThi(List<MonThiBean> listMonThi) {
		this.listMonThi = listMonThi;
	}
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	public List<KyThiBean> getListKyThi() {
		return listKyThi;
	}
	public void setListKyThi(List<KyThiBean> listKyThi) {
		this.listKyThi = listKyThi;
	}
	public KyThiBean getKyThi() {
		return kyThi;
	}
	public void setKyThi(KyThiBean kyThi) {
		this.kyThi = kyThi;
	}
	public MonThiBean getMonThi() {
		return monThi;
	}
	public void setMonThi(MonThiBean monThi) {
		this.monThi = monThi;
	}
	public List<ThongKeBean> getListTKTheoMon() {
		return listTKTheoMon;
	}
	public void setListTKTheoMon(List<ThongKeBean> listTKTheoMon) {
		this.listTKTheoMon = listTKTheoMon;
	}
	public List<KetQuaThiSinhBean> getListTKTongHop() {
		return listTKTongHop;
	}
	public void setListTKTongHop(List<KetQuaThiSinhBean> listTKTongHop) {
		this.listTKTongHop = listTKTongHop;
	}
	public List<KetQuaThiSinhBean> getListTrungTuyen() {
		return listTrungTuyen;
	}
	public void setListTrungTuyen(List<KetQuaThiSinhBean> listTrungTuyen) {
		this.listTrungTuyen = listTrungTuyen;
	}
	public List<BaiThiBean> getListTKBienBan() {
		return listTKBienBan;
	}
	public void setListTKBienBan(List<BaiThiBean> listTKBienBan) {
		this.listTKBienBan = listTKBienBan;
	}
	public List<BaiThiBean> getListTKBienBanTH() {
		return listTKBienBanTH;
	}
	public void setListTKBienBanTH(List<BaiThiBean> listTKBienBanTH) {
		this.listTKBienBanTH = listTKBienBanTH;
	}
	public int getSoMonThi() {
		return soMonThi;
	}
	public void setSoMonThi(int soMonThi) {
		this.soMonThi = soMonThi;
	}
}
