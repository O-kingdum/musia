package jp.co.musia.okingdum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		}
		request.getRequestDispatcher(dispPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String requestUri = request.getRequestURI();
		
		switch( requestUri ) {
		case "/login_admin":
			break;
		}
	}

}
