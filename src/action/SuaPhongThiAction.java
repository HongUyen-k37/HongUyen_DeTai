package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PhongThiActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bean.PhongThiBean;
import model.bo.KyThiBO;
import model.bo.PhongThiBO;

public class SuaPhongThiAction extends Action  {
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
		//get maThiSinh
		String maPhongThi = frm.getMaPhongThi();
		if(maPhongThi==null || maPhongThi.equals("")) 
			return mapping.findForward("error");
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		frm.setListKyThi(listKyThi);
		//get makythi
		String maKyThi = frm.getMaKyThi();
		System.out.println(maKyThi);
		String soHieuPhongThi = frm.getSoHieuPhongThi();
		int soLuongThiSinh = frm.getSoLuongThiSinh();
		PhongThiBean pt =new PhongThiBean(maPhongThi, maKyThi, soHieuPhongThi, soLuongThiSinh);
		ptBO.update(pt);
		return mapping.findForward("success");
	}
	
}
