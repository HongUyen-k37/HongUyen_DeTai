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
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bean.PhongThiBean;
import model.bo.KyThiBO;
import model.bo.MonThiBO;
import model.bo.PhongThiBO;
import model.bo.ThiSinhBO;

public class DanhSachPhongThiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PhongThiActionForm frm = (PhongThiActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		frm.setListKyThi(listKyThi);
		//get ma ky thi
		String maKyThi = null;
		if(session.getAttribute("maKyThi")!=null){
			maKyThi = (String)session.getAttribute("maKyThi");
		}
		else{
			maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		}
		if(frm.getMaKyThi()!=null ){
			maKyThi = frm.getMaKyThi();
			session.setAttribute("maKyThi", maKyThi);
		}
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//get list mon thi cua ky thi
		MonThiBO mtBO = new MonThiBO();
		frm.setListMonThi(mtBO.getListMonThi(maKyThi));
		//get list phong thi theo ky thi
		PhongThiBO ptBO = new PhongThiBO();
		List<PhongThiBean> listPhongThi = ptBO.getListPhongThiTheoMaKyThi(maKyThi);
		frm.setListPhongThi(listPhongThi);
		//get ma phong thi
		String maPhongThi = listPhongThi.size()==0?"":listPhongThi.get(0).getMaPhongThi();
		if(frm.getMaPhongThi()!=null)
			maPhongThi = frm.getMaPhongThi();
		//get thong tin phong thi
		frm.setPhongThi(ptBO.getPhongThi(maPhongThi));
		//get list thi sinh theo phong thi
		ThiSinhBO tsBO = new ThiSinhBO();
		frm.setListThiSinh(tsBO.getListThiSinhTheoPhongThi(maPhongThi));
		return mapping.findForward("success");
	}
	
}
