package jp.co.musia.okingdum;

public class Users {

	private String mail;
	private String name;
	private String password;
	private int sex;
	private String birthday;
	private String self_introduction;
	private String entry_date;
	private int bank_number;
	private int branch_code;
	private String bank_persons;
	private String bank_name;
	
	/**
	 * 
	 * @param mail : ���[���A�h���X
	 * @param name : ���[�U��
	 * @param password : �p�X���[�h
	 * @param sex : ����
	 * @param birthday�@: ���N����
	 * @param self_introduction : ���ȏЉ
	 * @param entry_date : �o�^��
	 * @param bank_number : �����ԍ�
	 * @param branch_code : �x�X�ԍ�
	 * @param bank_persons : �������`�l
	 * @param bank_name : ��s��
	 */
	public Users(String mail, String name, String password, int sex,
			String birthday, String self_introduction, String entry_date,
			int bank_number, int branch_code, String bank_persons,
			String bank_name) {
		this.mail = mail;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.self_introduction = self_introduction;
		this.entry_date = entry_date;
		this.bank_number = bank_number;
		this.branch_code = branch_code;
		this.bank_persons = bank_persons;
		this.bank_name = bank_name;
	}
	

	/**
	 * �V�K�o�^
	 * 
	 * @param mail : ���[���A�h���X
	 * @param name : ���[�U��
	 * @param password : �p�X���[�h
	 * @param sex : ����
	 * @param birthday�@: ���N����
	 */
	public Users(String mail, String name, String password, int sex,
			String birthday) {
		this.mail = mail;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSelf_introduction() {
		return self_introduction;
	}

	public void setSelf_introduction(String self_introduction) {
		this.self_introduction = self_introduction;
	}

	public String getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}

	public int getBank_number() {
		return bank_number;
	}

	public void setBank_number(int bank_number) {
		this.bank_number = bank_number;
	}

	public int getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(int branch_code) {
		this.branch_code = branch_code;
	}

	public String getBank_persons() {
		return bank_persons;
	}

	public void setBank_persons(String bank_persons) {
		this.bank_persons = bank_persons;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
}
