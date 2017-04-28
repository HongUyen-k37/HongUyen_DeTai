package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThiSinhActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;
import model.bo.ThiSinhBO;

public class XoaThiSinhAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ThiSinhActionForm frm = (ThiSinhActionForm)form;
		ThiSinhBO tsBO = new ThiSinhBO();
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get maThiSinh
		String maThiSinh = frm.getMaThiSinh();
		if(maThiSinh==null || maThiSinh.equals("")) 
			return mapping.findForward("error");
		//get thông tin kỳ thi
		String maKyThi = frm.getMaKyThi();
		System.out.println(maKyThi);
		if(maKyThi==null || maKyThi.equals("")) 
			return mapping.findForward("error");
		KyThiBO ktBO = new KyThiBO();
		KyThiBean kyThi = ktBO.getKyThi(maKyThi);
		if(kyThi.getTrangThai()!=0){
			return mapping.findForward("errorStatus");
		}
		tsBO.delete(maThiSinh);
		return mapping.findForward("success");
	}
}
