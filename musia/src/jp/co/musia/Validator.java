package jp.co.musia;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;


public class Validator {

	// エラーメッセージリスト
	private ArrayList<String> errmsg;
	// バリデーション判定変数
	private boolean valid;
	
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
	 * @return valid boolean: true:成功/ false:失敗
	 */
	public boolean getSearchMusic(HttpServletRequest request) {
		
		this.errmsg = new ArrayList<String>();
		this.valid = true;
		// 検索ワード取得
		String value = request.getParameter("search_word");
		
		if(StringUtils.isEmpty(value)) {
			valid = false;
			errmsg.add("楽曲名を入力してください。");
		} else {
			if(value.length() > 20) {
				valid = false;
				errmsg.add("楽曲名は20文字以内で入力してください。");
			}
		}
		return valid;
	}
	/**
	 * getLoginValidationメソッド : ログイン処理に対するバリデーション
	 * 
	 * @param request : 入力(メールアドレス,パスワード)
	 * @return valid boolean :　true:成功/ false:失敗
	 */
	public boolean getLoginValidation(HttpServletRequest request) {
		this.errmsg = new ArrayList<String>();
		this.valid = true;
		
		// メールアドレス取得
		String email = request.getParameter("email");
		// パスワード取得
		String password = request.getParameter("password");
		
		/* email Validation */
		if(StringUtils.isEmpty(email)) {	//　空またはnull
			valid = false;
			errmsg.add("メールアドレスを入力してください。");
		} else {
			if(!email.matches("[0-9a-zA-Z]+")) {
				valid = false;
				errmsg.add("メールアドレスは半角英数字で入力してください。");
			}			
			if(email.length() > 50) {
				valid = false;
				errmsg.add("メールアドレスは50文字以内で入力してください。");
			}
		}
		/* password Validation */
		if(StringUtils.isEmpty(password)) {	// 空またはnull
			valid = false;
			errmsg.add("パスワードを入力してください。");
		} else {
			if(!password.matches("[0-9a-zA-Z]+")) {
				valid = false;
				errmsg.add("パスワードは半角英数字で入力してください。");
			}
			if(password.length() >= 6 && password.length() <= 8) {
				valid = false;
				errmsg.add("パスワードは6文字~8文字で入力してください。");
			}
		}
		return valid;
	}
	/**
	 * getBankAddValidationメソッド : 銀行口座　追加処理
	 * 
	 * @param request : 入力(口座番号,支店番号,口座名義人,銀行名)
	 * @return valid boolean :　true:成功/ false:失敗
	 */
	public boolean getBankAddValidation(HttpServletRequest request) {
		this.errmsg = new ArrayList<String>();
		this.valid = true;
		
		// 口座番号取得
		String bank_number = request.getParameter("bank_number");
		// 支店番号取得
		String branch_code = request.getParameter("branch_code");
		// 名義人取得
		String bank_persons = request.getParameter("bank_persons");
		// 銀行名取得
		String bank_name = request.getParameter("bank_name");
		
		/* bank_number Validation */
		if(StringUtils.isEmpty(bank_number)) {
			valid = false;
			errmsg.add("口座番号を入力してください。");			
		} else {
			if(!bank_number.matches("[0-9]{1,10}")) {
				valid = false;
				errmsg.add("口座番号は半角数字10文字以内で入力してください。");
			}
		}
		/* branch_code Validation */
		if(StringUtils.isEmpty(branch_code)) {
			valid = false;
			errmsg.add("支店番号を入力してください。");
		} else {
			if(!branch_code.matches("[0-9]{3}")) {
				valid = false;
				errmsg.add("支店番号は半角数字3文字以内で入力してください。");				
			}
		}
		/* bank_persons Validation */
		if(StringUtils.isEmpty(bank_persons)) {
			valid = false;
			errmsg.add("名義人を入力してください。");			
		} else {
			if(bank_persons.length() > 20) {
				valid = false;
				errmsg.add("名義人は20文字以内で入力してください。");				
			}
		}
		/* bank_name Validation */
		if(StringUtils.isEmpty(bank_name)) {
			valid = false;
			errmsg.add("銀行名を選択してください。");				
		}
		return valid;
	}
	/**
	 * getCreditAddValidationメソッド : クレジットカード　追加処理
	 * 
	 * @param request : 入力(クレジットカード番号,有効期限,カード会社,セキュリティコード,カード名義人)
	 * @return valid boolean :　true:成功/ false:失敗
	 */
	public boolean getCreditAddValidation(HttpServletRequest request) {
		this.errmsg = new ArrayList<String>();
		this.valid = true;
		
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
		
		/* card_number Validation */
		if(StringUtils.isEmpty(card_number)) {
			valid = false;
			errmsg.add("クレジットカード番号を入力してください。");
		} else {
			if(!card_number.matches("[0-9]{16}")) {
				valid = false;
				errmsg.add("クレジットカード番号は半角数字16文字で入力してください。");
			}
		}
		/* limit_date Validation */
		if(StringUtils.isEmpty(limit_date)) {
			valid = false;
			errmsg.add("有効期限を入力してください。");
		} else {
			if(!limit_date.matches("[0-9]{4}-{1}[0-9]{2}")) {
				valid = false;
				errmsg.add("有効期限の形式が間違っています。");
			}
		}
		/* card_company Validation */
		if(StringUtils.isEmpty(card_company)) {
			valid = false;
			errmsg.add("カード会社名を入力してください。");
		}
		/* sec_code Validation */
		if(StringUtils.isEmpty(sec_code)) {
			valid = false;
			errmsg.add("セキュリティコードを入力してください。");
		} else {
			if(!sec_code.matches("[0-9]{3}")) {
				errmsg.add("セキュリティコードは半角数字3文字で入力してください。");
			}
		}
		/* card_persons Validation */
		if(StringUtils.isEmpty(card_persons)) {
			valid = false;
			errmsg.add("カード名義人を入力してください。");
		} else {
			if(!card_persons.matches("[A-Z]+ [A-Z]+")) {
				errmsg.add("カード名義人の形式が間違っています。");
			}
		}
		return valid;
	}
	/* 1/25 �ｽr�ｽ�ｽ */
	public boolean getPostMusicValidation(String product_name, String price) {
		// �ｽG�ｽ�ｽ�ｽ[�ｽ�ｽ�ｽb�ｽZ�ｽ[�ｽW�ｽ�ｽ�ｽX�ｽg�ｽ�ｽ�ｽ�ｽ
		this.errmsg = new ArrayList<String>();
		// �ｽo�ｽ�ｽ�ｽf�ｽ[�ｽV�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ闖会ｿｽ�ｽ
		this.valid = true;
		
		/* product_name Validation */
		if(StringUtils.isEmpty(product_name)) {
			valid = false;
			errmsg.add("�ｽy�ｽﾈ厄ｿｽ�ｽ�ｽ�ｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
		} else {
			if(product_name.length() > 20) {
				errmsg.add("�ｽy�ｽﾈ厄ｿｽ�ｽ�ｽ20�ｽ�ｽ�ｽ�ｽ�ｽﾈ難ｿｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
			}
		}
		/* price Validation */
		if(StringUtils.isEmpty(price)) {
			valid = false;
			errmsg.add("�ｽ�ｽ�ｽi�ｽ�ｽ�ｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
		} else {
			if(!price.matches("[0-9]{1,6}")) {
				errmsg.add("�ｽ�ｽ�ｽi�ｽﾍ費ｿｽ�ｽp�ｽ�ｽ�ｽ�ｽ6�ｽ�ｽ�ｽ�ｽ�ｽﾈ難ｿｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄ会ｿｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
			}
		}
		
		return valid;
	}
}
