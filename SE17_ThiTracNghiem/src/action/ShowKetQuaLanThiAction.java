//UyenTTH 10:00 23/02/2017
package action;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KetQuaThiActionForm;
import model.bean.BaiThiBean;
import model.bean.LanThiBean;
import model.bean.UserBean;
import model.bo.BaiThiBO;
import model.bo.KetQuaThiBO;
import model.bo.LanThiBO;

public class ShowKetQuaLanThiAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//kiểm tra đăng nhập
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		//if(idBaiThi==null || idBaiThi.equals("")) return mapping.findForward("Error");
		if(user==null) return mapping.findForward("Login");
		
		KetQuaThiActionForm frm = (KetQuaThiActionForm) form;
		KetQuaThiBO kq = new KetQuaThiBO();
		LanThiBO lanThiBO=new LanThiBO();
		BaiThiBO baiThiBO=new BaiThiBO();
		String idLanThi = frm.getIdLanThi();
		LanThiBean lanThi=lanThiBO.getLanThi(idLanThi);
		if(lanThi==null) return mapping.findForward("Error");
		if(!lanThi.getIdUser().equals(user.getIdUser())) return mapping.findForward("Login"); 
		
		lanThiBO.hoanTatLanThi(idLanThi);
		
		BaiThiBean baiThi=baiThiBO.getBaiThi(lanThi.getIdBaiThi());
		frm.setLst(kq.getListKetQua(idLanThi));
		frm.setTenBaiThi(baiThi.getTenBaiThi());
		frm.setSoCauHoi(baiThi.getSoCauHoi());
		frm.setTongCauHoiDung(lanThi.getSoCauTraLoiDung());
		
		long seconds=(lanThi.getThoiGianKetThuc()-lanThi.getThoiGianThi())/1000;
		if(seconds-1>baiThi.getThoiGian()*60 || seconds<0) return new ActionForward("/ErrorLanThiPage.jsp");
		
		String time=seconds/3600+" giờ "+(seconds/60)%60+" phút "+seconds%60+" giây";
		
		frm.setThoiGianThi(time);
		frm.setThoiGianBatDauThi(new SimpleDateFormat("HH:mm dd/MM/yyyy").format(new Date(lanThi.getThoiGianThi())));
		return mapping.findForward("KetQua");	
	}	
}
