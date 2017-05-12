package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.PhanTrang;
import form.KyThiActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;

public class DanhSachKyThiAction extends Action{

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		KyThiActionForm frm = (KyThiActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//xoa session kythi
		if((String)session.getAttribute("maKyThi")!=null)
			session.removeAttribute("maKyThi");
		//show list kythi
		KyThiBO ktBO = new KyThiBO();
		PhanTrang phanTrang=new PhanTrang(5,frm.getPage(), ktBO.getListKyThi());
		frm.setListKyThi((List<KyThiBean>) phanTrang.getLst());
		frm.setTotal(phanTrang.getTotal());
		frm.setTong(ktBO.getListKyThi().size());
		
		return mapping.findForward("success");
	}
	
}
