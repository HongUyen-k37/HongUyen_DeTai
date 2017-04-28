package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DiemActionForm;
import model.bean.DiemThiBean;
import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bean.NguoiDungBean;
import model.bo.BaiThiBO;
import model.bo.KyThiBO;
import model.bo.MonThiBO;

public class NhapDiemThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DiemActionForm frm = (DiemActionForm)form;
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
		//get list Môn
		MonThiBO mtBO = new MonThiBO();
		List<MonThiBean> listMonThi = mtBO.getListMonThi(maKyThi);
		frm.setListMonThi(listMonThi);
		//get Mã Môn thi
		String maMonThi = listMonThi.size()==0?"":listMonThi.get(0).getMaMonThi();
		if(frm.getMaMonThi()!=null)
			maMonThi = frm.getMaMonThi();
		System.out.println(maMonThi);
		//get list Túi
		BaiThiBO btBO = new BaiThiBO();
		List<Integer> listTui = btBO.getListTui(maKyThi);
		frm.setListTui(listTui);
		//get Túi
		int tuiSo = listTui.size()==0?0:listTui.get(0);
		if(frm.getTuiSo()!=0)
			tuiSo = frm.getTuiSo();
		System.out.println(tuiSo);
		//get Bài thi theo Môn và Túi
		frm.setListBaiThi(btBO.getListTheoTui(maKyThi, maMonThi, tuiSo));
		if("save".equals(frm.getSave())){
			if(kyThi.getTrangThai()>6){
				return mapping.findForward("errorStatus");
			}
			List<DiemThiBean> lst = frm.getListDiemThi();
			for (DiemThiBean diemThi : lst) {
				btBO.nhapDiem(maKyThi, maMonThi, diemThi.getSoPhach(), diemThi.getDiemChamThi());
			}
			frm.setNotice("Lưu điểm thi thành công");
			frm.setListBaiThi(btBO.getListTheoTui(maKyThi, maMonThi, tuiSo));
			return mapping.findForward("success");
		}
		if("xoaHet".equals(frm.getXoaHet())){
			btBO.deleteAllScore(maKyThi, maMonThi, tuiSo);
			frm.setNotice("Xóa hết thành công");
			frm.setListBaiThi(btBO.getListTheoTui(maKyThi, maMonThi, tuiSo));
			return mapping.findForward("success");
		}
		if("finish".equals(frm.getSave())){
			ktBO.updateTrangThai(maKyThi, 6);
			mtBO.updateTrangThai(maMonThi, 3);
			//frm.setNotice("Đã kết thúc nhập điểm");
			//return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}
	
}
