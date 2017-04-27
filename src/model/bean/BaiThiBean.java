package model.bean;

public class BaiThiBean {
	private String maKyThi;
	private String maMonThi;
	private String maThiSinh;
	private int soPhach;
	private int tuiSo;
	private int trangThaiDuThi;
	private float diemChamThi;
	private float diemChinhThuc;
	private String ghiChu;
	private String phong;
	private String soBaoDanh;
	private String hoDem;
	private String ten;
	private String ngaySinh;
	
	
	public BaiThiBean(String maThiSinh, int trangThaiDuThi, String soBaoDanh, String hoDem, String ten,
			String ngaySinh) {
		super();
		this.maThiSinh = maThiSinh;
		this.trangThaiDuThi = trangThaiDuThi;
		this.soBaoDanh = soBaoDanh;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
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
	public BaiThiBean(int soPhach, int tuiSo, String phong, String soBaoDanh) {
		super();
		this.soPhach = soPhach;
		this.tuiSo = tuiSo;
		this.phong = phong;
		this.soBaoDanh = soBaoDanh;
	}
	public String getPhong() {
		return phong;
	}
	public void setPhong(String phong) {
		this.phong = phong;
	}
	public String getSoBaoDanh() {
		return soBaoDanh;
	}
	public void setSoBaoDanh(String soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	public String getMaMonThi() {
		return maMonThi;
	}
	public void setMaMonThi(String maMonThi) {
		this.maMonThi = maMonThi;
	}
	public String getMaThiSinh() {
		return maThiSinh;
	}
	public void setMaThiSinh(String maThiSinh) {
		this.maThiSinh = maThiSinh;
	}
	public int getSoPhach() {
		return soPhach;
	}
	public void setSoPhach(int soPhach) {
		this.soPhach = soPhach;
	}
	public int getTuiSo() {
		return tuiSo;
	}
	public void setTuiSo(int tuiSo) {
		this.tuiSo = tuiSo;
	}
	public int getTrangThaiDuThi() {
		return trangThaiDuThi;
	}
	public void setTrangThaiDuThi(int trangThaiDuThi) {
		this.trangThaiDuThi = trangThaiDuThi;
	}
	public float getDiemChamThi() {
		return diemChamThi;
	}
	public void setDiemChamThi(float diemChamThi) {
		this.diemChamThi = diemChamThi;
	}
	public float getDiemChinhThuc() {
		return diemChinhThuc;
	}
	public void setDiemChinhThuc(float diemChinhThuc) {
		this.diemChinhThuc = diemChinhThuc;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public BaiThiBean(String maKyThi, String maMonThi, String maThiSinh, int soPhach, int tuiSo, int trangThaiDuThi,
			float diemChamThi, float diemChinhThuc, String ghiChu) {
		super();
		this.maKyThi = maKyThi;
		this.maMonThi = maMonThi;
		this.maThiSinh = maThiSinh;
		this.soPhach = soPhach;
		this.tuiSo = tuiSo;
		this.trangThaiDuThi = trangThaiDuThi;
		this.diemChamThi = diemChamThi;
		this.diemChinhThuc = diemChinhThuc;
		this.ghiChu = ghiChu;
	}
	public BaiThiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
