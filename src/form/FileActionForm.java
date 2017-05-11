package form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import model.bean.KyThiBean;

public class FileActionForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FormFile file;
	private String maKyThi;
	private KyThiBean kyThi;

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
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
}
