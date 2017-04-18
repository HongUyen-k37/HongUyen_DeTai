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
import model.bean.BaiThiBean;
import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bean.NguoiDungBean;
import model.bean.PhongThiBean;
import model.bean.ThiSinhBean;
import model.bean.TrangThai;
import model.bo.BaiThiBO;
import model.bo.KyThiBO;
import model.bo.MonThiBO;
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
		//get ma ky thi
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null)
			maKyThi = frm.getMaKyThi();
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//get list phòng để select
		PhongThiBO pt = new PhongThiBO();
		List<PhongThiBean> listPhongThi = pt.getListPhongThiTheoMaKyThi(maKyThi);
		frm.setListPhongThi(listPhongThi);
		//get list môn để select
		MonThiBO mt = new MonThiBO();
		List<MonThiBean> listMonThi = mt.getListMonThi(maKyThi);
		frm.setListMonThi(listMonThi);;
		//get ma phong thi
		String maPhongThi = listPhongThi.size()==0?"":listPhongThi.get(0).getMaPhongThi();
		if(frm.getMaPhongThi()!=null)
			maPhongThi = frm.getMaPhongThi();
		//get ma mon thi
		String maMonThi = listMonThi.size()==0?"":listMonThi.get(0).getMaMonThi();
		if(frm.getMaMonThi()!=null)
			maMonThi = frm.getMaMonThi();
		//get list thí sinh theo phòng thi hiển thị ra table
		ThiSinhBO ts = new ThiSinhBO();
		List<ThiSinhBean> listThiSinh = ts.getListThiSinhTheoPhongThi(maPhongThi);
		frm.setListThiSinh(listThiSinh);
		
		//Kiem tra trong database đã có dữ liệu xử lý bài thi chưa
		BaiThiBO bt=new BaiThiBO();
		List<BaiThiBean> lst=bt.getList(maKyThi, maPhongThi, maMonThi);
		//if(lst.size()==0){ bt.khoiTao(); lst=bt.getList(maKyThi);
		//frm.setListBaiThi(lst);
		if ("save".equals(frm.getSave())) {
			System.out.println(maKyThi);
			System.out.println(maPhongThi);
			//System.out.println(tt);
			System.out.println(maMonThi);
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
		
	}
	
}
