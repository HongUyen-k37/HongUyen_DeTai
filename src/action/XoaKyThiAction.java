package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KyThiActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;

public class XoaKyThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		KyThiActionForm frm = (KyThiActionForm)form;
		KyThiBO ktBO = new KyThiBO();
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("login");
		//get maKyThi
		String maKyThi = frm.getMaKyThi();
		System.out.println(maKyThi);
		if(maKyThi==null || maKyThi.equals("")) 
			return mapping.findForward("error");
		//get thông tin kỳ thi
		KyThiBean kyThi = ktBO.getKyThi(maKyThi);
		if(kyThi.getTrangThai()!=0){
			return mapping.findForward("error");
		}
		else{
			//xóa
			ktBO.delete(maKyThi);
			session.setAttribute("notice", "Xoá kỳ thi thành công");
			return mapping.findForward("success");
		}
	}
	
}
