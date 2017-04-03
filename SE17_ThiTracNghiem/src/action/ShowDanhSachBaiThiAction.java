package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.PhanTrang;
import form.BaiThiActionForm;
import model.bean.BaiThiBean;
import model.bean.LoaiBaiThiBean;
import model.bo.BaiThiBO;

public class ShowDanhSachBaiThiAction  extends Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BaiThiBO baiThiBO = new BaiThiBO();
		BaiThiActionForm frm = (BaiThiActionForm) form;
		List<BaiThiBean> lst = baiThiBO.getListBaiThi(); 
		List<BaiThiBean> listQuanTrong = new ArrayList<BaiThiBean>();
		List<BaiThiBean> listNoiBat = new ArrayList<BaiThiBean>();
		List<LoaiBaiThiBean> listLoai = baiThiBO.getListLoaiBT();
		frm.setListLoai(listLoai);
		String idLoai=frm.getIdLoai();
		if(idLoai!=null && !idLoai.equals("")) lst=baiThiBO.getListTheoDanhMuc(idLoai);
		for(BaiThiBean bt:lst){
			bt.setSoLuotLam(baiThiBO.getLuotLam(bt.getIdBaiThi()));
			if(bt.getPassword()!=null && !bt.getPassword().equals("")){
				listQuanTrong.add(bt);
				if(listQuanTrong.size()>=3) break;
			} 
		}
		for(BaiThiBean bt:lst){
			if(bt.getSoLuotLam()>0){
				listNoiBat.add(bt);	
				if(listNoiBat.size()>=3) break;
			} 
		}
		
		String search = frm.getSearch();
		if (search == null) {
			frm.setListQuanTrong(listQuanTrong);
			frm.setListNoiBat(listNoiBat);
		} else  {
			search = new String(search.getBytes("ISO-8859-1"), "UTF-8");
			lst=baiThiBO.searchBaiThiALL(search);
		}
		
		PhanTrang phanTrang=new PhanTrang(9,frm.getPage(),lst);
		frm.setLst((List<BaiThiBean>) phanTrang.getLst());
		frm.setTotal(phanTrang.getTotal());
		
		return mapping.findForward("BaiThi");
	}
	
}
