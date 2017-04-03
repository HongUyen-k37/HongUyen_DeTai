package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.PhanTrang;
import form.CauHoiActionForm;
import model.bean.CauHoiBean;
import model.bean.UserBean;
import model.bo.BaiThiBO;
import model.bo.CauHoiBO;

public class ShowQuanLyCauHoiAction extends Action{

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CauHoiActionForm frm=(CauHoiActionForm) form;
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null || user.getRole()!=2) return mapping.findForward("Login");
	
		CauHoiBO ch=new CauHoiBO();
		BaiThiBO bt = new BaiThiBO();
		String search = frm.getSearch();
		String inputSearch = frm.getInputSearch();
		List<CauHoiBean> lst=ch.getListCauHoiUser(user.getIdUser());
		frm.setListLoai(bt.getListLoaiBT());//List the loai cau hoi	
		//Tim kiem
		if (inputSearch == null && search == null) {
			lst=ch.getListCauHoiUser(user.getIdUser());
		} else {
			if (!search.equals(null)) {
				search = new String(search.getBytes("ISO-8859-1"), "UTF-8");
				if (inputSearch.equals(""))
					lst=ch.searhCauHoiAll(search, user.getIdUser());
				else
					lst=ch.searchCauHoi(search, user.getIdUser(), inputSearch);
			} else
				return mapping.findForward("Error");
		}
		PhanTrang phanTrang=new PhanTrang(10,frm.getPage(),lst);
		frm.setLst((List<CauHoiBean>) phanTrang.getLst());
		frm.setTotal(phanTrang.getTotal());
		return mapping.findForward("ShowQuanLyCauHoi");
	}

}
