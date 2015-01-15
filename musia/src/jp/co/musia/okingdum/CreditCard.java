package jp.co.musia.okingdum;

public class CreditCard {

	private String credit_id;
	private int card_number;
	private String limit_date;
	private String card_company;
	private int sec_cord;
	private String card_persons;
	
	/**
	 * 
	 * @param credit_id : クレジットカードID
	 * @param card_number : クレジットカード番号
	 * @param limit_date : 有効期限
	 * @param card_company : クレジットカード会社
	 * @param sec_cord : セキュリティコード
	 * @param card_persons : カード名義人
	 * 
	 */
	public CreditCard(String credit_id, int card_number, String limit_date,
			String card_company, int sec_cord, String card_persons) {
		this.credit_id = credit_id;
		this.card_number = card_number;
		this.limit_date = limit_date;
		this.card_company = card_company;
		this.sec_cord = sec_cord;
		this.card_persons = card_persons;
	}

	public String getCredit_id() {
		return credit_id;
	}

	public void setCredit_id(String credit_id) {
		this.credit_id = credit_id;
	}

	public int getCard_number() {
		return card_number;
	}

	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}

	public String getLimit_date() {
		return limit_date;
	}

	public void setLimit_date(String limit_date) {
		this.limit_date = limit_date;
	}

	public String getCard_company() {
		return card_company;
	}

	public void setCard_company(String card_company) {
		this.card_company = card_company;
	}

	public int getSec_cord() {
		return sec_cord;
	}

	public void setSec_cord(int sec_cord) {
		this.sec_cord = sec_cord;
	}

	public String getCard_persons() {
		return card_persons;
	}

	public void setCard_persons(String card_persons) {
		this.card_persons = card_persons;
	}	
}
