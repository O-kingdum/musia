package jp.co.musia.okingdum.Utils;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class Validator {

	// エラーメッセージリスト
	private ArrayList<String> errmsg;
	private boolean val;
	
	/**
	 * getErrMsgメソッド : エラーメッセージの取得
	 * 
	 * @return errmsg ArrayList<String>: エラーメッセージリスト
	 */
	public ArrayList<String> getErrMsg() {
		return this.errmsg;
	}
	/**
	 * getSearchMusicメソッド : 楽曲検索に対するバリデーション
	 * 
	 * @param request : 入力(検索ワード)
	 * @return val boolean: true:成功/ false:失敗
	 */
	public boolean getSearchMusicValidation(HttpServletRequest request) {
		
		this.errmsg = new ArrayList<String>();
		this.val = true;
		
		// 検索ワード取得
		String value = request.getParameter("search_word");
		
		if(StringUtils.isEmpty(value)) {
			errmsg.add("楽曲名を入力してください。");
			val = false;
		} else {
			if(value.length() > 20) {
				errmsg.add("楽曲名は20文字以内で入力してください。");
				val = false;
			}
		}
		return val;
	}
	/**
	 * getLoginvalidationメソッド : ログイン処理に対するバリデーション
	 * 
	 * @param request : 入力(メールアドレス,パスワード)
	 * @return val boolean :　true:成功/ false:失敗
	 */
	public boolean getLoginValidation(HttpServletRequest request) {
		this.errmsg = new ArrayList<String>();
		this.val = true;
		
		// メールアドレス取得
		String email = request.getParameter("email");
		// パスワード取得
		String password = request.getParameter("password");
		
		/* email validation */
		if(StringUtils.isEmpty(email)) {	//　空またはnull
			val = false;
			errmsg.add("メールアドレスを入力してください。");
		} else {
			if(!email.matches("[0-9a-zA-Z]+")) {
				val = false;
				errmsg.add("メールアドレスは半角英数字で入力してください。");
			}			
			if(email.length() > 50) {
				val = false;
				errmsg.add("メールアドレスは50文字以内で入力してください。");
			}
		}
		/* password validation */
		if(StringUtils.isEmpty(password)) {	// 空またはnull
			val = false;
			errmsg.add("パスワードを入力してください。");
		} else {
			if(!password.matches("[0-9a-zA-Z]+")) {
				val = false;
				errmsg.add("パスワードは半角英数字で入力してください。");
			}
			if(password.length() >= 6 && password.length() <= 8) {
				val = false;
				errmsg.add("パスワードは6文字~8文字で入力してください。");
			}
		}
		return val;
	}
	/**
	 * getCreateUserメソッド : 新規ユーザ登録バリデーション
	 * 
	 * @param request
	 * @return
	 */
	public boolean getCreateUserValidation(HttpServletRequest request) {
		this.errmsg = new ArrayList<String>();
		this.val = true;
		
		String email = request.getParameter("email");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		
		/* email validation */
		if(StringUtils.isEmpty(email)) {
			val = false;
			errmsg.add("メールアドレスを入力してください。");
		} else {
			if(!email.matches("[0-9a-zA-Z]+")) {
				val = false;
				errmsg.add("メールアドレスは半角英数字で入力してください。");
			}			
			if(email.length() > 50) {
				val = false;
				errmsg.add("メールアドレスは50文字以内で入力してください。");
			}
		}
		/* user_name validation */
		if(StringUtils.isEmpty(user_name)) {
			val = false;
			errmsg.add("ユーザ名を入力してください。");
		} else {
			if(user_name.length() > 20) {
				val = false;
				errmsg.add("ユーザ名は20文字以内で入力してください。");
			}
		}
		/* password validation */
		if(StringUtils.isEmpty(password)) {
			val = false;
			errmsg.add("パスワードを入力してください。");
		} else {
			if(!password.matches("[0-9a-zA-Z]+")) {
				val = false;
				errmsg.add("パスワードは半角英数字で入力してください。");
			}
			if(password.length() >= 6 && password.length() <= 8) {
				val = false;
				errmsg.add("パスワードは6文字~8文字で入力してください。");
			}
		}
		/* sex validation */
		if(StringUtils.isEmpty(sex)) {
			val = false;
			errmsg.add("性別を選択してください。");
		} else {
			if(!sex.matches("[0-1]{1}")) {
				val = false;
				errmsg.add("性別で選択された値が不正です。");
			}
		}
		/* birthday validation */
		if(StringUtils.isEmpty(birthday)) {
			val = false;
			errmsg.add("誕生日を入力してください。");			
		} else {
			if(!birthday.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
				val = false;
				errmsg.add("誕生日の形式が正しくありません。");
			}
		}
		return true;
	}
	/**
	 * getBankAddvalidationメソッド : 銀行口座　追加処理
	 * 
	 * @param request : 入力(口座番号,支店番号,口座名義人,銀行名)
	 * @return val boolean :　true:成功/ false:失敗
	 */
	public boolean getBankAddValidation(HttpServletRequest request) {
		this.errmsg = new ArrayList<String>();
		this.val = true;
		
		// 口座番号取得
		String bank_number = request.getParameter("bank_number");
		// 支店番号取得
		String branch_code = request.getParameter("branch_code");
		// 名義人取得
		String bank_persons = request.getParameter("bank_persons");
		// 銀行名取得
		String bank_name = request.getParameter("bank_name");
		
		/* bank_number validation */
		if(StringUtils.isEmpty(bank_number)) {
			val = false;
			errmsg.add("口座番号を入力してください。");			
		} else {
			if(!bank_number.matches("[0-9]{1,10}")) {
				val = false;
				errmsg.add("口座番号は半角数字10文字以内で入力してください。");
			}
		}
		/* branch_code validation */
		if(StringUtils.isEmpty(branch_code)) {
			val = false;
			errmsg.add("支店番号を入力してください。");
		} else {
			if(!branch_code.matches("[0-9]{3}")) {
				val = false;
				errmsg.add("支店番号は半角数字3文字以内で入力してください。");				
			}
		}
		/* bank_persons validation */
		if(StringUtils.isEmpty(bank_persons)) {
			val = false;
			errmsg.add("名義人を入力してください。");			
		} else {
			if(bank_persons.length() > 20) {
				val = false;
				errmsg.add("名義人は20文字以内で入力してください。");				
			}
		}
		/* bank_name validation */
		if(StringUtils.isEmpty(bank_name)) {
			val = false;
			errmsg.add("銀行名を選択してください。");				
		}
		return val;
	}
	/**
	 * getCreditAddvalidationメソッド : クレジットカード　追加処理
	 * 
	 * @param request : 入力(クレジットカード番号,有効期限,カード会社,セキュリティコード,カード名義人)
	 * @return val boolean :　true:成功/ false:失敗
	 */
	public boolean getCreditAddValidation(HttpServletRequest request) {
		this.errmsg = new ArrayList<String>();
		this.val = true;
		
		// クレジットカード番号取得
		String card_number = request.getParameter("card_number");
		// 有効期限取得
		String limit_date = request.getParameter("limit_date");
		// カード会社取得
		String card_company = request.getParameter("card_company");
		// セキュリティコード取得
		String sec_code = request.getParameter("sec_code");
		// カード名義人取得
		String card_persons = request.getParameter("card_persons");
		
		/* card_number validation */
		if(StringUtils.isEmpty(card_number)) {
			val = false;
			errmsg.add("クレジットカード番号を入力してください。");
		} else {
			if(!card_number.matches("[0-9]{16}")) {
				val = false;
				errmsg.add("クレジットカード番号は半角数字16文字で入力してください。");
			}
		}
		/* limit_date validation */
		if(StringUtils.isEmpty(limit_date)) {
			val = false;
			errmsg.add("有効期限を入力してください。");
		} else {
			if(!limit_date.matches("[0-9]{4}-{1}[0-9]{2}")) {
				val = false;
				errmsg.add("有効期限の形式が間違っています。");
			}
		}
		/* card_company validation */
		if(StringUtils.isEmpty(card_company)) {
			val = false;
			errmsg.add("カード会社名を入力してください。");
		}
		/* sec_code validation */
		if(StringUtils.isEmpty(sec_code)) {
			val = false;
			errmsg.add("セキュリティコードを入力してください。");
		} else {
			if(!sec_code.matches("[0-9]{3}")) {
				errmsg.add("セキュリティコードは半角数字3文字で入力してください。");
			}
		}
		/* card_persons validation */
		if(StringUtils.isEmpty(card_persons)) {
			val = false;
			errmsg.add("カード名義人を入力してください。");
		} else {
			if(!card_persons.matches("[A-Z]+ [A-Z]+")) {
				errmsg.add("カード名義人の形式が間違っています。");
			}
		}
		return val;
	}
	/**
	 * getPostMusicvalidationメソッド: 商品登録処理
	 * 
	 * @param request : 入力（商品名,価格）
	 * @return val boolean :　true:成功/ false:失敗
	 */
	public boolean getPostMusicValidation(HttpServletRequest request) {
		this.errmsg = new ArrayList<String>();
		this.val = true;
		
		String product_name = request.getParameter("product_name");
		String price = request.getParameter("price");
		
		/* product_name validation */
		if(StringUtils.isEmpty(product_name)) {
			val = false;
			errmsg.add("楽曲名を入力してください。");
		} else {
			if(product_name.length() > 20) {
				errmsg.add("楽曲名は20文字以内で入力してください。");
			}
		}
		/* price validation */
		if(StringUtils.isEmpty(price)) {
			val = false;
			errmsg.add("価格を入力してください。");
		} else {
			if(!price.matches("[0-9]{1,6}")) {
				errmsg.add("価格は半角数字6桁以内で入力してください。");
			}
		}
		return val;
	}
}