package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.DiemChuanBean;
import model.bean.KyThiBean;

public class DiemActionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKyThi;
	private KyThiBean kyThi;
	private List<KyThiBean> listKyThi;
	private float diemLiet;
	private int check;
	private float diemChuan;
	private String kiemTra;
	private List<DiemChuanBean> listResult;
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	public KyThiBean getKyThi() {
		return kyThi;
	}
	public void setKyThi(KyThiBean kyThi) {
		this.kyThi = kyThi;
	}
	public List<KyThiBean> getListKyThi() {
		return listKyThi;
	}
	public void setListKyThi(List<KyThiBean> listKyThi) {
		this.listKyThi = listKyThi;
	}
	public float getDiemLiet() {
		return diemLiet;
	}
	public void setDiemLiet(float diemLiet) {
		this.diemLiet = diemLiet;
	}
	public float getDiemChuan() {
		return diemChuan;
	}
	public void setDiemChuan(float diemChuan) {
		this.diemChuan = diemChuan;
	}
	public String getKiemTra() {
		return kiemTra;
	}
	public void setKiemTra(String kiemTra) {
		this.kiemTra = kiemTra;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public List<DiemChuanBean> getListResult() {
		return listResult;
	}
	public void setListResult(List<DiemChuanBean> listResult) {
		this.listResult = listResult;
	}
}
