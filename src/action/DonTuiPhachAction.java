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
import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bean.NguoiDungBean;
import model.bean.PhongThiBean;
import model.bo.BaiThiBO;
import model.bo.KyThiBO;
import model.bo.MonThiBO;
import model.bo.PhongThiBO;

public class DonTuiPhachAction extends Action{

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
		KyThiBean kyThi = ktBO.getKyThi(maKyThi);
		frm.setKyThi(kyThi);
		//get list mon thi de select
		MonThiBO mtBO = new MonThiBO();
		List<MonThiBean> listMonThi = mtBO.getListMonThi(maKyThi);
		frm.setListMonThi(listMonThi);
		//get ma mon thi
		String maMonThi = listMonThi.size()==0?"":listMonThi.get(0).getMaMonThi();
		if(frm.getMaMonThi()!=null)
			maMonThi = frm.getMaMonThi();
		//list all phòng thi
		PhongThiBO ptBO = new PhongThiBO();
		List<PhongThiBean> listPhongThi = ptBO.getListPhongThiTheoMaKyThi(maKyThi);
			
		//dồn túi
		int coSoPhongThi = frm.getCoSoPhong();
		if("execute".equals(frm.getSubmit())){
			if(kyThi.getTrangThai()>5){
				return mapping.findForward("errorStatus");
			}
			System.out.println(maMonThi);
			//get input
			int tongSoPhong = listPhongThi.size();
			//check coSoPhong
			frm.setError(null);
			if(coSoPhongThi>tongSoPhong){
				frm.setError("Cơ số phòng phải nhỏ hơn tổng số phòng. Vui lòng nhập lại cơ số phòng!");
			}
			else{
			//tính tổng số lượt
			frm.setSoLuot((int)Math.ceil(1.0f*tongSoPhong/coSoPhongThi));
			//get input
			//int tongSoPhong = listPhongThi.size();
			System.out.println(tongSoPhong);
			System.out.println(coSoPhongThi);
			//tính tổng số lượt
			frm.setSoLuot((int)Math.ceil(1.0f*tongSoPhong/coSoPhongThi));
			//thuc hien
			int coSoTui = frm.getCoSoTui();
			int soLuot = frm.getSoLuot();
			System.out.println(coSoTui);
			System.out.println(soLuot);
			BaiThiBO btBO = new BaiThiBO();
			mtBO.updateDonTui(maMonThi, coSoPhongThi, coSoTui, soLuot);
			btBO.DonTuiPhach(maKyThi, maMonThi, coSoPhongThi, coSoTui, soLuot);
			ktBO.updateTrangThai(maKyThi, 5);
			mtBO.updateTrangThai(maMonThi, 2);
		}}
		return mapping.findForward("success");
	}
	
}
