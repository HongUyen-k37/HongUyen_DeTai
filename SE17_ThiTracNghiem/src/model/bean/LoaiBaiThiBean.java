package model.bean;

public class LoaiBaiThiBean {
	private String idLoai;
	private String tenLoai;
	
	
	public String getIdLoai() {
		return idLoai;
	}


	public void setIdLoai(String idLoai) {
		this.idLoai = idLoai;
	}


	public String getTenLoai() {
		return tenLoai;
	}


	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}


	public LoaiBaiThiBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoaiBaiThiBean(String idLoai, String tenLoai) {
		super();
		this.idLoai = idLoai;
		this.tenLoai = tenLoai;
	}
	
	
}
