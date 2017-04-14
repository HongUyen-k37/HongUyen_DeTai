package form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.KyThiBean;
import model.bean.ThiSinhBean;

public class ThiSinhActionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<KyThiBean> listKyThi;
	public List<KyThiBean> getListKyThi() {
		return listKyThi;
	}

	public void setListKyThi(List<KyThiBean> listKyThi) {
		this.listKyThi = listKyThi;
	}
	private KyThiBean kyThi;
	public KyThiBean getKyThi() {
		return kyThi;
	}

	public void setKyThi(KyThiBean kyThi) {
		this.kyThi = kyThi;
	}
	private String maKyThi;
	private String maThiSinh;
	private String maPhongThi;
	private String hoDem;
	private String ten;
	private String ngaySinh;
	private String noiSinh;
	private String khuVuc;
	private String doiTuong;
	private String dienThoai;
	private String email;
	private String diaChi;
	private String soBaoDanh;
	private String tiepDauNgu;
	private int soBatDau;
	private int soLuong;
	private String submit;
	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	private List<ThiSinhBean> listThiSinh;

	public String getMaKyThi() {
		return maKyThi;
	}

	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
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

	public String getMaThiSinh() {
		return maThiSinh;
	}

	public void setMaThiSinh(String maThiSinh) {
		this.maThiSinh = maThiSinh;
	}

	public String getMaPhongThi() {
		return maPhongThi;
	}

	public void setMaPhongThi(String maPhongThi) {
		this.maPhongThi = maPhongThi;
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

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getKhuVuc() {
		return khuVuc;
	}

	public void setKhuVuc(String khuVuc) {
		this.khuVuc = khuVuc;
	}

	public String getDoiTuong() {
		return doiTuong;
	}

	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoBaoDanh() {
		return soBaoDanh;
	}

	public void setSoBaoDanh(String soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
