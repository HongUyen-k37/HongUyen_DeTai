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
import model.bo.KyThiBO;
import model.bo.PhongThiBO;

public class DanhSachPhongThiAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PhongThiActionForm frm = (PhongThiActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		
		
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		frm.setListKyThi(listKyThi);
		//get list thi sinh theo ky thi
		PhongThiBO ptBO = new PhongThiBO();
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null)
			maKyThi = frm.getMaKyThi();
		
		frm.setListPhongThi(ptBO.getListPhongThiTheoMaKyThi(maKyThi));
		return mapping.findForward("success");
	}
}
