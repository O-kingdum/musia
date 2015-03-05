package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.CreditCardBean;
import jp.co.musia.okingdum.Bean.UsersBean;
import jp.co.musia.okingdum.Bean.V_CreditCardBean;

public class CreditCardDao extends Dao {
	/**
	 * insertCreditCardメソッド : CreditCardを追加する
	 * 
	 * @param creditCard
	 *            CreditCardBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertCreditCard(CreditCardBean creditCard) {

		int ret = 0;
		String sql = "INSERT INTO t_creditcard VALUES(?,?,?,?,?,?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, creditCard.getCredit_id());
			ps.setInt(2, creditCard.getCard_number());
			ps.setString(3, creditCard.getLimit_date());
			ps.setString(4, creditCard.getCard_company());
			ps.setInt(5, creditCard.getSec_cord());
			ps.setString(6, creditCard.getCard_persons());

			// クエリ発行
			ret = ps.executeUpdate();
			// エラーフラグ
			if (ret < 1) {
				ret = -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
			ret = -1;
		} finally {
			// クローズ
			this.close();
		}
		return ret;
	}

	/**
	 * updateCreditCardメソッド
	 * 
	 * @param creditCard
	 *            CreditCardBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateCreditCard(CreditCardBean creditCard) {

		int ret = 0;
		String sql = "UPDATE t_creditcard SET f_card_number=?,f_limt_date=?,f_card_company=?,f_sec_code=?,f_card_persons=? WHERE f_credit_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setInt(1, creditCard.getCard_number());
			ps.setString(2, creditCard.getLimit_date());
			ps.setString(3, creditCard.getCard_company());
			ps.setInt(4, creditCard.getSec_cord());
			ps.setString(5, creditCard.getCard_persons());
			ps.setString(6, creditCard.getCredit_id());

			// クエリ発行
			ret = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
			ret = -1;
		} finally {
			// クローズ
			this.close();
		}
		return ret;
	}

	/**
	 * deleteCreditCardメソッド
	 * 
	 * @param creditCard
	 *            CreditCardBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteCreditCard(CreditCardBean creditCard) {

		int ret = 0;
		String sql = "DELETE FROM t_creditcard WHERE f_credit_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, creditCard.getCredit_id());
			// クエリ発行
			ret = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
			ret = -1;
		} finally {
			// クローズ
			this.close();
		}
		return ret;
	}

	/**
	 * selectCreditCardメソッド
	 * 
	 * @param array
	 *            ArrayList<CreditCardBean> CreditCardBean
	 * @return retarr ArrayList<CreditCardBean> 検索結果
	 */
	public ArrayList<CreditCardBean> selectCreditCard(ArrayList<CreditCardBean> array) {

		String sql = "SELECT * FROM t_creditcard WHERE f_credit_id in('";
		ArrayList<CreditCardBean> retarr = new ArrayList<CreditCardBean>();

		for (int i = 0; i < array.size(); i++) {
			sql += array.get(i).getCredit_id() + "','";
		}
		sql += "');";

		try {
			// コネクション生成
			this.getConnection();
			// ステートメント
			st = con.createStatement();
			// クエリ発行
			rs = st.executeQuery(sql);

			while (rs.next()) {
				retarr.add(new CreditCardBean(rs.getString("f_credit_id"), rs
						.getInt("f_card_number"), rs.getString("f_limit_date"),
						rs.getString("f_card_company"),
						rs.getInt("f_sec_code"), rs.getString("f_card_persons")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
		} finally {
			// クローズ
			this.close();
		}
		return retarr;
	}
	
	public V_CreditCardBean selectCreditHolder(UsersBean user) {
		
		String sql = "SELECT * FROM v_creditcard WHERE user_id=" + user.getUser_id() + ";";
		V_CreditCardBean card = new V_CreditCardBean();
		
		try {
			this.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				card.setUser_id(rs.getString("user_id"));
				card.setCredit_id(rs.getString("credit_id"));
				card.setCard_number(rs.getInt("card_number"));
				card.setLimit_date(rs.getString("limit_date"));
				card.setCard_company(rs.getString("credit_id"));
				card.setCredit_id(rs.getString("credit_id"));
				card.setCredit_id(rs.getString("credit_id"));
				card.setCredit_id(rs.getString("credit_id"));
			}
		} catch(SQLException e) {
			
		} finally {
			this.close();
		}
		
		return card;
	}
}
