package model.bean;

public class ThongKeBean {
	private String hoDem;
	private String ten;
	private String ngaySinh;
	private String soBaoDanh;
	private int soPhach;
	private float diemChamThi;
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

	public int getSoPhach() {
		return soPhach;
	}
	public void setSoPhach(int soPhach) {
		this.soPhach = soPhach;
	}
	public ThongKeBean(String hoDem, String ten, String ngaySinh, String soBaoDanh, int soPhach,
			float diemChamThi) {
		super();
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.soBaoDanh = soBaoDanh;
		this.soPhach = soPhach;
		this.diemChamThi = diemChamThi;
	}
	public float getDiemChamThi() {
		return diemChamThi;
	}
	public void setDiemChamThi(float diemChamThi) {
		this.diemChamThi = diemChamThi;
	}
	public ThongKeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
