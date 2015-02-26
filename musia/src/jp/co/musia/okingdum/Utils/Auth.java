package jp.co.musia.okingdum.Utils;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.co.musia.okingdum.Bean.UsersBean;
import jp.co.musia.okingdum.dao.UserDao;

/**
 * 
 * @author watanabe.yuta
 *
 */
public class Auth {

	private static HttpSession session;
	private static ArrayList<String> errmsg;
	
	/**
	 * setAuthメソッド: ログイン状態セット
	 * 
	 * @param accept: true:ログイン false:未ログイン
	 */
	private static void setAuth(HttpServletRequest request, boolean accept) {
		
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
		
		// セッション取得
		session = request.getSession();
		boolean login = (Boolean)session.getAttribute("logincheck");
		
		return login;
	}
	
	/**
	 * loginAuthメソッド: ログイン処理
	 * 
	 * @param request: 入力（メールアドレス,パスワード）
	 * @return boolean: true:ログイン	false:ログイン失敗
	 */
	public static boolean loginAuth(HttpServletRequest request) {
		
		UsersBean user = new UsersBean();
		UserDao dao = new UserDao();
		Validator val = new Validator();
		ArrayList<Object> array;
		
		if( val.getLoginValidation(request) ) {	// バリデーションクリア
			
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			
			array = dao.selectUser(new ArrayList<Object>(Arrays.asList(user)));
			
			if( array != null && !array.isEmpty() ) { // ユーザが存在している
				
				setAuth( request, true );
				session = request.getSession();
				session.setAttribute("user", ((UsersBean)array.get(0)) );
				
				// ログイン成功
				return true;
			} else {
				setErrMsg(val.getErrMsg());
			}
		}
		// ログイン失敗
		return false;
	}
	
	/**
	 * logoutAuthメソッド: ログアウト処理
	 * 
	 * @return void
	 */
	public static void logoutAuth(HttpServletRequest request) {
		
		session = request.getSession();
		session.invalidate();
		
		return;
	}
	/**
	 * setErrMsgメソッド
	 * @param array ArrayList<String>
	 */
	private static void setErrMsg(ArrayList<String> array) {
		errmsg = array;
	}
	/**
	 * getErrMsgメソッド
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> getErrMsg() {
		return errmsg;
	}
}
