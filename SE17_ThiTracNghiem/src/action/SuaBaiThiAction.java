package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiThiActionForm;
import model.bean.BaiThiBean;
import model.bean.UserBean;
import model.dao.BaiThiDao;

public class SuaBaiThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		BaiThiActionForm frm = (BaiThiActionForm) form;
		BaiThiDao bt = new BaiThiDao();
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null || user.getRole()!=2) return mapping.findForward("Login");
		String idBaiThi = frm.getIdBaiThi();
		if(idBaiThi == null || idBaiThi.equals(""))
			return mapping.findForward("Error");
		String tenBaiThi = frm.getTenBaiThi();
		int thoiGian = frm.getThoiGian();
		int soCauHoi = frm.getSoCauHoi();
		String moTa = frm.getMoTa();
		String idLoai = frm.getIdLoai();
		Boolean active = frm.isActive();
		String password = frm.getPassword();
		BaiThiBean baiThi = new BaiThiBean(idBaiThi, tenBaiThi, thoiGian, soCauHoi, moTa, idLoai, password, null, active);
		bt.update(baiThi);
		return mapping.findForward("long");
	}

}
