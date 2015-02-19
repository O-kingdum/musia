package jp.co.musia.okingdum.Bean;

public class Contest_CheckBean {
	
	private String contest_id;
	private String list_id;
	
	public Contest_CheckBean() {
	
	}
	
	public Contest_CheckBean(String contest_id,String list_id) {
		this.contest_id = contest_id;
		this.list_id = list_id;
	}
	
	public String getContest_id() {
		return contest_id;
	}
	public void setContest_id(String contest_id) {
		this.contest_id = contest_id;
	}
	public String getList_id() {
		return list_id;
	}
	public void setList_id(String list_id) {
		this.list_id = list_id;
	}
	
	
}
