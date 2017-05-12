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

public class DanhSoBaoDanhAction extends Action{

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ThiSinhActionForm frm = (ThiSinhActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		ThiSinhBO tsBO = new ThiSinhBO();
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		frm.setListKyThi(listKyThi);
		//get makythi
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
		//get listmonthi cua kythi
		MonThiBO mtBO = new MonThiBO();
		frm.setListMonThi(mtBO.getListMonThi(maKyThi));
		//danh sbd
		if ("submit".equals(frm.getSubmit())){
			if(kyThi.getTrangThai()>1){
				return mapping.findForward("errorStatus");
			}
			int soLuongChuSo = frm.getSoLuong();
			String soLuongSV = frm.getSoLuongSV();
			System.out.println(soLuongSV);
			System.out.println(soLuongSV.length()-2);
			if(soLuongChuSo < soLuongSV.length()-2)
				frm.setError("Cần nhập số lượng chữ số hợp lệ!");
			else{
				tsBO.danhSoBaoDanh(frm.getTiepDauNgu(), frm.getSoBatDau(), soLuongChuSo, maKyThi);
				frm.setNotice("Đánh số báo danh thành công");
				ktBO.updateTrangThai(maKyThi, 1);
			}
		}
		//show list thi sinh
		PhanTrang phanTrang=new PhanTrang(10,frm.getPage(), tsBO.getListThiSinh(maKyThi));
		frm.setListThiSinh((List<ThiSinhBean>) phanTrang.getLst());
		frm.setTotal(phanTrang.getTotal());
		frm.setTong(tsBO.getListThiSinh(maKyThi).size());
		return mapping.findForward("success");
	}
	
}
