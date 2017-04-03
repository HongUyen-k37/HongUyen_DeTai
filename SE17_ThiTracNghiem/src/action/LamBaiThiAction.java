package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import form.BaiThiActionForm;
import model.bean.BaiThiBean;
import model.bean.LanThiBean;
import model.bean.UserBean;
import model.bo.BaiThiBO;
import model.bo.LanThiBO;

public class LamBaiThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BaiThiBO baiThiBO=new BaiThiBO();
		LanThiBO lanThiBO=new LanThiBO();
		
		BaiThiActionForm frm = (BaiThiActionForm)form;
		String idBaiThi=frm.getIdBaiThi();
		if(idBaiThi==null || idBaiThi.equals("")) return mapping.findForward("Error");
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null) return mapping.findForward("Login");
		
		BaiThiBean baiThi=baiThiBO.getBaiThi(idBaiThi);
		if(baiThi==null || !baiThi.isActive()) return mapping.findForward("Error");
		LanThiBean lanThi=lanThiBO.getLanThi(user.getIdUser(), idBaiThi);
		if(baiThi.getPassword()!=null && !baiThi.getPassword().equals("")){
			String password=frm.getPassword();
			if(password==null || !password.equals(baiThi.getPassword())){
				frm.setTenBaiThi(baiThi.getTenBaiThi());
				if(password!=null && !password.equals(baiThi.getPassword())) frm.setError("Sai mật khẩu. Xin vui lòng thử lại");
				return mapping.findForward("CheckPassword");
			}
		}
		if(lanThi==null){
			lanThiBO.taoLanThi(user.getIdUser(), idBaiThi);
			lanThi=lanThiBO.getLanThi(user.getIdUser(), idBaiThi);
		}
		return new ActionRedirect("LanThi.do?idLanThi="+lanThi.getIdLanThi());
	}
	
}
