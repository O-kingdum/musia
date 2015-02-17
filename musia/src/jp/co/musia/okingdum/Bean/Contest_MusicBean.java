package jp.co.musia.okingdum.Bean;

public class Contest_MusicBean {

	private String contest_id;
	private String product_id;
	private String contest_admin_id;
	private int contest_examination;
	private String record_date;

	public String getContest_id() {
		return contest_id;
	}

	public void setContest_id(String contest_id) {
		this.contest_id = contest_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getContest_admin_id() {
		return contest_admin_id;
	}

	public void setContest_admin_id(String contest_admin_id) {
		this.contest_admin_id = contest_admin_id;
	}

	public int getContest_examination() {
		return contest_examination;
	}

	public void setContest_examination(int contest_examination) {
		this.contest_examination = contest_examination;
	}

	public String getRecord_date() {
		return record_date;
	}

	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}
}
