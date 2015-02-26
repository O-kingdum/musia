package jp.co.musia.okingdum.Utils;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.co.musia.okingdum.Bean.AdminBean;
import jp.co.musia.okingdum.dao.AdminDao;

/**
 * 
 * @author watanabe.yuta
 *
 */
public class AdminAuth {

	/**
	 * loginAuthメソッド: ログイン処理
	 * 
	 * @param request: 入力（メールアドレス,パスワード）
	 * @return boolean: true:ログイン	false:ログイン失敗
	 */
	public static boolean loginAuth(HttpServletRequest request) {
		
		HttpSession session;
		AdminBean admin = new AdminBean();
		AdminDao dao = new AdminDao();
		Validator val = new Validator();
		ArrayList<AdminBean> array;
		
		if( val.getLoginValidation(request) ) {	// バリデーションクリア
			
			admin.setAdmin_id( request.getParameter("email") );
			admin.setAdmin_password( request.getParameter("password") );
			
			array = dao.selectAdmin( admin );
			
			if( array != null && !array.isEmpty() ) { // ユーザが存在している
				
				setAuth( request, true );
				session = request.getSession();
				session.setAttribute("user", ((AdminBean)array.get(0)) );
				
				// ログイン成功
				return true;
			}
		}
		// ログイン失敗
		return false;
	}
	
	/**
	 * setAuthメソッド: ログイン状態セット
	 * 
	 * @param accept: true:ログイン false:未ログイン
	 */
	private static void setAuth(HttpServletRequest request, boolean accept) {
		
		HttpSession session;
		// セッション取得
		session = request.getSession();
		
		// ログイン許可
		if(accept) {
			// ログイン状態保持
			session.setAttribute("logincheck", true);
		}
		return;
	}
	
	/**
	 * checkAuthメソッド: ログイン状態取得
	 * 
	 * @return login
	 */
	public static boolean checkAuth(HttpServletRequest request) {
		
		HttpSession session;
		// セッション取得
		session = request.getSession();
		boolean login = (Boolean)session.getAttribute("logincheck");
		
		return login;
	}
	
	/**
	 * logoutAuthメソッド: ログアウト処理
	 * 
	 * @return void
	 */
	public static void logoutAuth(HttpServletRequest request) {
		
		HttpSession session;
		session = request.getSession();
		session.invalidate();
		
		return;
	}
}
