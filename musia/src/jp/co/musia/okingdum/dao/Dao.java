package jp.co.musia.okingdum.dao;

import java.sql.*;

/**
 * Created by Tkray on 15/01/28.
 */
public class Dao {

	/** コネクションオブジェクト */
	protected Connection con = null;
	/** プリペアードステートメントオブジェクト */
	protected PreparedStatement ps = null;
	/** プリペアードステートメントオブジェクト */
	protected Statement st = null;
	/** リザルトセットオブジェクト */
	protected ResultSet rs = null;

	/** メッセージを格納 */
	private String msg;
	
	/** エラー判定フラグ*/
	private boolean errflag = true;

	Dao() {
		con = null;

		ps = null;

		st = null;

		rs = null;
	}

	/**
	 * MySQLに接続する
	 */
	protected void getConnection() {
		String url = "jdbc:mysql://localhost/musia?user=root&password=root&useUnicode=true&characterEncoding=utf-8";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			System.out.println("ドライバーが見つかりません");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * DBをクローズする
	 */
	protected void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * getMsgメソッド：Daoのmsgのゲッター
	 * 
	 * @return
	 */
	public String getMsg() {
		return this.msg;
	}

	/**
	 * setMsgメソッド：Daoのmsgのセッター
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean getErrflag() {
		return this.errflag;
	}

	public void setErrflag(boolean errflag) {
		this.errflag = errflag;
	}
	
}
