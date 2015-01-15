package jp.co.musia.okingdum;

public class Sales {
	
	private String sale_id;
	private String user_id;
	private String sale_date;
	private int total_amount;
	
	public Sales(String sale_id, String user_id, String sale_date,
			int total_amount) {
		this.sale_id = sale_id;
		this.user_id = user_id;
		this.sale_date = sale_date;
		this.total_amount = total_amount;
	}

	public String getSale_id() {
		return sale_id;
	}

	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSale_date() {
		return sale_date;
	}

	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}	
}
