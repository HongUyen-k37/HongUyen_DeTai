package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThiSinhActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;
import model.bo.MonThiBO;
import model.bo.ThiSinhBO;

public class DanhSachThiSinhAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ThiSinhActionForm frm = (ThiSinhActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		if(listKyThi.size()!=0){
			frm.setListKyThi(listKyThi);
		}
		else
			return mapping.findForward("error");
		
		
		//get mã kỳ thi
		ThiSinhBO tsBO = new ThiSinhBO();
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null)
			maKyThi = frm.getMaKyThi();
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//get list môn thi của kỳ thi
		MonThiBO mtBO = new MonThiBO();
		frm.setListMonThi(mtBO.getListMonThi(maKyThi));
		//get list thi sinh theo ky thi
		frm.setListThiSinh(tsBO.getListThiSinh(maKyThi));
		return mapping.findForward("success");
	}
	
}
