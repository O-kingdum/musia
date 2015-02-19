package jp.co.musia.okingdum;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.musia.okingdum.Utils.Validator;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//URL取得
		StringBuffer geturl = request.getRequestURL();
		//String変換
		String url = geturl.toString();		
		
		
		switch("url"){
		
		case "signup":			//新規登録
			
			//インスタンス化
			Validator validator = new Validator();
			//エラー判定
			boolean val = validator.getLoginValidation(request);
			
			if(val){
				
			}
			else{
				
			}
			
			break;
			
		case "options":			//マイページ
			
			break;
			
		case "details":			//商品詳細ページ
			
			break;
			
		case "buypoint":		//ポイント購入
			
			break;
			
		case "mylist":			//マイリスト
			
			break;
			
		case "listeditor":		//リスト編集
			
			break;
			
		case "listdetails":		//リスト詳細
			
			break;
			
		case "wants":			//欲しいものリスト
			
			break;
			
		case "apply":			//応募ページ
			
			break;
			
		case "ranking":			//ランキングページ
			
			break;
			
		case "usereditor":		//ユーザ情報変更ページ
			
			break;
			
		case "addcredit":		//クレジット追加ページ
			
			break;
			
		case "salesign":		//販売登録ページ
			
			break;
			
		case "signconfirm":		//登録確認ページ
			
			break;
			
		case "cart":			//カートページ
			
			break;
			
		case "buyselect":		//お支払選択
			
			break;
			
		case "changeorder":		//注文情報変更ページ
			
			break;
			
		case "download":		//購入確定ダウンロードページ
			
			break;
			
		case "contest":			//コンテストページ
			
			break;
			
		case "inquiry":			//お問い合わせページ
			
			break;
			
		case "posterinfo":		//投稿者情報ページ
			
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
