package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.PhanTrang;
import form.ThiSinhActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bean.ThiSinhBean;
import model.bo.KyThiBO;
import model.bo.MonThiBO;
import model.bo.ThiSinhBO;

public class DanhSachThiSinhAction extends Action{

	@SuppressWarnings("unchecked")
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
		//get list môn thi của kỳ thi
		MonThiBO mtBO = new MonThiBO();
		frm.setListMonThi(mtBO.getListMonThi(maKyThi));
		ThiSinhBO tsBO = new ThiSinhBO();
		//get list thi sinh theo ky thi
		PhanTrang phanTrang=new PhanTrang(10,frm.getPage(), tsBO.getListThiSinh(maKyThi));
		frm.setListThiSinh((List<ThiSinhBean>) phanTrang.getLst());
		frm.setTotal(phanTrang.getTotal());
		frm.setTong(tsBO.getListThiSinh(maKyThi).size());
		return mapping.findForward("success");
	}
	
}
