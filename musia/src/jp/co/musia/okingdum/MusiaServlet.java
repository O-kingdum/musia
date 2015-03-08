package jp.co.musia.okingdum;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

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
		ProductsDao prodao = new ProductsDao();
		UsersBean user;
		
		if ("/musia/listener_signup".equals(request.getRequestURI()))// ユーザ登録
		{
			dispPage = "/view/listener_signup/index.jsp";
		}
		else if ("/musia/option".equals(request.getRequestURI()))	// マイページ
		{
			dispPage = "/view/option/index.jsp";	
		}
		else if ("/musia/option/history".equals(request.getRequestURI()))	// 購入履歴
		{
			dispPage = "/view/option/history/index.jsp";
			SalesDao saldao = new SalesDao();
			user = Auth.getAuthUser(request);
			ArrayList<ProductsBean> history = saldao.selectSales(user);
			request.setAttribute("history",history);
		}
		else if ("/musia/option/listener".equals(request.getRequestURI()))	// リスナー情報
		{
			dispPage = "/view/option/listener/index.jsp";
		}
		else if ("/musia/option/artist".equals(request.getRequestURI()))	// アーティスト情報
		{
			dispPage = "/view/option/artist/index.jsp";	
		}
		else if ("/musia/option/credit".equals(request.getRequestURI()))	// クレジットカード情報
		{
			dispPage = "/view/option/credit/index.jsp";
			// get UsersBean
			user = Auth.getAuthUser(request);
			// get CreditCardBean
			V_CreditCardBean creditcard = new V_CreditCardBean();
			// set CreditCardBean
			request.setAttribute("creditcard", creditcard);
		}
		else if ("/musia/option/point".equals(request.getRequestURI()))	// ポイント購入
		{
			dispPage = "/view/option/point/index.jsp";		
		}
		else if ("/musia/user_login".equals(request.getRequestURI()))	// ユーザログイン
		{
			dispPage = "/view/user_login/index.jsp";
		}
		else if ("/musia/option/list".equals(request.getRequestURI()))		// ほしいものリスト
		{
			dispPage = "/view/option/list/index.jsp";
			// instance
			prodao = new ProductsDao();
			// set Wants List
			request.setAttribute("wants", prodao.selectV_Wants(Auth.getAuthUser(request)));
		}
		else if ("/musia/option/cart".equals(request.getRequestURI()))		// カート
		{
			dispPage = "/view/option/cart/index.jsp";
			// set CartList
			request.setAttribute("products", CartManager.getCartList(request));
			// set TotalAmount
			request.setAttribute("total", CartManager.getTotalAmount(request));
		}
		else if ("/musia/option/cart/select".equals(request.getRequestURI()))		// お支払選択
		{
			dispPage = "/view/option/cart/select/index.jsp";
		}
		else if ("/musia/option/cart/download".equals(request.getRequestURI()))		// ダウンロード
		{
			dispPage = "/view/option/cart/download/index.jsp";	
		}
		else if ("/musia/artist_signup".equals(request.getRequestURI()))		// アーティスト登録
		{
			dispPage = "/view/artist_signup/index.jsp";
		}
		else if ("/musia/release".equals(request.getRequestURI()))		// リリース
		{
			dispPage = "/view/release/index.jsp";
		}
		else if ("/musia/release/song".equals(request.getRequestURI()))		// リリース登録
		{
			dispPage = "/view/release/song/index.jsp";
			// instance
			GenreDao genredao = new GenreDao();
			// get ArrayList<GenreBean>
			ArrayList<GenreBean> genres = genredao.selectGenre(new ArrayList<GenreBean>());
			// set Genre List
			request.setAttribute("genres", genres);
		}
		else if ("/musia/contest".equals(request.getRequestURI()))		// コンテスト
		{
			dispPage = "/view/contest/index.jsp";
		}
		else if ("/musia/contest/song".equals(request.getRequestURI()))		// コンテスト登録
		{
			dispPage = "/view/contest/song/index.jsp";
		}
		else if ("/musia/help".equals(request.getRequestURI()))		// 注文情報変更ページ
		{
			dispPage = "/view/help/index.jsp";
		}
		else if ("/musia/song".equals(request.getRequestURI()))		// 商品詳細
		{
			dispPage = "/view/song/index.jsp";
			ProductsBean product = new ProductsBean();
			String id = request.getParameter("id");
			
			if(StringUtils.isNotEmpty(id)) {
				product.setProduct_id(id);
				ArrayList<ProductsBean> products = prodao.selectProducts( new ArrayList<ProductsBean>( Arrays.asList(product) ) );
				if(products != null && products.size() > 0) {
					product = products.get(0);
				}
			}
			request.setAttribute("products", product);
		} else if ("/musia/logout".equals(request.getRequestURI())) {
			
			Auth.logoutAuth(request);
			response.sendRedirect(request.getContextPath());
			return;
			
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
		String path = "";
		ProductsDao prodao;
		
		switch(url){
		
		case "/musia/user_login":					//ユーザログイン
			
			if(Auth.loginAuth(request)) {
				response.sendRedirect(request.getContextPath());
				return;
			} else {
				request.setAttribute("msg", Auth.getErrMsg());
				dispPage = "/view/user_login/index.jsp";
			}
			break;
			
		case "/musia/option/credit":				//クレジット追加(クレジットカード情報)
			
			dispPage = "/view/option/credit/index.jsp";
			
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
			} else {
				request.setAttribute("msg", validator.getErrMsg());
			}
			break;
			
		case "/musia/listener_signup":				//ユーザ登録(新規登録)
			
			dispPage = "/view/listener_signup/index.jsp";
			
			if(validator.getCreateUserValidation(request)){
				UserDao udao = new UserDao();
				UsersBean user = new UsersBean();
				
				user.setEmail( request.getParameter("email") );
				user.setUser_name( request.getParameter("user_name") );
				user.setPassword( request.getParameter("password") );
				user.setSex( Integer.parseInt( 
						request.getParameter("sex") ) );
				user.setBirthday( request.getParameter("year") 
						+ "-" + request.getParameter("day") 
						+ "-" + request.getParameter("month") );
				
				udao.insertUser(user);
				
				if(udao.getErrflag()){
					request.setAttribute("msg", udao.getMsg());
				}
				
			} else {
				request.setAttribute("msg", validator.getErrMsg());
			}
			
			break;
			
		case "/musia/artist_signup":				//アーティスト登録(銀行口座登録)
			
			dispPage = "/view/artist_signup/index.jsp";
			
			if(validator.getBankAddValidation(request)){
				UserDao udao = new UserDao();
				UsersBean ubean = Auth.getAuthUser(request);
				ubean.setBank_number(Integer.parseInt( 
						request.getParameter("bank_number")));
				ubean.setBank_persons(
						request.getParameter("bank_persons"));
				ubean.setBranch_code(Integer.parseInt( 
						request.getParameter("branch_code")));
				ubean.setBank_name(
						request.getParameter("bank_name"));
				
				udao.updateUser(ubean);		
				
			}
			else{
				//response.sendRedirect(request.getContextPath());
				return;
			}
			
			break;
			
		case "/musia/contest/song":					//コンテスト登録
			Contest_MusicDao condao = new Contest_MusicDao();
			condao.insertContest_Music(
					new Contest_MusicBean(
							request.getParameter("contest_id"),
							request.getParameter("product_id"),
							request.getParameter("contest_admin_id"),
							Integer.parseInt(request.getParameter("contest_examination")),
							request.getParameter("record_date")));
			
			break;
			
			
		case "/musia/release/song":					//リリース登録(商品登録)
			
			dispPage = "/view/release/song/index.jsp";
			UsersBean ubean = new UsersBean();
			prodao = new ProductsDao();
			FileFactory factory = new FileFactory();
			ServletContext context = getServletContext();
			path = context.getRealPath("/");
			
			if( factory.saveFileFacotry(request, path) ) {
				ubean = Auth.getAuthUser(request);
				ProductsBean products = factory.getProducts();
				// ユーザＩＤ
				products.setUser_id(ubean.getUser_id());
				products.setArtist_name(ubean.getUser_name());
				// 日付
				DateTime dt = new DateTime();
				dt.toString(DateTimeFormat.mediumDateTime());
				products.setPosted_date(dt.toString(DateTimeFormat.mediumDateTime()));
				// 管理者ＩＤ
				products.setProduct_admin_id( "ADM0001" );
				// 審査状況
				products.setExamination(0);
				
				prodao.insertProducts( products, "T" );
				if(!prodao.getErrflag()){
					request.setAttribute("msg", prodao.getMsg() );
				}
					
			}
			else{
				request.setAttribute("msg", factory.getMsg() );
			}
		
			break;
			
		case "/musia/option/":						//マイページ
			
			break;
			
		case "/musia/option/history":				//購入履歴
			
			break;
			
		case "/musia/option/artist":				//アーティスト情報
			
			break;	
			
		case "/musia/option/point":					//ポイント購入
			
			Oikawa_PointDao oipo = new Oikawa_PointDao();
			//ポイント数表示
			//ArrayList<CreditCardBean> array = oipo.selectOikawa_Point(array);
			
			//データ格納
			oipo.insertOikawa_Point(
					new Oikawa_PointBean(
						request.getParameter("user_id"),
						Integer.parseInt(request.getParameter("op")),
						request.getParameter("op_date"),
						Integer.parseInt(request.getParameter("op_flag"))
					));
			break;
			
		case "/musia/option/list":					//欲しいものリスト
			
			break;
			
		case "/musia/cart":							//カート
			//セッション取得
			HttpSession session = request.getSession();
			//オブジェクト取得
			String cart = (String) session.getAttribute("cart");
			//cartにセット
			session.setAttribute("cart", cart);
			break;
			
		case "/musia/option/cart/select":					//お支払選択
			
			SalesDao salesdao = new SalesDao();
			SalesBean salesbean = new SalesBean();
			DateTime dt = new DateTime();
			
			salesbean.setUser_id(Auth.getAuthUser(request).getUser_id());
			salesbean.setSale_date(dt.toString(DateTimeFormat.mediumDateTime()));
			salesbean.setTotal_amount(CartManager.getTotalAmount(request));
			
			if(salesdao.insertSales(salesbean, CartManager.getCartList(request))) {
				
				dispPage = "/view/option/cart/download/index.jsp";
				request.setAttribute("products", CartManager.getCartList(request));
				CartManager.clearCartList(request);
			
			} else {
				response.sendRedirect(request.getContextPath() + "/option/cart");
				return;
			}
			break;
			
		case "/musia/cart/download":				//ダウンロード
			
			break;
			
		case "/musia/release":						//リリース
			
			break;
			
		case "/musia/contest":						//コンテスト
			
			break;
			
		case "/musia/help":							//注文情報変更ページ
			
			break;
			
		case "/musia/cartadd":
			
			String id = request.getParameter("id");
			prodao = new ProductsDao();
			ArrayList<ProductsBean> productarr;
			
			if(StringUtils.isNotEmpty(id)) {
				if(request.getParameter("cart") != null) {
					
					ProductsBean product = new ProductsBean();
					product.setProduct_id(id);
					productarr = prodao.selectProducts(new ArrayList<ProductsBean>(Arrays.asList(product)));
					
					if(productarr != null && productarr.size() > 0) {
						CartManager.setCartList(request, productarr.get(0));
						response.sendRedirect(request.getContextPath() + "/option/cart");
						return;
					}
					
				} else if(request.getParameter("list") != null) {
					
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/song?id=" + id);
				return;
			}
			break;
			
		case "/musia/option/cartdel":
			
			String idx = request.getParameter("idx");
			if(StringUtils.isNotEmpty(idx)) {
				CartManager.delCartList(request, idx);
			}
			response.sendRedirect(request.getContextPath() + "/option/cart");
			return;			
		}
		request.getRequestDispatcher(dispPage).forward(request, response);
	}


}
