package jp.co.musia.okingdum;

public class Check_List {

	private String list_id;
	private String check_list;
	
	/**
	 * 
	 * @param list_id : �`�F�b�N���X�gID
	 * @param check_list : �`�F�b�N���X�g����
	 *
	 */
	public Check_List(String list_id, String check_list) {
		this.list_id = list_id;
		this.check_list = check_list;
	}

	public String getList_id() {
		return list_id;
	}

	public void setList_id(String list_id) {
		this.list_id = list_id;
	}

	public String getCheck_list() {
		return check_list;
	}

	public void setCheck_list(String check_list) {
		this.check_list = check_list;
	}
}
