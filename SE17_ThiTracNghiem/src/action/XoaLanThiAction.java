package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import form.LanThiActionForm;
import model.bean.BaiThiBean;
import model.bean.UserBean;
import model.bo.BaiThiBO;
import model.bo.LanThiBO;

public class XoaLanThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null || user.getRole()!=2) return mapping.findForward("Login");
		LanThiActionForm frm= (LanThiActionForm) form;
		BaiThiBO bt = new BaiThiBO();
		String idBaiThi = frm.getIdBaiThi();
		BaiThiBean baiThi=bt.getBaiThi(idBaiThi);
		if(!user.getIdUser().equals(baiThi.getIdUser())) return mapping.findForward("Login");
		String idUser=frm.getIdUser();
		LanThiBO lanThiBO=new LanThiBO();
		lanThiBO.delete(idUser, idBaiThi);
		return new ActionRedirect("/TKChiTietBaiThi.do?idBaiThi="+idBaiThi);
	}
	

}
