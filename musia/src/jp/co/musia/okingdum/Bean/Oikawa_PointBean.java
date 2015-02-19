package jp.co.musia.okingdum.Bean;

public class Oikawa_PointBean {
	private String user_id;
	private int op;
	private String op_date;
	private int op_flg;
	
	public Oikawa_PointBean() {
		
	}
	
	public Oikawa_PointBean(String user_id,int op,String op_date,int op_flg) {
		this.user_id = user_id;
		this.op = op;
		this.op_date = op_date;
		this.op_flg = op_flg;
	}
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	public String getOp_date() {
		return op_date;
	}
	public void setOp_date(String op_date) {
		this.op_date = op_date;
	}
	public int getOp_flg() {
		return op_flg;
	}
	public void setOp_flg(int op_flg) {
		this.op_flg = op_flg;
	}
}
