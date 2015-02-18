package jp.co.musia.okingdum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.co.musia.okingdum.Bean.UsersBean;
import jp.co.musia.okingdum.dao.UserDao;

public class Auth {

	private UsersBean user;
	private UserDao dao;
	private HttpSession session;
	
	/**
	 * setAuthメソッド: ログイン状態セット
	 * 
	 * @param accept: true:ログイン false:未ログイン
	 */
	private void setAuth(HttpServletRequest request, boolean accept) {
		
		HttpSession session = request.getSession();
		
		if(accept) {
			session.setAttribute("logincheck", true);
		}
		return;
	}
	
	/**
	 * checkAuthメソッド: ログイン状態取得
	 * 
	 * @return login
	 */
	public boolean checkAuth(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		boolean login = (Boolean)session.getAttribute("logincheck");
		return login;
	}
	
	/**
	 * loginAuthメソッド: ログイン処理
	 * 
	 * @param request: 入力（メールアドレス,パスワード）
	 * @return boolean: true:ログイン	false:ログイン失敗
	 */
	private boolean loginAuth(HttpServletRequest request) {
		
		user = new UsersBean();
		dao = new UserDao();
		
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		user = dao.selectUser(user);
		
		if(user != null)
		{
			this.setAuth( request, true );
			
			session = request.getSession();
			session.setAttribute("user", user);
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * logoutAuthメソッド: ログアウト処理
	 * 
	 * @return void
	 */
	public void logoutAuth(HttpServletRequest request) {
		session.invalidate();
		return;
	}
}
