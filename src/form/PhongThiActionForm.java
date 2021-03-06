package form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bean.PhongThiBean;
import model.bean.ThiSinhBean;
public class PhongThiActionForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PhongThiBean> listPhongThi;
	private List<KyThiBean> listKyThi;
	private String maPhongThi;
	private String maKyThi;
	private String soHieuPhongThi;
	private int soLuongThiSinh;
	private String submit;
	private String bienChe;
	private String notice;
	private KyThiBean kyThi;
	private List<ThiSinhBean> listThiSinh;
	private PhongThiBean phongThi;
	private List<MonThiBean> listMonThi;
	private int tongSoCho;
	private String error;
	public PhongThiBean getPhongThi() {
		return phongThi;
	}
	public void setPhongThi(PhongThiBean phongThi) {
		this.phongThi = phongThi;
	}
	public List<ThiSinhBean> getListThiSinh() {
		return listThiSinh;
	}
	public void setListThiSinh(List<ThiSinhBean> listThiSinh) {
		this.listThiSinh = listThiSinh;
	}
	public KyThiBean getKyThi() {
		return kyThi;
	}
	public void setKyThi(KyThiBean kyThi) {
		this.kyThi = kyThi;
	}
	public List<PhongThiBean> getListPhongThi() {
		return listPhongThi;
	}
	public void setListPhongThi(List<PhongThiBean> listPhongThi) {
		this.listPhongThi = listPhongThi;
	}
	public String getMaPhongThi() {
		return maPhongThi;
	}
	public void setMaPhongThi(String maPhongThi) {
		this.maPhongThi = maPhongThi;
	}
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	public String getSoHieuPhongThi() {
		return soHieuPhongThi;
	}
	public void setSoHieuPhongThi(String soHieuPhongThi) {
		this.soHieuPhongThi = soHieuPhongThi;
	}
	public int getSoLuongThiSinh() {
		return soLuongThiSinh;
	}
	public void setSoLuongThiSinh(int soLuongThiSinh) {
		this.soLuongThiSinh = soLuongThiSinh;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<KyThiBean> getListKyThi() {
		return listKyThi;
	}
	public void setListKyThi(List<KyThiBean> listKyThi) {
		this.listKyThi = listKyThi;
	}
	public String getBienChe() {
		return bienChe;
	}
	public void setBienChe(String bienChe) {
		this.bienChe = bienChe;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public List<MonThiBean> getListMonThi() {
		return listMonThi;
	}
	public void setListMonThi(List<MonThiBean> listMonThi) {
		this.listMonThi = listMonThi;
	}
	public int getTongSoCho() {
		return tongSoCho;
	}
	public void setTongSoCho(int tongSoCho) {
		this.tongSoCho = tongSoCho;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
}
