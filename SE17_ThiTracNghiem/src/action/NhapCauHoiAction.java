package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NhapCauHoiActionForm;
import model.bo.BaiThi_CauHoiBO;

public class NhapCauHoiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		NhapCauHoiActionForm frm=(NhapCauHoiActionForm) form;
		String idBaiThi=frm.getIdBaiThi();
		String idCauHoi=frm.getIdCauHoi();
		String action=frm.getAction();
		if(action==null) return null;
		BaiThi_CauHoiBO btch=new BaiThi_CauHoiBO();
		if(action.equals("insert")){
			btch.insert(idBaiThi, idCauHoi);
		}
		if(action.equals("delete")){
			btch.delete(idBaiThi, idCauHoi);
		}
		return null;
	}
	
}
