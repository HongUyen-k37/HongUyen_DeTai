package model.bean;

public class DiemThiBean {
	private int soPhach;
	private float diemChamThi;
	private String diemChu;
	public int getSoPhach() {
		return soPhach;
	}
	public void setSoPhach(int soPhach) {
		this.soPhach = soPhach;
	}
	public float getDiemChamThi() {
		return diemChamThi;
	}
	public void setDiemChamThi(float diemChamThi) {
		this.diemChamThi = diemChamThi;
	}
	public String getDiemChu() {
		return diemChu;
	}
	public void setDiemChu(String diemChu) {
		this.diemChu = diemChu;
	}
	public DiemThiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiemThiBean(int soPhach, float diemChamThi, String diemChu) {
		super();
		this.soPhach = soPhach;
		this.diemChamThi = diemChamThi;
		this.diemChu = diemChu;
	}
}
