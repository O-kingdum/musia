package jp.co.musia.okingdum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.co.musia.okingdum.Utils.*;
import jp.co.musia.okingdum.dao.*;
import jp.co.musia.okingdum.Bean.*;

/**
 * Servlet implementation class MusiaServlet
 */
@WebServlet("/MusiaServlet")
public class MusiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusiaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dispPage = "/view/index.jsp";
		
		if ("/listener_signup".equals(request.getRequestURI()))// ユーザ登録
		{
			dispPage = "/view/signup_listener/index.jsp";
		}
		else if ("/option/".equals(request.getRequestURI()))	// マイページ
		{
			dispPage = "/view/option/index.jsp";	
		}
		else if ("/option/history".equals(request.getRequestURI()))	// 購入履歴
		{
			dispPage = "/view/option/history/index.jsp";
		}
		else if ("/option/listener".equals(request.getRequestURI()))	// リスナー情報
		{
			dispPage = "/view/option/listener/index.jsp";
		}
		else if ("/option/artist".equals(request.getRequestURI()))	// アーティスト情報
		{
			dispPage = "/view/option/artist/index.jsp";	
		}
		else if ("/option/credit".equals(request.getRequestURI()))	// クレジットカード情報
		{
			dispPage = "/view/option/credit/index.jsp";			
		}
		else if ("/option/point".equals(request.getRequestURI()))	// ポイント購入
		{
			dispPage = "/view/option/point/index.jsp";			
		}
		else if ("/login_user".equals(request.getRequestURI()))	// ユーザログイン
		{
			dispPage = "/view/login_user/index.jsp";
		}
		else if ("/option/list".equals(request.getRequestURI()))		// ほしいものリスト
		{
			dispPage = "/view/option/list/index.jsp";
		}
		else if ("/cart".equals(request.getRequestURI()))		// カート
		{
			dispPage = "/view/cart/index.jsp";
		}
		else if ("/cart/select".equals(request.getRequestURI()))		// お支払選択
		{
			dispPage = "/view/cart/select/index.jsp";
		}
		else if ("/cart/download".equals(request.getRequestURI()))		// ダウンロード
		{
			dispPage = "/view/cart/download/index.jsp";	
		}
		else if ("/artist_signup".equals(request.getRequestURI()))		// アーティスト登録
		{
			dispPage = "/view/artist_signup/index.jsp";
		}
		else if ("/release".equals(request.getRequestURI()))		// リリース
		{
			dispPage = "/view/release/index.jsp";
		}
		else if ("/release/song".equals(request.getRequestURI()))		// リリース登録
		{
			dispPage = "/view/release/song/index.jsp";	
		}
		else if ("/contest".equals(request.getRequestURI()))		// コンテスト
		{
			dispPage = "/view/contest/index.jsp";
		}
		else if ("/contest/song".equals(request.getRequestURI()))		// コンテスト登録
		{
			dispPage = "/view/contest/song/index.jsp";
		}
		else if ("/help".equals(request.getRequestURI()))		// 注文情報変更ページ
		{
			dispPage = "/view/help/index.jsp";
		}
				
		request.getRequestDispatcher(dispPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dispPage = "";
		String url = request.getRequestURI();
		Validator validator = new Validator();
		
		
		switch(url){
		
		case "/musia/login_user":					//ユーザログイン
			
			if(validator.getLoginValidation(request)){
				Auth.loginAuth(request);
				dispPage = "/view/signup_listener/index.jsp";
			}
			else{
				response.sendRedirect(request.getContextPath());
				return;
			}
			
			
			break;
			
		case "/musia/option/credit":				//クレジット追加(クレジットカード情報)
			
			if(validator.getCreditAddValidation(request)){
				CreditCardDao credao = new CreditCardDao();
				credao.insertCreditCard(
						new CreditCardBean(
								request.getParameter("credit_id"),
								Integer.parseInt(request.getParameter("card_number")),
								request.getParameter("limit_date"),
								request.getParameter("card_company"),
								Integer.parseInt("sec_cord"),
								request.getParameter("card_persons")
								)
						);
				
				dispPage = "/view/option/credit/index.jsp";
			}
			else{
				response.sendRedirect(request.getContextPath());
				return;
			}
			
			break;
			
		case "/musia/listener_signup":				//ユーザ登録
			
			if(validator.getCreateUserValidation(request)){
				UserDao udao = new UserDao();
				UsersBean user = new UsersBean();
				
				user.setEmail( request.getParameter("email") );
				user.setUser_name( request.getParameter("name") );
				user.setPassword( request.getParameter("password") );
				user.setSex( Integer.parseInt( 
						request.getParameter("sex") ) );
				user.setBirthday( request.getParameter("birthday") );
				
				udao.insertUser( user);
				
			}
			else{
				response.sendRedirect(request.getContextPath());
				return;
			}
			
			
			break;
			
		case "/musia/artist_signup":				//アーティスト登録(銀行口座登録)
			
			if(validator.getBankAddValidation(request)){
				UserDao udao = new UserDao();
				UsersBean user = new UsersBean();
				user.setBank_number(Integer.parseInt( 
						request.getParameter("bank_number")));
				user.setBank_persons("bank_persons");
				user.setBranch_code(Integer.parseInt( 
						request.getParameter("bank_code")));
				user.setBank_name("bank_name");
				
				udao.insertUser(user);		
				
			}
			else{
				response.sendRedirect(request.getContextPath());
				return;
			}
			
			break;
			
			
		case "/musia/contest/song":					//コンテスト登録
			
			
			break;
			
			
			
		case "/musia/release/song":					//リリース登録(商品登録)
			if(validator.getPostMusicValidation(request)){
				
			}
			else{
				response.sendRedirect(request.getContextPath());
				return;
			}
			
		case "/musia/option/":						//マイページ
			
			break;
			
		case "/musia/option/history":				//購入履歴
			
			break;
			
		case "/musia/option/artist":				//アーティスト情報
			
			break;	
			
		case "/musia/option/point":					//ポイント購入
			
			break;
			
		case "/musia/option/list":					//欲しいものリスト
			
			break;
			
		case "/musia/cart":							//カート
			
			break;
			
		case "/musia/cart/select":					//お支払選択
			
			break;
			
		case "/musia/cart/download":				//ダウンロード
			
			break;
			
		case "/musia/release":						//リリース
			
			break;
			
		case "/musia/contest":						//コンテスト
			
			break;
			
		case "/musia/help":							//注文情報変更ページ
			
			break;
		}
	}
}
