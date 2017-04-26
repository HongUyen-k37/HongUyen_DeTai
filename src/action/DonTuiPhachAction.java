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
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null)
			maKyThi = frm.getMaKyThi();
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//get list mon thi de select
		MonThiBO mtBO = new MonThiBO();
		List<MonThiBean> listMonThi = mtBO.getListMonThi(maKyThi);
		frm.setListMonThi(listMonThi);
		//get ma mon thi
		String maMonThi = listMonThi.size()==0?"":listMonThi.get(0).getMaMonThi();
		if(frm.getMaMonThi()!=null)
			maMonThi = frm.getMaMonThi();
		System.out.println(maMonThi);
		//list all bài thi theo môn
		BaiThiBO btBO = new BaiThiBO();
		//lan 1
		//current = 0;
		/*for(chay tu i+current => co so phong*luot){
			List<BaiThiBean> listBaiThi = btBO.getListTheoMon(maKyThi, maMonThi, );
			current+=cosophong*luot;
			
		}
		//lan 2
*/		
		//list all phòng thi
		PhongThiBO ptBO = new PhongThiBO();
		List<PhongThiBean> listPhongThi = ptBO.getListPhongThiTheoMaKyThi(maKyThi);
		//dồn túi
		int coSoTui = frm.getCoSoTui();
		if("cal".equals(frm.getCal())){
			//get input
			int tongSoPhong = listPhongThi.size();
			System.out.println(tongSoPhong);
			System.out.println(frm.getCoSoPhong());
			//tính tổng số lượt
			frm.setSoLuot((int)Math.ceil(1.0f*tongSoPhong/frm.getCoSoPhong()));
		}
		int listTui[] = new int[coSoTui*frm.getSoLuot()];
		for(int i = 0; i < coSoTui*frm.getSoLuot(); i++){
			listTui[i] = i+1;
			System.out.println(listTui[i]);
		}
		
		return mapping.findForward("success");
	}
	
}
