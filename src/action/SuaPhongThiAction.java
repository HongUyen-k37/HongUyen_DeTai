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

public class SuaPhongThiAction extends Action  {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		PhongThiActionForm frm = (PhongThiActionForm)form;
		PhongThiBO ptBO = new PhongThiBO();
	/*	KyThiActionForm frm1 = (KyThiActionForm)form;*/
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get maThiSinh
		String maPhongThi = frm.getMaPhongThi();
		if(maPhongThi==null || maPhongThi.equals("")) 
			return mapping.findForward("error");
	/*	
		String maKyThi = frm1.getMaKyThi();*/
		String soHieuPhongThi = frm.getSoHieuPhongThi();
		int soLuongThiSinh = frm.getSoLuongThiSinh();
		PhongThiBean pt =new PhongThiBean(maPhongThi, "KT0001", soHieuPhongThi, soLuongThiSinh);
		ptBO.update(pt);
		return mapping.findForward("success");
	}
	
}