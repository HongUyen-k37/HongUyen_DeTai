package form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class FileActionForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FormFile file;

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}
	public String getIdBaiThi() {
		return idBaiThi;
	}

	public void setIdBaiThi(String idBaiThi) {
		this.idBaiThi = idBaiThi;
	}
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	private String idBaiThi;
	private String action;
}
