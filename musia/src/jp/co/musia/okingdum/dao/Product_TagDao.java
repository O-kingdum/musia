package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.Product_TagBean;

public class Product_TagDao extends Dao {
	/**
	 * insertProduct_Tagメソッド
	 * 
	 * @param product_tag
	 *            Product_TagBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertProduct_Tag(Product_TagBean product_tag) {

		int ret = 0;
		String sql = "INSERT INTO t_product_tag VALUES(?,?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, product_tag.getProduct_id());
			ps.setString(2, product_tag.getTag_id());

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
	 * updateProduct_Tagメソッド
	 * 
	 * @param product_tag
	 *            Product_TagBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateProduct_Tag(Product_TagBean product_tag) {

		int ret = 0;
		String sql = "UPDATE t_product_tag SET f_tag_id=? WHERE f_product_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, product_tag.getTag_id());
			ps.setString(2, product_tag.getProduct_id());
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
	 * deleteProduct_Tagメソッド
	 * 
	 * @param product_tag
	 *            Product_TagBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteProduct_Tag(Product_TagBean product_tag) {

		int ret = 0;
		String sql = "DELETE FROM t_product_tag WHERE f_product_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, product_tag.getProduct_id());
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
	 * selectProduct_Tagメソッド
	 * 
	 * @param array
	 *            ArrayList<Product_TagBean> Product_TagBean
	 * @return retarr ArrayList<Product_TagBean> 検索結果
	 */
	public ArrayList<Product_TagBean> selectProduct_Tag(ArrayList<Product_TagBean> array) {

		String sql = "SELECT * FROM t_product_tag WHERE f_product_id in('";
		ArrayList<Product_TagBean> retarr = new ArrayList<Product_TagBean>();

		for (int i = 0; i < array.size(); i++) {
			sql += array.get(i).getProduct_id() + "','";
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
				retarr.add(new Product_TagBean(rs.getString("f_product_id"), rs
						.getString("f_tag_id")));
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
