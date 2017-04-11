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
import model.bean.PhongThiBean;
import model.bo.PhongThiBO;

public class ThemPhongThiAction extends Action  {
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
		
		if ("submit".equals(frm.getSubmit())) {			
			String soHieuPhongThi = frm.getSoHieuPhongThi();
			int soLuongThiSinh = frm.getSoLuongThiSinh();
		
			PhongThiBean pt = new PhongThiBean(null, "KT0001", soHieuPhongThi, soLuongThiSinh);
			ptBO.insert(pt);
			return mapping.findForward("success");
		}
		return mapping.findForward("ShowPhongThi");
	}
}
