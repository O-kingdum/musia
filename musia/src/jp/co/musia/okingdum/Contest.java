package jp.co.musia.okingdum;

public class Contest {

	private String contest_id;
	private String contest_name;
	private String enterprise_name;
	private String start_date;
	private String end_date;
	private String members;
	private String requirements;
	private String remarks;
	
	/**
	 * 
	 * @param contest_id : コンテストID
	 * @param contest_name : コンテスト名
	 * @param enterprise_name : 募集企業名
	 * @param start_date : 募集開始日
	 * @param end_date : 募集終了日
	 * @param members : 採用人数
	 * @param requirements : 募集要項
	 * @param remarks : 備考
	 * 
	 */
	public Contest(String contest_id, String contest_name,
			String enterprise_name, String start_date, String end_date,
			String members, String requirements, String remarks) {
		this.contest_id = contest_id;
		this.contest_name = contest_name;
		this.enterprise_name = enterprise_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.members = members;
		this.requirements = requirements;
		this.remarks = remarks;
	}

	public String getContest_id() {
		return contest_id;
	}

	public void setContest_id(String contest_id) {
		this.contest_id = contest_id;
	}

	public String getContest_name() {
		return contest_name;
	}

	public void setContest_name(String contest_name) {
		this.contest_name = contest_name;
	}

	public String getEnterprise_name() {
		return enterprise_name;
	}

	public void setEnterprise_name(String enterprise_name) {
		this.enterprise_name = enterprise_name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
