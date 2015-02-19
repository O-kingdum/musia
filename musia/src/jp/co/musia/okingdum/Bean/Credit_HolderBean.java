package jp.co.musia.okingdum.Bean;

public class Credit_HolderBean {
	private String credit_id;
	private String user_id;
	
	public Credit_HolderBean() {
		
	}
	
	public Credit_HolderBean(String credit_id,String user_id) {
		this.credit_id = credit_id;
		this.user_id = user_id;
	}
	
	public String getCredit_id() {
		return credit_id;
	}
	public void setCredit_id(String credit_id) {
		this.credit_id = credit_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
