package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.ProductsBean;

/**
 * 
 * @author watanabe.yuta
 * 
 */
public class ProductsDao extends Dao {

	/**
	 * insertProductsメソッド
	 * 
	 * @param products
	 *            ProductsBean
	 * @return ret int : -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int insertProducts(ProductsBean products) {

		String get_id_sql = "SELECT count(*) FROM t_products WHERE f_products_id LIKE '" + products.getProduct_id() + "%';";
		
		try {
			// コネクション作成
			this.getConnection();
			// ステートメント作成
			st = con.createStatement();
			// クエリ発行
			rs = st.executeQuery(get_id_sql);
			
			if(rs.next()) {
				String id_str = String.valueOf( rs.getInt("count(*)") + 1 );
				
				for( int i = id_str.length() ; i <= 5; i++ ) {
					id_str = "0" + id_str;
				}
				
				id_str = products.getProduct_id() + id_str;
				products.setProduct_id(id_str);
			}
			
		} catch(SQLException e) {
			setMsg(e.getMessage());
		}
		finally {
			this.close();
		}
		
		int ret = 0;
		String sql = "INSERT INTO t_products values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,?,0);";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, products.getProduct_id());
			ps.setString(2, products.getUser_id());
			ps.setString(3, products.getProduct_name());
			ps.setString(4, products.getArtist_name());
			ps.setInt(5, products.getPrice());
			ps.setString(6, products.getProduct_details());
			ps.setString(7, products.getGenre_id());
			ps.setString(8, products.getMeasure());
			ps.setString(9, products.getFile_type());
			ps.setInt(10, products.getFile_size());
			ps.setString(11, products.getDirectory_path());
			ps.setString(12, products.getImg_path());
			ps.setString(13, products.getPosted_date());
			ps.setString(14, products.getRemarks());
			ps.setInt(15, products.getExamination());
			ps.setString(16, products.getProduct_admin_id());
			ps.setInt(17, products.getDelflg());

			// クエリ発行
			ret = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
			ret = -1;
		} finally {
			// クローズ処理
			this.close();
		}
		return ret;
	}

	/**
	 * deleteProductsメソッド
	 * 
	 * @param products
	 *            : product_id
	 * @param flg
	 *            boolen : true:完全削除/false:ソフトデリート
	 * @return ret int : -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteProducts(ProductsBean products, boolean flg) {

		int ret = 0;
		String sql = "";

		if (flg) {
			// 完全消去
			sql = "DELETE FROM t_products WHERE f_product_id="
					+ products.getProduct_id() + ";";
		} else {
			// ソフトデリート
			sql = "UPDATE t_products SET f_delflg = 1" + " WHERE f_product_id="
					+ products.getProduct_id() + ";";
		}

		try {
			// コネクション作成
			this.getConnection();
			// ステートメント作成
			st = con.createStatement();
			// クエリ発行
			ret = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
			ret = -1;
		} finally {
			// 　クローズ処理
			this.close();
		}
		return ret;
	}

	/**
	 * updateProductsメソッド
	 * 
	 * @param products
	 *            ProductsBean
	 * @return
	 */
	public int updateProducts(ProductsBean products) {

		int ret = 0;
		String sql = "UPDATE t_products SET f_price=?,f_product_details=?,f_measure=?,"
				+ "f_file_type=?,f_file_size=?,f_remarks=? WHERE f_product_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);
			// クエリ発行
			ret = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
			ret = -1;
		} finally {
			// クローズ処理
			this.close();
		}
		return ret;
	}

	/**
	 * selectProductsメソッド
	 * 
	 * @param array
	 *            ArrayList<Object> : ProductsBean
	 * @return retarr ArrayList<Object> : ProductsBean
	 */
	public ArrayList<Object> selectProducts(ArrayList<Object> array) {

		String sql = "SELECT * FROM t_products WHERE t_product_id in('";
		ArrayList<Object> retarr = new ArrayList<Object>();

		for (int i = 0; i < array.size(); i++) {
			sql += ((ProductsBean) array.get(i)).getProduct_id() + "','";
		}
		sql += "');";

		try {
			// コネクション生成
			this.getConnection();
			// ステートメント作成
			st = con.createStatement();
			// クエリ発行
			rs = st.executeQuery(sql);

			while (rs.next()) {
				retarr.add(new ProductsBean(rs.getString("f_product_id"), rs
						.getString("f_user_id"), rs.getString("product_name"),
						rs.getString("artist_name"), rs.getInt("f_price"), rs
								.getString("f_product_details"), rs
								.getString("f_genre_id"), rs
								.getString("f_measure"), rs
								.getString("f_file_type"), rs
								.getInt("f_file_size"), rs
								.getString("f_directory_path"), rs
								.getString("f_img_path"), rs
								.getString("f_posted_date"), rs
								.getString("f_remarks"), rs
								.getInt("f_examination"), rs
								.getString("f_product_admin_id"), rs
								.getInt("f_delflg")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
		} finally {
			this.close();
		}
		return retarr;
	}
}
