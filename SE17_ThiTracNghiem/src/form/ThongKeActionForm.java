package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.TKBaiThiBean;
import model.bean.TKThanhVienBean;

public class ThongKeActionForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idUser;
	private String hoTen;
	private int soBaiThi;
	private int tongCauHoi;
	private int tongCauDung;
	private List<TKThanhVienBean> listTKThanhVien;	
	private int pageTV=0;
	private int totalTV=1;
	private String idBaiThi;
	private String TenBaiThi;
	private int soCauHoi;
	private int soLuotLam;
	private double tiLeLamDuoc;
	private List<TKBaiThiBean> listTKBaiThi;
	private int pageTK=0;
	private int totalTK=1;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getSoBaiThi() {
		return soBaiThi;
	}
	public void setSoBaiThi(int soBaiThi) {
		this.soBaiThi = soBaiThi;
	}
	public int getTongCauHoi() {
		return tongCauHoi;
	}
	public void setTongCauHoi(int tongCauHoi) {
		this.tongCauHoi = tongCauHoi;
	}
	public int getTongCauDung() {
		return tongCauDung;
	}
	public void setTongCauDung(int tongCauDung) {
		this.tongCauDung = tongCauDung;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getIdBaiThi() {
		return idBaiThi;
	}
	public void setIdBaiThi(String idBaiThi) {
		this.idBaiThi = idBaiThi;
	}
	public String getTenBaiThi() {
		return TenBaiThi;
	}
	public void setTenBaiThi(String tenBaiThi) {
		TenBaiThi = tenBaiThi;
	}
	public int getSoCauHoi() {
		return soCauHoi;
	}
	public void setSoCauHoi(int soCauHoi) {
		this.soCauHoi = soCauHoi;
	}
	public int getSoLuotLam() {
		return soLuotLam;
	}
	public void setSoLuotLam(int soLuotLam) {
		this.soLuotLam = soLuotLam;
	}
	public double getTiLeLamDuoc() {
		return tiLeLamDuoc;
	}
	public void setTiLeLamDuoc(double tiLeLamDuoc) {
		this.tiLeLamDuoc = tiLeLamDuoc;
	}
	public List<TKThanhVienBean> getListTKThanhVien() {
		return listTKThanhVien;
	}
	public void setListTKThanhVien(List<TKThanhVienBean> listTKThanhVien) {
		this.listTKThanhVien = listTKThanhVien;
	}
	public List<TKBaiThiBean> getListTKBaiThi() {
		return listTKBaiThi;
	}
	public void setListTKBaiThi(List<TKBaiThiBean> listTKBaiThi) {
		this.listTKBaiThi = listTKBaiThi;
	}
	public int getPageTV() {
		return pageTV;
	}
	public void setPageTV(int pageTV) {
		this.pageTV = pageTV;
	}
	public int getPageTK() {
		return pageTK;
	}
	public void setPageTK(int pageTK) {
		this.pageTK = pageTK;
	}
	public int getTotalTK() {
		return totalTK;
	}
	public void setTotalTK(int totalTK) {
		this.totalTK = totalTK;
	}
	public int getTotalTV() {
		return totalTV;
	}
	public void setTotalTV(int totalTV) {
		this.totalTV = totalTV;
	}
	
}
