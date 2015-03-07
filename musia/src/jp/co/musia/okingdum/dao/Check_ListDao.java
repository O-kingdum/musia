package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.Check_ListBean;

public class Check_ListDao extends Dao {
	/**
	 * insertCheckListメソッド : check_Listを追加する
	 * 
	 * @param check_List
	 *            Check_ListBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertCheckList(Check_ListBean check_List) {

		int ret = 0;
		String sql = "INSERT INTO t_check_list VALUES(?,?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, check_List.getList_id());
			ps.setString(2, check_List.getCheck_list());

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
	 * updateCheck_Listメソッド
	 * 
	 * @param check_List
	 *            Check_ListBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateCheck_List(Check_ListBean check_List) {

		int ret = 0;
		String sql = "UPDATE t_check_list SET f_check_List=? WHERE f_list_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, check_List.getCheck_list());
			ps.setString(2, check_List.getList_id());
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
	 * deleteCheck_Listメソッド
	 * 
	 * @param check_List
	 *            Check_ListBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteCheck_List(Check_ListBean check_List) {

		int ret = 0;
		String sql = "DELETE FROM t_check_list WHERE f_list_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, check_List.getList_id());
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
	 * selectCheck_Listメソッド
	 * 
	 * @param array
	 *            ArrayList<Check_ListBean> Check_ListBean
	 * @return retarr ArrayList<Check_ListBean> 検索結果
	 */
	public ArrayList<Check_ListBean> selectCheck_List(ArrayList<Check_ListBean> array) {

		String sql = "SELECT t_check_list WHERE f_list_id in('";
		ArrayList<Check_ListBean> retarr = new ArrayList<Check_ListBean>();

		for (int i = 0; i < array.size(); i++) {
			sql += array.get(i).getList_id() + "','";
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
				retarr.add(new Check_ListBean(rs.getString("f_list_id"), rs
						.getString("f_check_List")));
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
