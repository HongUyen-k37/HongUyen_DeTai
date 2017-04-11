package form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.PhongThiBean;
public class PhongThiActionForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PhongThiBean> listPhongThi;
	private String maPhongThi;
	private String maKyThi;
	private String soHieuPhongThi;
	private int soLuongThiSinh;
	private String submit;
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
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
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
