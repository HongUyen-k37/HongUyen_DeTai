package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiThiActionForm;
import form.PhongThiActionForm;
import form.ThiSinhActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bean.PhongThiBean;
import model.bean.ThiSinhBean;
import model.bo.KyThiBO;
import model.bo.PhongThiBO;
import model.bo.ThiSinhBO;

public class XuLyBaiThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BaiThiActionForm frm = (BaiThiActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		frm.setListKyThi(listKyThi);
		
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null)
			maKyThi = frm.getMaKyThi();
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//get list phòng để select
		PhongThiActionForm frm1= (PhongThiActionForm) form;
		PhongThiBO pt = new PhongThiBO();
		List<PhongThiBean> listPhongThi = pt.getListPhongThi();
		frm1.setListPhongThi(listPhongThi);
		
		//get list thí sinh hiển thị ra table
		ThiSinhActionForm frm2 = (ThiSinhActionForm) form;
		ThiSinhBO ts = new ThiSinhBO();
		List<ThiSinhBean> listThiSinh = ts.getListThiSinh(maKyThi);
		frm2.setListThiSinh(listThiSinh);
		
		return mapping.findForward("success");
	}
	
}
