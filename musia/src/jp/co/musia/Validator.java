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
	 * getSearchMusicメソッド : 楽曲検索入力に対するバリデーション
	 * 
	 * @param value String: 楽曲名
	 * @return　valid boolean: バリデーション判定
	 */
	public boolean getSearchMusic(String value) {
		// エラーメッセージリスト初期化
		this.errmsg = new ArrayList<String>();
		// バリデーション判定初期化
		this.valid = true;
		
		if(StringUtils.isEmpty(value)) {
			valid = false;
			errmsg.add("楽曲名を入力してください。");
		} else {
			if(value.length() > 20) {
				valid = false;
				errmsg.add("楽曲名は20文字以内で入力して下さい。");
			}
		}
		return valid;
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
			if(password.length() >= 6 && password.length() <= 8) {
				valid = false;
				errmsg.add("パスワードは6~8文字で入力してください。");
			}
		}
		return valid;
	}
	/**
	 * getBankAddValidationメソッド : 銀行口座登録処理に対するバリデーション
	 * 
	 * @param bank_number String: 口座番号
	 * @param branch_code String: 支店番号
	 * @param bank_persons String: 口座名義人
	 * @param bank_name String: 銀行名
	 * @return valid boolean: バリデーション判定
	 */
	public boolean getBankAddValidation(String bank_number, String branch_code,
			String bank_persons, String bank_name) {
		// エラーメッセージリスト初期化
		this.errmsg = new ArrayList<String>();
		// バリデーション判定初期化
		this.valid = true;
		
		/* bank_number Validation */
		if(StringUtils.isEmpty(bank_number)) {
			valid = false;
			errmsg.add("口座番号を入力してください。");			
		} else {
			if(!bank_number.matches("[0-9]{1,10}")) {
				valid = false;
				errmsg.add("口座番号は半角数字10文字以内で入力して下さい。");
			}
		}
		/* branch_code Validation */
		if(StringUtils.isEmpty(branch_code)) {
			valid = false;
			errmsg.add("支店番号を入力してください。");
		} else {
			if(!branch_code.matches("[0-9]{3}")) {
				valid = false;
				errmsg.add("支店番号は半角数字3文字以内で入力して下さい。");				
			}
		}
		/* bank_persons Validation */
		if(StringUtils.isEmpty(bank_persons)) {
			valid = false;
			errmsg.add("口座名義人を入力してください。");			
		} else {
			if(bank_persons.length() > 20) {
				valid = false;
				errmsg.add("口座名義人は20文字以内で入力してください。");				
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
	 * getCreditAddValidationメソッド : クレジットカード登録処理に対するバリデーション
	 * 
	 * @param card_number String : クレジットカード番号
	 * @param limit_date String : 有効期限
	 * @param card_company : クレジットカード会社 
	 * @param sec_code : セキュリティコード
	 * @param card_persons : カード名義人
	 * @return valid boolean : バリデーション判定
	 */
	public boolean getCreditAddValidation(String card_number, String limit_date, String card_company,
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
			if(!card_number.matches("[0-9]{16}")) {
				valid = false;
				errmsg.add("クレジットカード番号は半角数字16文字で入力して下さい。");
			}
		}
		/* limit_date Validation */
		if(StringUtils.isEmpty(limit_date)) {
			valid = false;
			errmsg.add("有効期限を選択してください。");
		} else {
			if(!card_number.matches("[0-9]{4}-{1}[0-9]{2}")) {
				valid = false;
				errmsg.add("有効期限の形式が正しくありません。");
			}
		}
		/*　card_company　*/
		if(StringUtils.isEmpty(card_company)) {
			valid = false;
			errmsg.add("クレジットカード会社が選択されていません。");
		}
		/* sec_code Validation */
		if(StringUtils.isEmpty(sec_code)) {
			valid = false;
			errmsg.add("セキュリティコードが入力されていません。");
		} else {
			if(!card_number.matches("[0-9]{3}")) {
				errmsg.add("セキュリティコードは半角数字3文字で入力して下さい。");
			}
		}
		/* card_persons Validation */
		if(StringUtils.isEmpty(card_persons)) {
			valid = false;
			errmsg.add("カード名義人を入力してください。");
		} else {
			if(!card_number.matches("[A-Z]+ [A-Z]+")) {
				errmsg.add("カード名義人の形式が間違っています。");
			}
		}
		
		return valid;
	}
	
	public boolean getPostMusicValidation(String product_name, String price) {
		// エラーメッセージリスト初期化
		this.errmsg = new ArrayList<String>();
		// バリデーション判定初期化
		this.valid = true;
		
		
		
		return valid;
	}
}
