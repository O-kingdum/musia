package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.IineBean;

public class IineDao extends Dao {
	/**
	 * insertIineメソッド
	 * 
	 * @param iine
	 *            IineBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertIine(IineBean iine) {

		int ret = 0;
		String sql = "INSERT INTO t_iine VALUES(?,?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, iine.getUser_id());
			ps.setString(2, iine.getProduct_id());

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
	 * updateIineメソッド
	 * 
	 * @param iine
	 *            IineBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateIine(IineBean iine) {

		int ret = 0;
		String sql = "UPDATE t_iine SET f_product_id=? WHERE f_user_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, iine.getProduct_id());
			ps.setString(2, iine.getUser_id());
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
	 * deleteIineメソッド
	 * 
	 * @param iine
	 *            IineBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteIine(IineBean iine) {

		int ret = 0;
		String sql = "DELETE FROM t_iine WHERE f_user_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, iine.getUser_id());
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
	 * selectIineメソッド
	 * 
	 * @param array
	 *            ArrayList<IineBean> IineBean
	 * @return retarr ArrayList<IineBean> 検索結果
	 */
	public ArrayList<IineBean> selectIine(ArrayList<IineBean> array) {

		String sql = "SELECT * FROM t_iine WHERE f_user_id in('";
		ArrayList<IineBean> retarr = new ArrayList<IineBean>();

		for (int i = 0; i < array.size(); i++) {
			sql += array.get(i).getUser_id() + "','";
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
				retarr.add(new IineBean(rs.getString("f_user_id"), rs
						.getString("f_product_id")));
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
