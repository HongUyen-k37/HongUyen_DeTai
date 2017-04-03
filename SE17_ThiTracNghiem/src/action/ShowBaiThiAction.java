package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiThiActionForm;
import model.bean.BaiThiBean;
import model.bo.BaiThiBO;
import model.bo.UserBO;

public class ShowBaiThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// TODO Auto-generated method stub
		BaiThiActionForm frm=(BaiThiActionForm) form;
		String idBaiThi=frm.getIdBaiThi();
		if(idBaiThi==null || idBaiThi.equals("")) 
			return mapping.findForward("Error");
		BaiThiBO baiThiBO=new BaiThiBO();
		//LanThiBO lanThiBO = new LanThiBO();
		UserBO userBO=new UserBO();
		BaiThiBean baiThi=baiThiBO.getBaiThi(idBaiThi);
		if(baiThi==null || !baiThi.isActive()) 
			return mapping.findForward("Error");
		
		//Set value cho trang 
		frm.setActive(baiThi.isActive());
		frm.setIdBaiThi(baiThi.getIdBaiThi());
		frm.setIdLoai(baiThi.getIdLoai());
		frm.setMoTa(baiThi.getMoTa());
		frm.setPassword(baiThi.getPassword());
		frm.setSoCauHoi(baiThi.getSoCauHoi());
		frm.setSoLuotLam(baiThiBO.getLuotLam(baiThi.getIdBaiThi()));
		frm.setTenBaiThi(baiThi.getTenBaiThi());
		frm.setThoiGian(baiThi.getThoiGian());
		frm.setUser(userBO.getUser(baiThi.getIdUser()));
//		List<LanThiBean> lanThiBO.getTop(idBaiThi)
//		//get BangXepHang (ThongKeBaiThi -> List User -> get Top 5)
//		frm.setLstU();
		return mapping.findForward("ShowBaiThi");
	}
	
}
