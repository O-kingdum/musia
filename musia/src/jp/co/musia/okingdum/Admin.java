package jp.co.musia.okingdum;

public class Admin {

	private String admin_id;
	private String admin_password;
	
	/**
	 * 
	 * @param admin_id : 管理者ID
	 * @param admin_password : 管理者パスワード
	 *
	 */
	public Admin(String admin_id, String admin_password) {
		this.admin_id = admin_id;
		this.admin_password = admin_password;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
}
