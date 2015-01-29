package jp.co.musia;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Validator {

	private ArrayList<String> errmsg;
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
	 * @param value String: 検索ワード
	 * @return valid boolean: バリデーション判定
	 */
	public boolean getSearchMusic(String value) {
		this.errmsg = new ArrayList<String>();
		this.valid = true;
		
		if(StringUtils.isEmpty(value)) {
			valid = false;
			errmsg.add("楽曲名を入力してください。");
		} else {
			if(value.length() > 20) {
				valid = false;
				errmsg.add("�ｽy�ｽﾈ厄ｿｽ�ｽ�ｽ20�ｽ�ｽ�ｽ�ｽ�ｽﾈ難ｿｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄ会ｿｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
			}
		}
		return valid;
	}
	/**
	 * getLoginValidation�ｽ�ｽ�ｽ\�ｽb�ｽh : �ｽ�ｽ�ｽO�ｽC�ｽ�ｽ�ｽ�ｽ�ｽﾌ難ｿｽﾍに対ゑｿｽ�ｽ�ｽo�ｽ�ｽ�ｽf�ｽ[�ｽV�ｽ�ｽ�ｽ�ｽ
	 * 
	 * @param email String: �ｽ�ｽ�ｽ[�ｽ�ｽ�ｽA�ｽh�ｽ�ｽ�ｽX
	 * @param password String:�ｽ@�ｽp�ｽX�ｽ�ｽ�ｽ[�ｽh
	 * @return valid boolean:�ｽ@�ｽo�ｽ�ｽ�ｽf�ｽ[�ｽV�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ
	 */
	public boolean getLoginValidation(String email, String password) {
		// �ｽG�ｽ�ｽ�ｽ[�ｽ�ｽ�ｽb�ｽZ�ｽ[�ｽW�ｽ�ｽ�ｽX�ｽg�ｽ�ｽ�ｽ�ｽ
		this.errmsg = new ArrayList<String>();
		// �ｽo�ｽ�ｽ�ｽf�ｽ[�ｽV�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ闖会ｿｽ�ｽ
		this.valid = true;
		
		/* email Validation */
		if(StringUtils.isEmpty(email)) {	// �ｽ�ｽﾜゑｿｽ�ｽ�ｽnull
			valid = false;
			errmsg.add("�ｽ�ｽ�ｽ[�ｽ�ｽ�ｽA�ｽh�ｽ�ｽ�ｽX�ｽ�ｽ�ｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
		} else {
			if(!email.matches("[0-9a-zA-Z]+")) {
				valid = false;
				errmsg.add("�ｽ�ｽ�ｽ[�ｽ�ｽ�ｽA�ｽh�ｽ�ｽ�ｽX�ｽﾍ費ｿｽ�ｽp�ｽp�ｽ�ｽ�ｽ�ｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
			}			
			if(email.length() > 50) {
				valid = false;
				errmsg.add("�ｽ�ｽ�ｽ[�ｽ�ｽ�ｽA�ｽh�ｽ�ｽ�ｽX�ｽ�ｽ50�ｽ�ｽ�ｽ�ｽ�ｽﾈ難ｿｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
			}
		}
		/* password Validation */
		if(StringUtils.isEmpty(password)) {	// �ｽ�ｽﾜゑｿｽ�ｽ�ｽnull
			valid = false;
			errmsg.add("�ｽp�ｽX�ｽ�ｽ�ｽ[�ｽh�ｽ�ｽ�ｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
		} else {
			if(!password.matches("[0-9a-zA-Z]+")) {
				valid = false;
				errmsg.add("�ｽp�ｽX�ｽ�ｽ�ｽ[�ｽh�ｽﾍ費ｿｽ�ｽp�ｽp�ｽ�ｽ�ｽ�ｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
			}
			if(password.length() >= 6 && password.length() <= 8) {
				valid = false;
				errmsg.add("�ｽp�ｽX�ｽ�ｽ�ｽ[�ｽh�ｽ�ｽ6~8�ｽ�ｽ�ｽ�ｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
			}
		}
		return valid;
	}
	/**
	 * getBankAddValidation�ｽ�ｽ�ｽ\�ｽb�ｽh : �ｽ�ｽs�ｽ�ｽ�ｽ�ｽo�ｽ^�ｽ�ｽ�ｽ�ｽ�ｽﾉ対ゑｿｽ�ｽ�ｽo�ｽ�ｽ�ｽf�ｽ[�ｽV�ｽ�ｽ�ｽ�ｽ
	 * 
	 * @param bank_number String: �ｽ�ｽ�ｽ�ｽﾔ搾ｿｽ
	 * @param branch_code String: �ｽx�ｽX�ｽﾔ搾ｿｽ
	 * @param bank_persons String: �ｽ�ｽ�ｽ�ｽ�ｽ�ｽ`�ｽl
	 * @param bank_name String: �ｽ�ｽs�ｽ�ｽ
	 * @return valid boolean: �ｽo�ｽ�ｽ�ｽf�ｽ[�ｽV�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ
	 */
	public boolean getBankAddValidation(String bank_number, String branch_code,
			String bank_persons, String bank_name) {
		// �ｽG�ｽ�ｽ�ｽ[�ｽ�ｽ�ｽb�ｽZ�ｽ[�ｽW�ｽ�ｽ�ｽX�ｽg�ｽ�ｽ�ｽ�ｽ
		this.errmsg = new ArrayList<String>();
		// �ｽo�ｽ�ｽ�ｽf�ｽ[�ｽV�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ闖会ｿｽ�ｽ
		this.valid = true;
		
		/* bank_number Validation */
		if(StringUtils.isEmpty(bank_number)) {
			valid = false;
			errmsg.add("�ｽ�ｽ�ｽ�ｽﾔ搾ｿｽ�ｽ�ｽ�ｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");			
		} else {
			if(!bank_number.matches("[0-9]{1,10}")) {
				valid = false;
				errmsg.add("�ｽ�ｽ�ｽ�ｽﾔ搾ｿｽ�ｽﾍ費ｿｽ�ｽp�ｽ�ｽ�ｽ�ｽ10�ｽ�ｽ�ｽ�ｽ�ｽﾈ難ｿｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄ会ｿｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
			}
		}
		/* branch_code Validation */
		if(StringUtils.isEmpty(branch_code)) {
			valid = false;
			errmsg.add("�ｽx�ｽX�ｽﾔ搾ｿｽ�ｽ�ｽ�ｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
		} else {
			if(!branch_code.matches("[0-9]{3}")) {
				valid = false;
				errmsg.add("�ｽx�ｽX�ｽﾔ搾ｿｽ�ｽﾍ費ｿｽ�ｽp�ｽ�ｽ�ｽ�ｽ3�ｽ�ｽ�ｽ�ｽ�ｽﾈ難ｿｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄ会ｿｽ�ｽ�ｽ�ｽ�ｽ�ｽB");				
			}
		}
		/* bank_persons Validation */
		if(StringUtils.isEmpty(bank_persons)) {
			valid = false;
			errmsg.add("�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ`�ｽl�ｽ�ｽ�ｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");			
		} else {
			if(bank_persons.length() > 20) {
				valid = false;
				errmsg.add("�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ`�ｽl�ｽ�ｽ20�ｽ�ｽ�ｽ�ｽ�ｽﾈ難ｿｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");				
			}
		}
		/* bank_name Validation */
		if(StringUtils.isEmpty(bank_name)) {
			valid = false;
			errmsg.add("�ｽ�ｽs�ｽ�ｽ�ｽ�ｽI�ｽ�ｽ�ｽ�ｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");				
		}
		
		return valid;
	}
	/**
	 * getCreditAddValidation�ｽ�ｽ�ｽ\�ｽb�ｽh : �ｽN�ｽ�ｽ�ｽW�ｽb�ｽg�ｽJ�ｽ[�ｽh�ｽo�ｽ^�ｽ�ｽ�ｽ�ｽ�ｽﾉ対ゑｿｽ�ｽ�ｽo�ｽ�ｽ�ｽf�ｽ[�ｽV�ｽ�ｽ�ｽ�ｽ
	 * 
	 * @param card_number String : �ｽN�ｽ�ｽ�ｽW�ｽb�ｽg�ｽJ�ｽ[�ｽh�ｽﾔ搾ｿｽ
	 * @param limit_date String : �ｽL�ｽ�ｽ�ｽ�ｽ
	 * @param card_company : �ｽN�ｽ�ｽ�ｽW�ｽb�ｽg�ｽJ�ｽ[�ｽh�ｽ�ｽ�ｽ 
	 * @param sec_code : �ｽZ�ｽL�ｽ�ｽ�ｽ�ｽ�ｽe�ｽB�ｽR�ｽ[�ｽh
	 * @param card_persons : �ｽJ�ｽ[�ｽh�ｽ�ｽ�ｽ`�ｽl
	 * @return valid boolean : �ｽo�ｽ�ｽ�ｽf�ｽ[�ｽV�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ
	 */
	public boolean getCreditAddValidation(String card_number, String limit_date, String card_company,
			String sec_code, String card_persons) {
		// �ｽG�ｽ�ｽ�ｽ[�ｽ�ｽ�ｽb�ｽZ�ｽ[�ｽW�ｽ�ｽ�ｽX�ｽg�ｽ�ｽ�ｽ�ｽ
		this.errmsg = new ArrayList<String>();
		// �ｽo�ｽ�ｽ�ｽf�ｽ[�ｽV�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ闖会ｿｽ�ｽ
		this.valid = true;
		
		/* card_number Validation */
		if(StringUtils.isEmpty(card_number)) {
			valid = false;
			errmsg.add("�ｽN�ｽ�ｽ�ｽW�ｽb�ｽg�ｽJ�ｽ[�ｽh�ｽﾔ搾ｿｽ�ｽ�ｽ�ｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
		} else {
			if(!card_number.matches("[0-9]{16}")) {
				valid = false;
				errmsg.add("�ｽN�ｽ�ｽ�ｽW�ｽb�ｽg�ｽJ�ｽ[�ｽh�ｽﾔ搾ｿｽ�ｽﾍ費ｿｽ�ｽp�ｽ�ｽ�ｽ�ｽ16�ｽ�ｽ�ｽ�ｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄ会ｿｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
			}
		}
		/* limit_date Validation */
		if(StringUtils.isEmpty(limit_date)) {
			valid = false;
			errmsg.add("�ｽL�ｽ�ｽ�ｽ�ｽ�ｽ�ｽI�ｽ�ｽ�ｽ�ｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
		} else {
			if(!card_number.matches("[0-9]{4}-{1}[0-9]{2}")) {
				valid = false;
				errmsg.add("�ｽL�ｽ�ｽ�ｽ�ｽ�ｽﾌ形�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽﾜゑｿｽ�ｽ�ｽB");
			}
		}
		/*�ｽ@card_company�ｽ@*/
		if(StringUtils.isEmpty(card_company)) {
			valid = false;
			errmsg.add("�ｽN�ｽ�ｽ�ｽW�ｽb�ｽg�ｽJ�ｽ[�ｽh�ｽ�ｽﾐゑｿｽ�ｽI�ｽ�ｽ�ｽ�ｽ�ｽ�ｽﾄゑｿｽ�ｽﾜゑｿｽ�ｽ�ｽB");
		}
		/* sec_code Validation */
		if(StringUtils.isEmpty(sec_code)) {
			valid = false;
			errmsg.add("�ｽZ�ｽL�ｽ�ｽ�ｽ�ｽ�ｽe�ｽB�ｽR�ｽ[�ｽh�ｽ�ｽ�ｽ�ｽﾍゑｿｽ�ｽ�ｽﾄゑｿｽ�ｽﾜゑｿｽ�ｽ�ｽB");
		} else {
			if(!card_number.matches("[0-9]{3}")) {
				errmsg.add("�ｽZ�ｽL�ｽ�ｽ�ｽ�ｽ�ｽe�ｽB�ｽR�ｽ[�ｽh�ｽﾍ費ｿｽ�ｽp�ｽ�ｽ�ｽ�ｽ3�ｽ�ｽ�ｽ�ｽ�ｽﾅ難ｿｽﾍゑｿｽ�ｽﾄ会ｿｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
			}
		}
		/* card_persons Validation */
		if(StringUtils.isEmpty(card_persons)) {
			valid = false;
			errmsg.add("�ｽJ�ｽ[�ｽh�ｽ�ｽ�ｽ`�ｽl�ｽ�ｽ�ｽﾍゑｿｽ�ｽﾄゑｿｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽB");
		} else {
			if(!card_number.matches("[A-Z]+ [A-Z]+")) {
				errmsg.add("�ｽJ�ｽ[�ｽh�ｽ�ｽ�ｽ`�ｽl�ｽﾌ形�ｽ�ｽ�ｽ�ｽ�ｽﾔ茨ｿｽ�ｽ�ｽﾄゑｿｽ�ｽﾜゑｿｽ�ｽB");
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
