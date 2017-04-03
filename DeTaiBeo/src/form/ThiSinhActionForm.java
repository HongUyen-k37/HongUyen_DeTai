package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.ThiSinhBean;

public class ThiSinhActionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long maKyThi;
	private long mats;
	private String tiepDauNgu;
	private int soBatDau;
	private int soLuong;
	private List<ThiSinhBean> listThiSinh;

	public long getMaKyThi() {
		return maKyThi;
	}

	public void setMaKyThi(long maKyThi) {
		this.maKyThi = maKyThi;
	}

	public long getMats() {
		return mats;
	}

	public void setMats(long mats) {
		this.mats = mats;
	}

	public String getTiepDauNgu() {
		return tiepDauNgu;
	}

	public void setTiepDauNgu(String tiepDauNgu) {
		this.tiepDauNgu = tiepDauNgu;
	}

	public int getSoBatDau() {
		return soBatDau;
	}

	public void setSoBatDau(int soBatDau) {
		this.soBatDau = soBatDau;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public List<ThiSinhBean> getListThiSinh() {
		return listThiSinh;
	}

	public void setListThiSinh(List<ThiSinhBean> listThiSinh) {
		this.listThiSinh = listThiSinh;
	}
}
