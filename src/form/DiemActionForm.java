package form;

import java.util.ArrayList;
import java.util.List;


import org.apache.struts.action.ActionForm;

import model.bean.BaiThiBean;
import model.bean.DiemChuanBean;
import model.bean.DiemThiBean;
import model.bean.KyThiBean;
import model.bean.MonThiBean;

public class DiemActionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String namTuyenSinh;
	private String maKyThi;
	private String xoaHet;
	private KyThiBean kyThi;
	private MonThiBean monThi;
	private List<KyThiBean> listKyThi;
	private float diemLiet;
	private boolean check;
	private float diemChuan;
	private String kiemTra;
	private List<DiemChuanBean> listResult = new ArrayList<>();
	private List<BaiThiBean> listBaiThi;
	private List<Integer> listTui;
	private int tuiSo;
	private List<MonThiBean> listMonThi;
	private String maMonThi;
	private String save;
	private List<DiemThiBean> listDiemThi;
	private String submit;
	private String notice;
	private String error;
	//get list value
	public DiemThiBean getDiemThi(int index){
		if(listDiemThi==null) listDiemThi=new ArrayList<>();
		while(index >= listDiemThi.size()){
			listDiemThi.add(new DiemThiBean());
		}
		return this.listDiemThi.get(index);
	}
	public void setTrangThai(int index, DiemThiBean diemThi){
		this.listDiemThi.add(index, diemThi);
	}
	
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
	public boolean getCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public List<DiemChuanBean> getListResult() {
		return listResult;
	}
	public void setListResult(List<DiemChuanBean> listResult) {
		this.listResult = listResult;
	}
	public List<BaiThiBean> getListBaiThi() {
		return listBaiThi;
	}
	public void setListBaiThi(List<BaiThiBean> listBaiThi) {
		this.listBaiThi = listBaiThi;
	}
	public List<Integer> getListTui() {
		return listTui;
	}
	public void setListTui(List<Integer> listTui) {
		this.listTui = listTui;
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
	public int getTuiSo() {
		return tuiSo;
	}
	public void setTuiSo(int tuiSo) {
		this.tuiSo = tuiSo;
	}
	public String getSave() {
		return save;
	}
	public void setSave(String save) {
		this.save = save;
	}
	public List<DiemThiBean> getListDiemThi() {
		return listDiemThi;
	}
	public void setListDiemThi(List<DiemThiBean> listDiemThi) {
		this.listDiemThi = listDiemThi;
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
	public String getXoaHet() {
		return xoaHet;
	}
	public void setXoaHet(String xoaHet) {
		this.xoaHet = xoaHet;
	}
	public String getNamTuyenSinh() {
		return namTuyenSinh;
	}
	public void setNamTuyenSinh(String namTuyenSinh) {
		this.namTuyenSinh = namTuyenSinh;
	}
	public MonThiBean getMonThi() {
		return monThi;
	}
	public void setMonThi(MonThiBean monThi) {
		this.monThi = monThi;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}


}
