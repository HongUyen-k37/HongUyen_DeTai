package model.bo;

import java.util.List;

import model.bean.UserBean;
import model.dao.UserDAO;

public class UserBO {
	
	private UserDAO dao=new UserDAO();
	
	public UserBean getUser(String idUser){
		return dao.getUser(idUser);
	}
	public boolean checkLogin(String userName, String password) {
		return dao.checkLogin(userName, password);
	}
	public boolean updateUser(UserBean user) {
		return dao.updateUser(user);
	}
	public boolean resetPassword(String iDUser) {
		return dao.resetPassword(iDUser);
	}
	public List<UserBean> searchUser(String string){
		return dao.searchUser(string);
	}
	public List<UserBean> getListUser() {
		return dao.getListUser();
	}
	public void changeActive(String idUser) {
		dao.changeActive(idUser);
	}
	public UserBean getUserByUsername(String username){
		return dao.getUserByUsername(username);
	}
}
