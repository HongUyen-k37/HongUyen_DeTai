package action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import form.LanThiActionForm;
import model.bean.BaiThiBean;
import model.bean.LanThiBean;
import model.bean.UserBean;
import model.bo.BaiThiBO;
import model.bo.CauHoiBO;
import model.bo.LanThiBO;
import model.bo.UserBO;

public class ShowLanThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		LanThiBO lanThiBO=new LanThiBO();
		BaiThiBO baiThiBO=new BaiThiBO();
		CauHoiBO cauHoiBO=new CauHoiBO();
		UserBO userBO=new UserBO();
		LanThiActionForm frm=(LanThiActionForm) form;
		
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null) return mapping.findForward("Login");
		
		String idLanThi=frm.getIdLanThi();
		if(idLanThi==null || idLanThi.equals("")) return mapping.findForward("Error");
		LanThiBean lanThi=lanThiBO.getLanThi(idLanThi);
		
		String idBaiThi=lanThi.getIdBaiThi();
		
		BaiThiBean baiThi=baiThiBO.getBaiThi(idBaiThi);
		baiThi.setSoLuotLam(baiThiBO.getLuotLam(idBaiThi));

		long timeNow=new Date().getTime()/1000;
		long timeStart=lanThi.getThoiGianThi()/1000;
		int timeDo=baiThi.getThoiGian()*60;
		
		if(timeNow-timeStart>=timeDo || lanThi.isHoanTat()) return new ActionRedirect("/KetQua.do?idLanThi="+lanThi.getIdLanThi());
		//Lấy danh sách câu hỏi
		frm.setListCauHoi(cauHoiBO.getListViTriThi(lanThi.getIdLanThi()));

		frm.setIdLanThi(lanThi.getIdLanThi());
		frm.setTimeLeft((timeDo-(timeNow-timeStart)));
		frm.setBaiThi(baiThi);
		frm.setUser(userBO.getUser(baiThi.getIdUser()));
		return mapping.findForward("ShowLanThi");
	}
	
}
