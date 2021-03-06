package jp.co.musia.okingdum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.musia.okingdum.Bean.GenreBean;
import jp.co.musia.okingdum.Bean.ProductsBean;
import jp.co.musia.okingdum.Bean.UsersBean;
import jp.co.musia.okingdum.Utils.AdminAuth;
import jp.co.musia.okingdum.Utils.FileFactory;
import jp.co.musia.okingdum.Utils.Validator;
import jp.co.musia.okingdum.dao.GenreDao;
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
		// URI
		String requestUri = request.getRequestURI();
		// UserDao set
		UserDao userdao;
		// ProductsDao set
		ProductsDao productsdao;
		ArrayList<UsersBean> users;
		ArrayList<ProductsBean> products;
		
		switch( requestUri ) {
		
		// topページ
		case "/musia/admin/top":
			dispPage = "/view/admin/top/index.jsp";
			break;
			
		// ユーザ管理
		case "/musia/admin/user":
			// forwarding jsp page
			dispPage = "/view/admin/user/index.jsp";
			// instance
			userdao = new UserDao();
			// get UsersBean Array
			users = userdao.selectAllUser();
			// request set
			request.setAttribute("users", users);
			break;
			
		// ユーザ詳細
		case "/musia/admin/user/detail":
			dispPage = "/view/admin/user/detail/index.jsp";
			// UserDao set
			userdao = new UserDao();
			// Bean
			UsersBean user = new UsersBean();
			// get user_id
			String user_id = request.getParameter("id");
			// set user_id
			user.setUser_id(user_id);
			// select User
			users = userdao.selectUser(new ArrayList<UsersBean>( Arrays.asList(user) ));
			// request set
			request.setAttribute("users", users);
			break;
			
		// 商品管理
		case "/musia/admin/song":
			// forwarding jsp page
			dispPage = "/view/admin/song/index.jsp";
			// ProductsDao set
			productsdao = new ProductsDao();
			// get Products Bean Array
			products = productsdao.selectProducts(new ArrayList<ProductsBean>());
			// request set
			request.setAttribute("products", products);
			break;
			
		// 商品詳細
		case "/musia/admin/song/review":
			dispPage = "/view/admin/song/review/index.jsp";
			// ProductDao set
			productsdao = new ProductsDao();
			// ProductBean
			ProductsBean product = new ProductsBean();
			// get product_id
			String product_id = request.getParameter("id");
			// set product_id
			product.setProduct_id(product_id);
			// select Products
			products = productsdao.selectProducts(new ArrayList<ProductsBean>( Arrays.asList(product) ));
			// request set
			request.setAttribute("products", products);
			break;
			
		// 商品登録
		case "/musia/admin/song/post":
			dispPage = "/view/admin/song/post/index.jsp";
			GenreDao genredao = new GenreDao();
			ArrayList<GenreBean> genres = genredao.selectGenre(new ArrayList<GenreBean>());
			request.setAttribute("genres", genres);
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
			
			dispPage = "/view/admin/song/post/index.jsp";
			
			ProductsDao productsdao = new ProductsDao();
			FileFactory factory = new FileFactory();
			path = context.getRealPath("WEB-INF/music_file/");
				
			if( factory.saveFileFacotry(request, path) ) {
					
				ProductsBean products = factory.getProducts();
				// ユーザＩＤ	
				products.setUser_id( "H000001" );
				// 日付
				DateTime dt = new DateTime();
				dt.toString(DateTimeFormat.mediumDateTime());
				products.setPosted_date(dt.toString(DateTimeFormat.mediumDateTime()));
				// 管理者ＩＤ
				products.setProduct_admin_id( "ADM0001" );
				// 審査状況
				products.setExamination(0);
				
				productsdao.insertProducts( products, "H" );
			
			} else {
				request.setAttribute("msg", val.getErrMsg() );
			}
			break;
		}
		request.getRequestDispatcher( dispPage ).forward(request, response);
	}

}
