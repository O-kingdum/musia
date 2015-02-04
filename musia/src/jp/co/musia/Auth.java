package jp.co.musia;

import javax.servlet.http.HttpServletRequest;

import jp.co.musia.dao.UserDao;
import jp.co.musia.okingdum.UsersBean;

public class Auth {

	private static boolean login = false;
	private static UsersBean user;
	private static UserDao dao;
	
	private static void setAuth(boolean accept) {
		login = accept;
	}
	
	public static boolean checkAuth() {
		return login;
	}
	
	private static boolean loginAuth(HttpServletRequest request) {
		
		int ret = 0;
		
		user = new UsersBean();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		dao = new UserDao();
		ret = dao.selectUser(user);
		
		
		
		return true;
	}
}
