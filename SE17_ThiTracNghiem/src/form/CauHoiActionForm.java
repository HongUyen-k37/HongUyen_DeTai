//UyenTTH 9:00 21/02/2017
package form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.CauHoiBean;
import model.bean.LoaiBaiThiBean;

public class CauHoiActionForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	private String idLanThi;
	private String idCauHoi;
	private String noiDung;
	private String dapAn;
	private String traLoiMot;
	private String traLoiHai;
	private String traLoiBa;
	private String traLoiBon;
	private String traLoiChon;
	private String idUser;
	private int viTri;
	private List<CauHoiBean> lst;
	private String submit;
	private String search;
	private List<LoaiBaiThiBean> listLoai;
	private String inputSearch;
	private int page=0;
	private int total=1;
	private String idLoai;
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public List<CauHoiBean> getLst() {
		return lst;
	}
	public void setLst(List<CauHoiBean> lst) {
		this.lst = lst;
	}
	public String getIdCauHoi() {
		return idCauHoi;
	}
	public void setIdCauHoi(String idCauHoi) {
		this.idCauHoi = idCauHoi;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getDapAn() {
		return dapAn;
	}
	public void setDapAn(String dapAn) {
		this.dapAn = dapAn;
	}
	public String getTraLoiMot() {
		return traLoiMot;
	}
	public void setTraLoiMot(String traLoiMot) {
		this.traLoiMot = traLoiMot;
	}
	public String getTraLoiHai() {
		return traLoiHai;
	}
	public void setTraLoiHai(String traLoiHai) {
		this.traLoiHai = traLoiHai;
	}
	public String getTraLoiBa() {
		return traLoiBa;
	}
	public void setTraLoiBa(String traLoiBa) {
		this.traLoiBa = traLoiBa;
	}
	public String getTraLoiBon() {
		return traLoiBon;
	}
	public void setTraLoiBon(String traLoiBon) {
		this.traLoiBon = traLoiBon;
	}
	public String getTraLoiChon() {
		return traLoiChon;
	}
	public void setTraLoiChon(String traLoiChon) {
		this.traLoiChon = traLoiChon;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public int getViTri() {
		return viTri;
	}
	public void setViTri(int viTri) {
		this.viTri = viTri;
	}
	public String getIdLanThi() {
		return idLanThi;
	}
	public void setIdLanThi(String idLanThi) {
		this.idLanThi = idLanThi;
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

	public List<LoaiBaiThiBean> getListLoai() {
		return listLoai;
	}

	public void setListLoai(List<LoaiBaiThiBean> listLoai) {
		this.listLoai = listLoai;
	}

	public String getInputSearch() {
		return inputSearch;
	}

	public void setInputSearch(String inputSearch) {
		this.inputSearch = inputSearch;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getIdLoai() {
		return idLoai;
	}

	public void setIdLoai(String idLoai) {
		this.idLoai = idLoai;
	}

}
