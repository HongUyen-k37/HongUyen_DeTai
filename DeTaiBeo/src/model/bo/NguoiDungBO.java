package model.bo;

import model.bean.NguoiDungBean;
import model.dao.NguoiDungDAO;

public class NguoiDungBO {
	NguoiDungDAO nd = new NguoiDungDAO();
	public boolean checkLogin(String userName, String password) {
		return nd.checkLogin(userName, password);
	}
	public NguoiDungBean getUserByUsername(String username) {
		return nd.getUserByUsername(username);
	}
}
