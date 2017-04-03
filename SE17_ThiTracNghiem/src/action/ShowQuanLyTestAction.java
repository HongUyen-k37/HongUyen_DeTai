package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiThiActionForm;
import model.bean.UserBean;
import model.bo.BaiThiBO;

public class ShowQuanLyTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BaiThiActionForm frm = (BaiThiActionForm) form;
		BaiThiBO bt = new BaiThiBO();
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null || user.getRole()!=2) return mapping.findForward("Login");
		// Lay list full
		String idUser = user.getIdUser();
		String inputSearch = frm.getInputSearch();
		String search = frm.getSearch();
		frm.setListLoai(bt.getListLoaiBT());
		if (inputSearch == null && search == null) {
			frm.setLst(bt.getListBaiThi(user.getIdUser()));
		} else {
			if (!search.equals(null)) {
				search = new String(search.getBytes("ISO-8859-1"), "UTF-8");
				if (inputSearch.equals(""))
					frm.setLst(bt.searchBaiThiTatCa(search,idUser));
				else
					frm.setLst(bt.searchBaiThi(search, inputSearch,idUser));
			} else
				return mapping.findForward("Error");
		}
		// Lay list tim miem
		return mapping.findForward("long");
	}

}
