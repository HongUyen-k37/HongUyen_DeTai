package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bean.ThongKeBean;

@SuppressWarnings("serial")
public class ThongKeActionForm extends ActionForm {
	private List<ThongKeBean> listTKBangDiem;
	private String hoDem;
	private List<MonThiBean> listMonThi;
	private List<MonThiBean> listMaKyThi;
	private String ten;
	private String ngaySinh;
	private String soBaoDanh;
	private String soPhach;
	private String diemChamThi;
	private int namTuyenSinh;
	private String maMonThi;
	private String nganh;
	private String hinhThucDT;
	private String maKyThi;
	private List<KyThiBean> listKyThi;
	private KyThiBean kyThi;
	private MonThiBean monThi;
	
	public String getNganh() {
		return nganh;
	}
	public void setNganh(String nganh) {
		this.nganh = nganh;
	}
	public String getHinhThucDT() {
		return hinhThucDT;
	}
	public void setHinhThucDT(String hinhThucDT) {
		this.hinhThucDT = hinhThucDT;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoBaoDanh() {
		return soBaoDanh;
	}
	public void setSoBaoDanh(String soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}
	public String getSoPhach() {
		return soPhach;
	}
	public void setSoPhach(String soPhach) {
		this.soPhach = soPhach;
	}
	public String getDiemChamThi() {
		return diemChamThi;
	}
	public void setDiemChamThi(String diemChamThi) {
		this.diemChamThi = diemChamThi;
	}
	public List<ThongKeBean> getListTKBangDiem() {
		return listTKBangDiem;
	}
	public void setListTKBangDiem(List<ThongKeBean> listTKBangDiem) {
		this.listTKBangDiem = listTKBangDiem;
	}
	public int getNamTuyenSinh() {
		return namTuyenSinh;
	}
	public void setNamTuyenSinh(int namTuyenSinh) {
		this.namTuyenSinh = namTuyenSinh;
	}
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
	public List<MonThiBean> getListMaKyThi() {
		return listMaKyThi;
	}
	public void setListMaKyThi(List<MonThiBean> listMaKyThi) {
		this.listMaKyThi = listMaKyThi;
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
	
}
