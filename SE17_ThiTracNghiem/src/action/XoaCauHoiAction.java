//UyenTTH 9:00 22/2/2017
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CauHoiActionForm;
import model.bean.UserBean;
import model.bo.CauHoiBO;

public class XoaCauHoiAction extends Action{
	/*
	 *
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null || user.getRole()!=2) return mapping.findForward("Login");
		//kiểm tra xem đã đăng nhập chưa? 
		CauHoiActionForm frm=(CauHoiActionForm) form;
		
		//get idCauHoi 
		String idCauHoi=frm.getIdCauHoi();
		if(idCauHoi==null || idCauHoi.equals("")) return mapping.findForward("Error");

		CauHoiBO chBO=new CauHoiBO();
		chBO.delete(idCauHoi);
		return mapping.findForward("ShowQuanLyCauHoi");
	}
	
}
