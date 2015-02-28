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
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub

    String dispPage = "/view/index.jsp";

    // リスナー登録
    if ("/listener_signup".equals(request.getRequestURI())) {
      dispPage = "/view/signup_listener/index.jsp";
    }
    // オプション
    else if ("/option".equals(request.getRequestURI())) {
      dispPage = "/view/option/index.jsp";
    }
    // オプション → 購入履歴
    else if ("/option/history".equals(request.getRequestURI())) {
      dispPage = "/view/option/history/index.jsp";
    }
    // オプション → リスナー情報
    else if ("/option/listener".equals(request.getRequestURI())) {
      dispPage = "/view/option/listener/index.jsp";
    }
    // オプション → アーティスト情報
    else if ("/option/artist".equals(request.getRequestURI())) {
      dispPage = "/view/option/artist/index.jsp";
    }
    // オプション → クレジットカード情報
    else if ("/option/credit".equals(request.getRequestURI())) {
      dispPage = "/view/option/credit/index.jsp";
    }
    // オプション → ポイント購入
    else if ("/option/point".equals(request.getRequestURI())) {
      dispPage = "/view/option/point/index.jsp";
    }
    // ユーザログイン
    else if ("/login_user".equals(request.getRequestURI())) {
      dispPage = "/view/login_user/index.jsp";
    }
    // 気になる
    else if ("/option/list".equals(request.getRequestURI())) {
      dispPage = "/view/option/list/index.jsp";
    }
    // カート
    else if ("/cart".equals(request.getRequestURI())) {
      dispPage = "/view/cart/index.jsp";
    }
    // 楽曲詳細
    else if ("/cart/song".equals(request.getRequestURI())) {
      dispPage = "/view/cart/song/index.jsp";
    }
    // お支払選択
    else if ("/cart/select".equals(request.getRequestURI())) {
      dispPage = "/view/cart/select/index.jsp";
    }
    // ダウンロード
    else if ("/cart/download".equals(request.getRequestURI())) {
      dispPage = "/view/cart/download/index.jsp";
    }
    // アーティスト登録
    else if ("/artist_signup".equals(request.getRequestURI())) {
      dispPage = "/view/artist_signup/index.jsp";
    }
    // リリース
    else if ("/release".equals(request.getRequestURI())) {
      dispPage = "/view/release/index.jsp";

    }
    // リリース登録
    else if ("/release/song".equals(request.getRequestURI())) {
      dispPage = "/view/release/song/index.jsp";
    }
    // コンテスト
    else if ("/contest".equals(request.getRequestURI())) {
      dispPage = "/view/contest/index.jsp";
    }
    // コンテスト登録
    else if ("/contest/song".equals(request.getRequestURI())) {
      dispPage = "/view/contest/song/index.jsp";
    }
    // ヘルプ
    else if ("/help".equals(request.getRequestURI())) {
      dispPage = "/view/help/index.jsp";
    }

    request.getRequestDispatcher(dispPage).forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub

    String dispPage = "";
    String url = request.getRequestURI();
    Validator validator = new Validator();

    switch (url) {

    case "/musia/login_user": // ユーザログイン

      if (validator.getLoginValidation(request)) {
        Auth.loginAuth(request);
        dispPage = "/view/signup_listener/index.jsp";
      } else {
        response.sendRedirect(request.getContextPath());
        return;
      }

      break;

    case "/musia/option/credit": // クレジット追加

      if (validator.getCreditAddValidation(request)) {
        CreditCardDao credao = new CreditCardDao();
        credao.insertCreditCard(new CreditCardBean(request.getParameter("credit_id"), Integer.parseInt(request.getParameter("card_number")), request.getParameter("limit_date"), request.getParameter("card_company"), Integer.parseInt("sec_cord"), request.getParameter("card_persons")));

        dispPage = "/view/option/credit/index.jsp";
      } else {
        response.sendRedirect(request.getContextPath());
        return;
      }

      break;

    case "/musia/listener_signup": // ユーザ登録

      if (validator.getCreateUserValidation(request)) {
        UserDao udao = new UserDao();
        UsersBean user = new UsersBean();

        user.setEmail(request.getParameter("email"));
        user.setUser_name(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setSex(Integer.parseInt(request.getParameter("sex")));
        user.setBirthday(request.getParameter("birthday"));

        udao.insertUser(user);

      } else {
        response.sendRedirect(request.getContextPath());
        return;
      }

      break;

    case "/musia/artist_signup": // アーティスト登録(銀行口座登録)

      if (validator.getBankAddValidation(request)) {
        UserDao udao = new UserDao();
        UsersBean user = new UsersBean();
        user.setBank_number(Integer.parseInt(request.getParameter("bank_number")));
        user.setBank_persons("bank_persons");
        user.setBranch_code(Integer.parseInt(request.getParameter("bank_code")));
        user.setBank_name("bank_name");

        udao.insertUser(user);

      } else {
        response.sendRedirect(request.getContextPath());
        return;
      }

      break;

    }
  }

}
