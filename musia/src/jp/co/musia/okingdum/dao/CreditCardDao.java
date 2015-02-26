package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.CreditCardBean;

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
	 *            ArrayList<Object> CreditCardBean
	 * @return retarr ArrayList<Object> 検索結果
	 */
	public ArrayList<Object> selectCreditCard(ArrayList<Object> array) {

		String sql = "SELECT t_creditcard WHERE f_credit_id in('";
		ArrayList<Object> retarr = new ArrayList<Object>();

		for (int i = 0; i < array.size(); i++) {
			sql += ((CreditCardBean) array.get(i)).getCredit_id() + "','";
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
}
