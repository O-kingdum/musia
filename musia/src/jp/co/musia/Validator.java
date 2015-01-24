package jp.co.musia;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class Validator {

	private ArrayList<String> errmsg;
	private boolean valid;
	
	/**
	 * getErrMsgメソッド : エラーメッセージの取得
	 * 
	 * @return errmsg ArrayList<String>: バリデーションエラーメッセージリスト
	 */
	public ArrayList<String> getErrMsg() {
		return this.errmsg;
	}
	
	/**
	 * getLoginValidationメソッド : ログイン時の入力に対するバリデーション
	 * 
	 * @param email String: メールアドレス
	 * @param password String:　パスワード
	 * @return valid boolean:　バリデーション判定
	 */
	public boolean getLoginValidation(String email, String password) {
		// エラーメッセージリスト初期化
		this.errmsg = new ArrayList<String>();
		// バリデーション判定初期化
		this.valid = true;
		
		/* email Validation */
		if(StringUtils.isEmpty(email)) {	// 空またはnull
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
			if(email.length() >= 6 && email.length() <= 8) {
				valid = false;
				errmsg.add("パスワードは6~8文字で入力してください。");
			}
		}
		return valid;
	}
	
	public boolean getCreditValidation(String card_number, String limit_date, String card_company,
			String sec_code, String card_persons) {
		// エラーメッセージリスト初期化
		this.errmsg = new ArrayList<String>();
		// バリデーション判定初期化
		this.valid = true;
		
		/* card_number Validation */
		if(StringUtils.isEmpty(card_number)) {
			valid = false;
			errmsg.add("クレジットカード番号を入力してください。");
		} else {
			if(!card_number.matches("[0-9]+")) {
				valid = false;
				errmsg.add("クレジットカード番号は半角英数字で入力して下さい。");
			}
			if(card_number.length() != 16) {
				valid = false;
				errmsg.add("クレジットカード番号は16文字で入力してください。");
			}
		}
		/* limit_date Validation */
		if(StringUtils.isEmpty(limit_date)) {
			valid = false;
			errmsg.add("有効期限を入力してください。");
		} else {
			if(!card_number.matches("^[0-9]{4}-{1}[0-9]{2}")) {
				valid = false;
				errmsg.add("有効期限の形式が正しくありません。");
			}
		}
		/**/
		return valid;
	}
}
