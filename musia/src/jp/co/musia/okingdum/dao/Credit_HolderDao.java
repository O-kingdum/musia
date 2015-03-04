package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.Credit_HolderBean;

public class Credit_HolderDao extends Dao {
	/**
	 * insertCheckListメソッド : Credit_Holderを追加する
	 * 
	 * @param credit_holder
	 *            Credit_HolderBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertCredit_Holder(Credit_HolderBean credit_holder) {

		int ret = 0;
		String sql = "INSERT INTO t_credit_holder VALUES(?,?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, credit_holder.getCredit_id());
			ps.setString(2, credit_holder.getUser_id());

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
	 * updateCredit_Holderメソッド
	 * 
	 * @param credit_holder
	 *            Credit_HolderBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateCredit_Holder(Credit_HolderBean credit_holder) {

		int ret = 0;
		String sql = "UPDATE t_credit_holder SET f_user_id=? WHERE f_credit_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, credit_holder.getUser_id());
			ps.setString(2, credit_holder.getCredit_id());
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
	 * deleteCredit_Holderメソッド
	 * 
	 * @param credit_holder
	 *            Credit_HolderBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteCredit_Holder(Credit_HolderBean credit_holder) {

		int ret = 0;
		String sql = "DELETE FROM t_credit_holder WHERE f_credit_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, credit_holder.getCredit_id());
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
	 * selectCredit_Holderメソッド
	 * 
	 * @param array
	 *            ArrayList<Credit_HolderBean> Credit_HolderBean
	 * @return retarr ArrayList<Credit_HolderBean> 検索結果
	 */
	public ArrayList<Credit_HolderBean> selectCredit_Holder(ArrayList<Credit_HolderBean> array) {

		String sql = "SELECT * FROM t_credit_holder WHERE f_credit_id in('";
		ArrayList<Credit_HolderBean> retarr = new ArrayList<Credit_HolderBean>();

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
				retarr.add(new Credit_HolderBean(rs.getString("f_credit_id"),
						rs.getString("f_user_id")));
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
