package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PhongThiActionForm;
import form.ThiSinhActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;
import model.bo.PhongThiBO;
import model.bo.ThiSinhBO;

public class ThongTinKyThiAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PhongThiActionForm frm = (PhongThiActionForm)form;
		ThiSinhActionForm frm1 = (ThiSinhActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		
		
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		frm.setListKyThi(listKyThi);
		frm1.setListKyThi(listKyThi);;
		//get list phongthi, thisinh theo ky thi
		PhongThiBO ptBO = new PhongThiBO();
		ThiSinhBO tsBO = new ThiSinhBO();
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		String maKyThi1 = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null||frm1.getMaKyThi()!=null){
			maKyThi = frm.getMaKyThi();
			maKyThi1 = frm1.getMaKyThi();
		}
		
		frm.setListPhongThi(ptBO.getListPhongThiTheoMaKyThi(maKyThi));
		frm1.setListThiSinh(tsBO.getListThiSinh(maKyThi1));
		//danh sbd
		if ("submit".equals(frm1.getSubmit())){
			tsBO.danhSoBaoDanh(frm1.getTiepDauNgu(), frm1.getSoBatDau(), frm1.getSoLuong(), frm1.getMaKyThi());
		}
		//show list
		frm1.setListThiSinh(tsBO.getListThiSinh(frm1.getMaKyThi()));
		return mapping.findForward("success");
	}
}
