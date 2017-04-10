package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThiSinhActionForm;
import model.bean.NguoiDungBean;
import model.bo.ThiSinhBO;

public class DanhSoBaoDanhAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ThiSinhActionForm frm = (ThiSinhActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		
		ThiSinhBO tsBO = new ThiSinhBO();
		//danh sbd
		if ("submit".equals(frm.getSubmit())){
			tsBO.danhSoBaoDanh(frm.getTiepDauNgu(), frm.getSoBatDau(), frm.getSoLuong(), "KT0001");
		}
		//show list
		frm.setListThiSinh(tsBO.getListThiSinh("KT0001"));
		return mapping.findForward("success");
	}
	
}
