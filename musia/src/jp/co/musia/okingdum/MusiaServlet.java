package jp.co.musia.okingdum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		if ("/signup".equals(request.getRequestURI()))		//　新規登録
		{
			
			request.getRequestDispatcher("/view/signup/index.jsp").forward(request, response);
		
		}
		else if ("/decision/options".equals(request.getRequestURI()))	// マイページ
		{

			request.getRequestDispatcher("/view/option/index.jsp").forward(request, response);
			
		}
		else if ("/details".equals(request.getRequestURI()))	// 商品詳細ページ
		{

			request.getRequestDispatcher("details.jsp").forward(request, response);
			
		}
		else if ("/decision/buypoint".equals(request.getRequestURI()))	// ポイント購入
		{

			request.getRequestDispatcher("buypoint.jsp").forward(request, response);
			
		}
		else if ("/decision/mylist".equals(request.getRequestURI()))	// マイリスト
		{
			
			request.getRequestDispatcher("mylist.jsp").forward(request, response);
			
		}
		else if ("/decision/listeditor".equals(request.getRequestURI()))	// リスト編集
		{
			
			request.getRequestDispatcher("listeditor.jsp").forward(request, response);
			
		}
		else if ("/decision/listdetails".equals(request.getRequestURI()))	// リスト詳細
		{
			
			request.getRequestDispatcher("listdetails.jsp").forward(request, response);
			
		}
		else if ("/decision/wants".equals(request.getRequestURI()))		// ほしいものリスト
		{
			
			request.getRequestDispatcher("wants.jsp").forward(request, response);
			
		}
		else if ("/apply".equals(request.getRequestURI()))		// 応募ページ
		{
			
			request.getRequestDispatcher("apply.jsp").forward(request, response);
			
		}
		else if ("/ranking".equals(request.getRequestURI()))		// ランキングページ
		{
			
			request.getRequestDispatcher("ranking.jsp").forward(request, response);
			
		}
		else if ("/decision/usereditor".equals(request.getRequestURI()))		// ユーザ情報変更ページ
		{
			
			request.getRequestDispatcher("usereditor.jsp").forward(request, response);
			
		}
		else if ("/decision/addcredit".equals(request.getRequestURI()))		// クレジット追加ページ
		{
			
			request.getRequestDispatcher("addcredit.jsp").forward(request, response);
			
		}
		else if ("/decision/salesign".equals(request.getRequestURI()))		// 販売登録ページ
		{
			
			request.getRequestDispatcher("salesign.jsp").forward(request, response);
			
		}
		else if ("/decision/signconfirm".equals(request.getRequestURI()))		// 登録確認ページ
		{
			
			request.getRequestDispatcher("signconfirm.jsp").forward(request, response);
			
		}
		else if ("/cart".equals(request.getRequestURI()))		// カートページ
		{
			
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			
		}
		else if ("/decision/buyselect".equals(request.getRequestURI()))		// お支払選択ページ
		{
			
			request.getRequestDispatcher("buyselect.jsp").forward(request, response);
			
		}
		else if ("/decision/changeorder".equals(request.getRequestURI()))		// 注文情報変更ページ
		{
			
			request.getRequestDispatcher("changeorder.jsp").forward(request, response);
			
		}
		else if ("/decision/download".equals(request.getRequestURI()))		// 購入確定ダウンロードページ
		{
			
			request.getRequestDispatcher("download.jsp").forward(request, response);
			
		}
		else if ("/contest".equals(request.getRequestURI()))		// コンテストページ
		{
			
			request.getRequestDispatcher("/view/contest/index.jsp").forward(request, response);
			
		}
		else if ("/inquiry".equals(request.getRequestURI()))		// お問い合わせページ
		{
			
			request.getRequestDispatcher("inquiry.jsp").forward(request, response);
			
		}
		else if ("/posterinfo".equals(request.getRequestURI()))		// 投稿者情報ページ
		{
			
			request.getRequestDispatcher("posterinfo.jsp").forward(request, response);
			
		}
		
		request.getRequestDispatcher("/view/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
