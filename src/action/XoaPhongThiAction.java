package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PhongThiActionForm;
import model.bean.NguoiDungBean;
import model.bo.PhongThiBO;

public class XoaPhongThiAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		PhongThiActionForm frm = (PhongThiActionForm)form;
		PhongThiBO ptBO = new PhongThiBO();
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get maPhongThi
		String maPhongThi = frm.getMaPhongThi();
		System.out.println(maPhongThi);
		if(maPhongThi==null || maPhongThi.equals(""))
			return mapping.findForward("error");
		ptBO.delete(maPhongThi);
		return mapping.findForward("success");
	}	
}
