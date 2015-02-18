package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.ProductsBean;

/**
 * 
 * @author watanabe.yuta
 *
 */
public class ProductsDao extends Dao{

	/* 2/4途中 */
	@SuppressWarnings("finally")
	public int insertProducts(ProductsBean products) {
		
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
			ps.setString(16, products.getProduct_admin_id());
			ps.setInt(17, products.getDelflg());
		
			// クエリ発行
			ret = ps.executeUpdate();
			// エラーフラグ
			if(ret < 1) {
				ret = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
			return ret;
		}
	}
	/**
	 * deleteProductsメソッド
	 * 
	 * @param products : product_id
	 * @param flg boolen : true:完全削除/false:ソフトデリート
	 * @return ret : -1~0:異常終了　0以上:正常終了
	 */
	@SuppressWarnings("finally")
	public int deleteProducts(ProductsBean products, boolean flg) {
		
		int ret = 0;
		String sql = "";
		
		if(flg) {
			// 完全消去
			sql = "DELETE FROM t_products WHERE f_product_id="
					+ products.getProduct_id() +";";
		} else {
			// ソフトデリート
			sql = "UPDATE t_products SET f_delflg = 1"
					+ " WHERE f_product_id="+ products.getProduct_id() +";";
		}
		
		try {
			// コネクション作成
			this.getConnection();
			// ステートメント作成
			st = con.createStatement();
			// クエリ発行
			ret = st.executeUpdate(sql);
			// エラーフラグ
			if(ret < 1) {
				ret = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
			return ret;
		}
	}
	
	public int updateProducts(ProductsBean products) {
		
		String sql = "UPDATE t_products SET f_genre_id=?,";
		
		
		return 0;
	}
	
	public ProductsBean selectProducts(ProductsBean products) {
		
		String sql = "SELECT * FROM t_products WHERE t_product_id=?;";
		
		
		
		return null;
	}
}
