package jp.co.musia;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.co.musia.dao.UserDao;
import jp.co.musia.okingdum.UsersBean;

public class Auth {

	private static boolean login = false;
	private static UsersBean user;
	private static UserDao dao;
	private static HttpSession session;
	
	/**
	 * setAuthメソッド: ログイン状態セット
	 * 
	 * @param accept: true:ログイン	false:未ログイン
	 */
	private static void setAuth(boolean accept) {
		login = accept;
	}
	
	/**
	 * checkAuthメソッド: ログイン状態取得
	 * 
	 * @return login
	 */
	public static boolean checkAuth() {
		return login;
	}
	
	/**
	 * loginAuthメソッド: ログイン処理
	 * 
	 * @param request: 入力（メールアドレス,パスワード）
	 * @return boolean: true:ログイン	false:ログイン失敗
	 */
	private static boolean loginAuth(HttpServletRequest request) {
		
		user = new UsersBean();
		dao = new UserDao();
		
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		user = dao.selectUser(user);
		
		if(user != null)
		{
			setAuth(true);
			
			session = request.getSession(true);
			session.setAttribute("user", user);
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void logoutAuth() {
		setAuth(false);
		return;
	}
}
