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
import model.bean.TrangThaiBean;
import model.bo.BaiThiBO;
import model.bo.KyThiBO;
import model.bo.MonThiBO;
import model.bo.PhongThiBO;
import model.bo.ThiSinhBO;

public class XuLyBaiThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BaiThiActionForm frm = (BaiThiActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
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
		//get mã môn thi
		String maMonThi = listMonThi.size()==0?"":listMonThi.get(0).getMaMonThi();
		if(frm.getMaMonThi()!=null)
			maMonThi = frm.getMaMonThi();
		//get list thí sinh theo phòng
		ThiSinhBO ts = new ThiSinhBO();
		List<ThiSinhBean> listThiSinh = ts.getListThiSinhTheoPhongThi(maPhongThi);
		//get list bai thi
		BaiThiBO btBO = new BaiThiBO();
		List<BaiThiBean> listBaiThi = btBO.getListXuLy(maKyThi, maMonThi, maPhongThi);
		frm.setListBaiThi(listBaiThi);
		frm.setListThiSinh(listThiSinh);
		if ("save".equals(frm.getSave())) {
			/*if(kyThi.getTrangThai()<2){
				return mapping.findForward("errorStatus");
			}
			System.out.println(maMonThi);*/
			//get mã thí sinh và trạng thái
			if(frm.getListTrangThai()!=null){
				System.out.println(frm.getListTrangThai().size());
				for (TrangThaiBean trangThai : frm.getListTrangThai()) {
					System.out.println(trangThai.getMaThiSinh()+" "+trangThai.getTrangThaiDuThi());
					//kiểm tra đã có bài thi hay chưa?
					List<BaiThiBean> listBaiThi1 = btBO.getList(maKyThi, maMonThi, trangThai.getMaThiSinh());
					if(listBaiThi1.size()==0){
						//không có => thêm mới
						BaiThiBean baiThi = new BaiThiBean(maKyThi, maMonThi, trangThai.getMaThiSinh(), 0, 0,
								trangThai.getTrangThaiDuThi(), 0, 0, null);
						btBO.insert(baiThi);
						listBaiThi = btBO.getListXuLy(maKyThi, maMonThi, maPhongThi);
						frm.setListBaiThi(listBaiThi);
					}
					else{
						//ngược lại => update
						btBO.update(maKyThi, maMonThi, trangThai.getMaThiSinh(), trangThai.getTrangThaiDuThi());
						listBaiThi = btBO.getListXuLy(maKyThi, maMonThi, maPhongThi);
						frm.setListBaiThi(listBaiThi);
					}	
				}			
			}
			else return mapping.findForward("error");
			ktBO.updateTrangThai(maKyThi, 4);
			MonThiBO mtBO = new MonThiBO();
			mtBO.updateTrangThai(maMonThi, 1);
			frm.setNotice("Lưu thành công");
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}
}