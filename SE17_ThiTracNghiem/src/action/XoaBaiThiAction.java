package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiThiActionForm;
import model.bean.UserBean;
import model.bo.BaiThiBO;

public class XoaBaiThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null || user.getRole()!=2) return mapping.findForward("Login");
		BaiThiActionForm frm = (BaiThiActionForm) form;
		BaiThiBO bt = new BaiThiBO();
		String idBaiThi = frm.getIdBaiThi();
		if(idBaiThi==null || idBaiThi.equals(""))
			return mapping.findForward("Error");
		bt.delete(idBaiThi);		
		return mapping.findForward("long");
	}
	

}
