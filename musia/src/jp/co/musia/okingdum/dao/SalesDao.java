package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.ProductsBean;
import jp.co.musia.okingdum.Bean.SalesBean;
import jp.co.musia.okingdum.Bean.UsersBean;

public class SalesDao extends Dao{

	public String getNextId() {
		
		String sql = "SELECT count(*) FROM t_sales;";
		String id_str = "";
		
		try {
			this.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				id_str = String.valueOf( rs.getInt("count(*)") + 1 );
				id_str = "S" + String.format("%1$06d", id_str);
			}
		} catch(SQLException e) {
			this.setErrflag(false);
		} finally {
			this.close();
		}
		return id_str;
	}
	
	public boolean insertSales(SalesBean sales, ArrayList<ProductsBean> products) {
		
		sales.setSale_id(this.getNextId());
		
		String sql = "INSERT INTO t_sales VALUES('" + sales.getSale_id() + "','" + sales.getUser_id() + "','" 
						+ sales.getSale_date() + "',0,'" + sales.getTotal_amount() + "');";
		// 保存件数
		int ret = 0;
		// フラグ設定
		this.setErrflag(true);
		
		if(products == null || products.size() == 0) {
			this.setMsg("商品がカートに登録されていません。");
			return false;
		}
		
		try {
			// コネクション生成
			this.getConnection();
			// オートコミット解除
			con.setAutoCommit(false);
			// ステートメント作成
			st = con.createStatement();
			// クエリ発行
			ret = st.executeUpdate(sql);
			
			if(ret > 0) {
				for(int i = 0; i < products.size(); i++) {
					// 売上詳細へ保存
					sql = "INSERT INTO t_sale_details VALUES('" + sales.getSale_id() + "','" + products.get(i).getProduct_id() + "');";
					// クエリ発行
					ret = st.executeUpdate(sql);
					// 保存された件数
					if(ret == 0) {
						throw new SQLException();
					}
				}
				// コミット
				con.commit();
			} else {
				this.setErrflag(false);
				this.setMsg("データベースに保存されませんでした。");
			}
		} catch(SQLException e) {
			
			try {
				// ロールバック
				con.rollback();
			
			} catch (SQLException e1) {
				// ロールバック失敗
				this.setErrflag(false);
				this.setMsg("データベースエラーです。" + e1.getMessage());
			}
		
			this.setErrflag(false);
			this.setMsg("データベースエラーです。" + e.getMessage());
		
		} finally {
			this.close();
		}
		
		return this.getErrflag();
	}
	
	public ArrayList<ProductsBean> selectSales(UsersBean user) {
		
		String sql = "SELECT p.f_product_id as product_id, p.f_product_name as product_name,"
					+ "s1.f_sale_date as sale_date FROM t_sales s1 join t_sale_details s2 on s1.f_sale_id = s2.f_sale_id "
					+ "join t_products on s2.f_product_id = p.f_product_id WHERE p.f_user_id='" + user.getUser_id() +"';";
		
		ArrayList<ProductsBean> retarr = new ArrayList<ProductsBean>();
		ProductsBean product = new ProductsBean();
		
		try {
			// コネクション生成
			this.getConnection();
			// ステートメント作成
			st = con.createStatement();
			// クエリ発行
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				product.setProduct_id(rs.getString("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setSale_date(rs.getString("sale_date"));
				
				retarr.add( product );
			}
			
		} catch(SQLException e) {
			this.setErrflag(false);
			this.setMsg(e.getMessage());
		} finally {
			this.close();
		}
		return retarr;
	}
}
