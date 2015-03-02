package jp.co.musia.okingdum;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.musia.okingdum.Bean.ProductsBean;
import jp.co.musia.okingdum.Bean.UsersBean;
import jp.co.musia.okingdum.Utils.AdminAuth;
import jp.co.musia.okingdum.Utils.FileFactory;
import jp.co.musia.okingdum.Utils.Validator;
import jp.co.musia.okingdum.dao.ProductsDao;
import jp.co.musia.okingdum.dao.UserDao;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// loginページ
		String dispPage = "/view/admin/index.jsp";
		String requestUri = request.getRequestURI(); 
		
		switch( requestUri ) {
		
		// topページ
		case "/musia/admin/top":
			dispPage = "/view/admin/top/index.jsp";
			break;
		// ユーザ管理
		case "/musia/admin/user":
			dispPage = "/view/admin/user/index.jsp";
			UserDao userdao = new UserDao();
			ArrayList<UsersBean> users = userdao.selectAllUser();
			request.setAttribute("users", users);
			break;
		// ユーザ詳細
		case "/musia/admin/user/detail":
			dispPage = "/view/admin/user/detail/index.jsp";
			break;
		// 商品管理
		case "/musia/admin/song":
			dispPage = "/view/admin/song/index.jsp";
			break;
		// 商品詳細
		case "/musia/admin/song/review":
			dispPage = "/view/admin/song/review/index.jsp";
			break;
		// 商品登録
		case "/musia/admin/song/post":
			dispPage = "/view/admin/song/post/index.jsp";
			break;
		// コンテスト管理
		case "/musia/admin/contest":
			dispPage = "/view/admin/contest/index.jsp";
			break;
		// コンテスト詳細
		case "/musia/admin/contest/review":
			dispPage = "/view/admin/contest/review/index.jsp";
			break;
		// ログアウト
		case "/musia/admin/logout":
			response.sendRedirect( request.getContextPath() + "/login_admin" );
			return;
		}
		request.getRequestDispatcher(dispPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Validator val = new Validator();
		ServletContext context = getServletContext();
		String path = "";
		String dispPage = "/view/admin/index.jsp";
		String requestUri = request.getRequestURI();
		
		switch( requestUri ) {
		
		// ログイン処理
		case "/musia/login_admin":
			if( AdminAuth.loginAuth(request) ) {
				
				response.sendRedirect( request.getContextPath() + "/admin/top" );
				return;
			} else {
				dispPage = "/view/admin/index.jsp";
				request.setAttribute( "msg", AdminAuth.getErrMsg() );
			}
			break;
		// 商品投稿
		case "/musia/admin/song/post":
			if( val.getPostMusicValidation(request) ) {
				
				ProductsDao productsdao = new ProductsDao();
				FileFactory factory = new FileFactory();
				path = context.getRealPath("/WEB-INF/music_file/H");
				
				if( factory.saveFileFacotry(request, path) ) {
					
					ProductsBean products = factory.getProducts();
					
					products.setUser_id( "H00001" );
					products.setProduct_admin_id( "AD00001" );
					
					productsdao.insertProducts( products );
				}
				/*
				productsdao.insertProducts(
						new ProductsBean(
								"H",
								"H00001",
								request.getParameter("products_name"),
								request.getParameter("artist_name"),
								Integer.parseInt( request.getParameter("price") ),
								request.getParameter("product_details"),
								request.getParameter("genre_id"),
								request.getParameter("measure"),
								request.getParameter("file_type"),
								
								AdminAuth.getAuthAdmin(request).getAdmin_id(),
								
								));
				*/
			} else {
				dispPage = "/view/admin/song/post/index.jsp";
				request.setAttribute("msg", val.getErrMsg() );
			}
			break;
		}
		request.getRequestDispatcher( dispPage ).forward(request, response);
	}

}
