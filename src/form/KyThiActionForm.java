package form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.KyThiBean;

public class KyThiActionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<KyThiBean> listKyThi;
	private String maKyThi;
	private String tenKyThi;
	private String ngayThi;
	private int namTuyenSinh;
	private String nganh;
	private String hinhThucDT;
	private String coSoLKDT;
	private int soMonThi;
	private int trangThai;
	private String submit;

	public String getMaKyThi() {
		return maKyThi;
	}

	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}

	public String getTenKyThi() {
		return tenKyThi;
	}

	public void setTenKyThi(String tenKyThi) {
		this.tenKyThi = tenKyThi;
	}

	public String getNgayThi() {
		return ngayThi;
	}

	public void setNgayThi(String ngayThi) {
		this.ngayThi = ngayThi;
	}

	public int getNamTuyenSinh() {
		return namTuyenSinh;
	}

	public void setNamTuyenSinh(int namTuyenSinh) {
		this.namTuyenSinh = namTuyenSinh;
	}

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

	public String getCoSoLKDT() {
		return coSoLKDT;
	}

	public void setCoSoLKDT(String coSoLKDT) {
		this.coSoLKDT = coSoLKDT;
	}

	public int getSoMonThi() {
		return soMonThi;
	}

	public void setSoMonThi(int soMonThi) {
		this.soMonThi = soMonThi;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public List<KyThiBean> getListKyThi() {
		return listKyThi;
	}

	public void setListKyThi(List<KyThiBean> listKyThi) {
		this.listKyThi = listKyThi;
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
}
