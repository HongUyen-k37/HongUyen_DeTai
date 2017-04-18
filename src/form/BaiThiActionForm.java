package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bean.PhongThiBean;
import model.bean.ThiSinhBean;
import model.bean.TrangThai;

public class BaiThiActionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKyThi;
	private List<KyThiBean> listKyThi;
	private KyThiBean kyThi;
	private String trangThaiDuThi;
	private String save;
	private List<PhongThiBean> listPhongThi;
	private List<ThiSinhBean> listThiSinh;
	private List<MonThiBean> listMonThi;
	private String maPhongThi;
	private String maMonThi;
	private List<TrangThai> listTrangThai;
	//get ca nhom
	public TrangThai getTrangThai(int index){
		while(index >= listTrangThai.size()){
			listTrangThai.add(new TrangThai());
		}
		return this.listTrangThai.get(index);
	}
	public void setTrangThai(int index, TrangThai trangThai){
		this.listTrangThai.add(index, trangThai);
	}
	
	public String getMaPhongThi() {
		return maPhongThi;
	}
	public void setMaPhongThi(String maPhongThi) {
		this.maPhongThi = maPhongThi;
	}
	public List<ThiSinhBean> getListThiSinh() {
		return listThiSinh;
	}
	public void setListThiSinh(List<ThiSinhBean> listThiSinh) {
		this.listThiSinh = listThiSinh;
	}
	public List<PhongThiBean> getListPhongThi() {
		return listPhongThi;
	}
	public void setListPhongThi(List<PhongThiBean> listPhongThi) {
		this.listPhongThi = listPhongThi;
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
	public String getSave() {
		return save;
	}
	public void setSave(String save) {
		this.save = save;
	}
	public String getTrangThaiDuThi() {
		return trangThaiDuThi;
	}
	public void setTrangThaiDuThi(String trangThaiDuThi) {
		this.trangThaiDuThi = trangThaiDuThi;
	}
	public List<MonThiBean> getListMonThi() {
		return listMonThi;
	}
	public void setListMonThi(List<MonThiBean> listMonThi) {
		this.listMonThi = listMonThi;
	}
	public String getMaMonThi() {
		return maMonThi;
	}
	public void setMaMonThi(String maMonThi) {
		this.maMonThi = maMonThi;
	}
	public List<TrangThai> getListTrangThai() {
		return listTrangThai;
	}
	public void setListTrangThai(List<TrangThai> listTrangThai) {
		this.listTrangThai = listTrangThai;
	}
}
