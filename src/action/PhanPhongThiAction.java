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
import model.bean.ThiSinhBean;
import model.bo.KyThiBO;
import model.bo.MonThiBO;
import model.bo.PhongThiBO;
import model.bo.ThiSinhBO;

public class PhanPhongThiAction extends Action{
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
		PhongThiBO ptBO = new PhongThiBO();
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null)
			maKyThi = frm.getMaKyThi();
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//get list mon thi cua ky thi
		MonThiBO mtBO = new MonThiBO();
		frm.setListMonThi(mtBO.getListMonThi(maKyThi));
		//get list phong thi theo ky thi
		frm.setListPhongThi(ptBO.getListPhongThiTheoMaKyThi(maKyThi));
		//get list thi sinh theo ky thi
		ThiSinhBO tsBO = new ThiSinhBO();
		List<ThiSinhBean> listThiSinh = tsBO.getListThiSinh(maKyThi);
		//so luong thi sinh
		frm.setSoLuongThiSinh(listThiSinh.size());
		if ("bienChe".equals(frm.getBienChe())) {
			if(frm.getTongSoCho()!=frm.getSoLuongThiSinh()){	//truong hop khac so luong
				frm.setError("Cần điều chỉnh tổng số lượng chỗ bằng tổng số lượng thí sinh dự thi!"); 
				return mapping.findForward("success");
			}
			else{
				tsBO.phanPhongThi(maKyThi);
				ktBO.updateTrangThai(maKyThi, 2);
				frm.setNotice("Biên chế thành công");
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("success");
	}
}
