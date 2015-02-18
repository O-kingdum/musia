package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.AdminBean;

public class AdminDao extends Dao {

	/**
	 * insertAdminメソッド : adminを追加する
	 * 
	 * @param admin
	 *            AdminBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertAdmin(AdminBean admin) {

		int ret = 0;
		String sql = "INSERT INTO t_admin VALUES(?, ?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, admin.getAdmin_id());
			ps.setString(2, admin.getAdmin_password());

			// クエリ発行
			ret = ps.executeUpdate();
			// エラーフラグ
			if (ret < 1) {
				ret = -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			ret = -1;

		} catch (Exception e) {
			e.printStackTrace();
			ret = -1;
		}

		return ret;
	}

	/**
	 * deleteAdminメソッド
	 * 
	 * @param admin
	 *            AdminBeanオブジェクト
	 * @param flg
	 *            boolen : true:完全削除/false:ソフトデリート
	 * @return 成功:1 失敗: 0以下
	 */
	public int deleteAdmin(AdminBean admin, boolean flg) {

		int ret = 0;
		String sql = "";

		if (flg) {
			sql = "UPDATE t_admin SEt f_delflg = 1;";
		} else {
			sql = "UPDATE t_admin SEt f_delflg = 1 WHERE f_admin_id ="
					+ admin.getAdmin_id() + ";";
		}

		try {
			// コネクション作成
			this.getConnection();
			// ステートメント作成
			st = con.createStatement();
			// クエリ発行
			ret = st.executeUpdate(sql);
			// エラーフラグ
			if (ret < 1) {
				ret = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ret = -1;
		} catch (Exception e) {
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}

	/**
	 * updateAdminメソッド
	 * 
	 * @param admin
	 *            AdminBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int updateAdmin(AdminBean admin) {

		int ret = 0;
		String sql = "UPDATE t_products SET f_genre_id=?,";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);
			ps.setString(1, admin.getAdmin_id());

			// クエリ発行
			ret = ps.executeUpdate();
			// エラーフラグ
			if (ret < 1) {
				ret = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ret = -1;

		} catch (Exception e) {
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}

	/**
	 * selectAdminメソッド 受け取ったAdminBeanオブジェクトのidからそれ以外の値を取得し、ArrayListに格納しリターンする
	 * 
	 * @param admin
	 *            AdminBeanオブジェクト
	 * @return 成功:ArrayListにAdminBeanオブジェクトを格納　失敗:nullのArrayList
	 */
	public AdminBean selectAdmin(AdminBean admin) {

		ArrayList<AdminBean> ret = new ArrayList<AdminBean>();
		String sql = "SELECT * FROM t_admin WHERE t_admin_id=?;";
		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);
			ps.setString(1, admin.getAdmin_id());

			// クエリ発行
			rs = ps.executeQuery();
			rs.next();

			admin.setAdmin_password(rs.getString("f_admin_password"));
			ret.add(admin);

		} catch (SQLException e) {
			e.printStackTrace();
			ret = null;

		} catch (Exception e) {
			e.printStackTrace();
			ret = null;
		}
		return admin;
	}

}
