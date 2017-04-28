package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KyThiActionForm;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;

public class TimKiemKyThiAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		KyThiActionForm frm = (KyThiActionForm) form;
		KyThiBO kt = new KyThiBO();
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		
		// Lay list full
		String search = frm.getSearch();
		System.out.println(search);
		String submit = frm.getSubmit();
		System.out.println(submit);
		frm.setListKyThi(kt.getListKyThi());
		if (submit == null ||search == null || search.equals("")) 
			frm.setListKyThi(kt.getListKyThi());
		else{		
			/*search = new String(search.getBytes("ISO-8859-1"), "UTF-8");*/
			if(kt.searchKyThi(search).size()!=0)
				frm.setListKyThi(kt.searchKyThi(search));	
			else{
				frm.setListKyThi(kt.searchKyThi(search));	
				frm.setError("Không tìm thấy dữ liệu hợp lệ!"); 
			}
		}
		// Lay list tim kiem
			
		return mapping.findForward("success");
	}

}
