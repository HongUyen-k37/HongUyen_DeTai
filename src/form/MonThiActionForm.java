package form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.MonThiBean;

public class MonThiActionForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKyThi;
	private List<MonThiBean> listInput;
	private List<MonThiBean> listOutput;
	private MonThiBean maMonThi;
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	public List<MonThiBean> getListInput() {
		return listInput;
	}
	public void setListInput(List<MonThiBean> listInput) {
		this.listInput = listInput;
	}
	public List<MonThiBean> getListOutput() {
		return listOutput;
	}
	public void setListOutput(List<MonThiBean> listOutput) {
		this.listOutput = listOutput;
	}
	public MonThiBean getMaMonThi() {
		return maMonThi;
	}
	public void setMaMonThi(MonThiBean maMonThi) {
		this.maMonThi = maMonThi;
	}
	//get list value
	public MonThiBean getInput(int index){
		if(listInput==null) listInput = new ArrayList<>();
		while(index >= listInput.size()){
			listInput.add(new MonThiBean());
		}
		return this.listInput.get(index);
	}
	public void setInput(int index, MonThiBean monThi){
		this.listInput.add(index, monThi);
	}
}
