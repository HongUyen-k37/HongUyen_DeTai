package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NhapCauHoiActionForm;
import model.bean.BaiThiBean;
import model.bean.UserBean;
import model.bo.BaiThiBO;
import model.bo.CauHoiBO;

public class ShowNhapCauHoiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NhapCauHoiActionForm frm=(NhapCauHoiActionForm) form;
		String idBaiThi=frm.getIdBaiThi();
		BaiThiBO baiThiBO=new BaiThiBO();
		
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null || user.getRole()!=2) return mapping.findForward("Login");
		if(idBaiThi==null || "".equals(idBaiThi)) return mapping.findForward("Error");
		BaiThiBean baiThi=baiThiBO.getBaiThi(idBaiThi);
		frm.setTenBaiThi(baiThi.getTenBaiThi());
		frm.setSoCauHoi(baiThi.getSoCauHoi());
		CauHoiBO ch=new CauHoiBO();
		String search = frm.getSearch();
		String inputSearch = frm.getInputSearch();
		frm.setListCauHoiBaiThi(ch.getListStringID(idBaiThi));
		frm.setListCauHoi(ch.getListCauHoiUser(user.getIdUser()));
		frm.setLst(baiThiBO.getListLoaiBT());
		
		if (inputSearch == null && search == null) {
			frm.setListCauHoi(ch.getListCauHoiUser(user.getIdUser()));
		} else {
			if (!search.equals(null)) {
				search = new String(search.getBytes("ISO-8859-1"), "UTF-8");
				if (inputSearch.equals(""))
					frm.setListCauHoi(ch.searhCauHoiAll(search, user.getIdUser()));
				else
					frm.setListCauHoi(ch.searchCauHoi(search, user.getIdUser(), inputSearch));
			} else
				return mapping.findForward("Error");
		}
		/*
		if (search == null) {
			frm.setListCauHoi(ch.getListCauHoiUser(user.getIdUser()));
		} else {
			search = new String(search.getBytes("ISO-8859-1"), "UTF-8");
			frm.setListCauHoi(ch.searhCauHoiAll(search,user.getIdUser()));
		}*/
		return mapping.findForward("ShowNhapCauHoi");
	}
	
}
