//UyenTTH 9:00 22/2/2017
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CauHoiActionForm;
import model.bean.CauHoiBean;
import model.bean.UserBean;
import model.bo.CauHoiBO;

public class ThemCauHoiAction extends Action {

	/* 
	 * 
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		CauHoiActionForm frm = (CauHoiActionForm) form;
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		if (user == null || user.getRole() != 2)
			return mapping.findForward("Login");

		CauHoiBO chBO = new CauHoiBO();
		
		if ("submit".equals(frm.getSubmit())) {
			
			String noiDung = frm.getNoiDung();
			String dapAn = frm.getDapAn();
			String traLoiMot = frm.getTraLoiMot();
			String traLoiHai = frm.getTraLoiHai();
			String traLoiBa = frm.getTraLoiBa();
			String traLoiBon = frm.getTraLoiBon();
			String idLoai = frm.getIdLoai();
			System.out.println(dapAn);
			CauHoiBean cauHoi = new CauHoiBean(null, noiDung, dapAn, traLoiMot, traLoiHai, traLoiBa, traLoiBon,
					user.getIdUser(),idLoai);
			chBO.insert(cauHoi);
			return mapping.findForward("ShowQuanLyCauHoi");
		}

		return mapping.findForward("ShowQuanLyCauHoi");
	}

}
