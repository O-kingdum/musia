package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.TagBean;

/**
 * 
 * @author watanabe.yuta
 * 
 */
public class TagDao extends Dao {

	/**
	 * insertTagメソッド
	 * 
	 * @param tag
	 *            TagBean: タグオブジェクト
	 * @return ret int: -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int insertTag(TagBean tag) {

		int ret = 0;
		String sql = "INSERT INTO t_tag values(?,?);";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, tag.getTag_id());
			ps.setString(2, tag.getTag_name());
			// クエリ発行
			ret = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
			ret = -1;
		}
		return ret;
	}

	/**
	 * updateTagメソッド
	 * 
	 * @param tag
	 *            TagBean: タグオブジェクト
	 * @return ret -1:異常終了 1:更新成功 0:更新失敗
	 */
	public int updateTag(TagBean tag) {

		int ret = 0;
		String sql = "UPDATE t_tag SET f_tag_name=? WHERE f_tag_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, tag.getTag_name());
			ps.setString(2, tag.getTag_id());
			// クエリ発行
			ret = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
			ret = -1;
		}
		return ret;
	}

	/**
	 * deleteTagメソッド
	 * 
	 * @param tag
	 *            TagBean: タグオブジェクト
	 * @return ret -1:異常終了 1:更新成功 0:更新失敗
	 */
	public int deleteTag(TagBean tag) {

		int ret = 0;
		String sql = "DELETE FROM t_tag WHERE f_tag_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, tag.getTag_id());
			// クエリ発行
			ret = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
			ret = -1;
		}
		return ret;
	}

	/**
	 * selectTagメソッド
	 * 
	 * @param array
	 *            ArrayList<TagBean> TagBean
	 * @return retarr ArrayList<TagBean> 検索結果
	 */
	public ArrayList<TagBean> TagBean(ArrayList<TagBean> array) {

		String sql = "SELECT f_tag_id, f_tag_name FROM t_tag WHERE f_tag_id in('";
		ArrayList<TagBean> retarr = new ArrayList<TagBean>();

		for (int i = 0; i < array.size(); i++) {
			sql += array.get(i).getTag_id() + "','";
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
				retarr.add(new TagBean(rs.getString("f_tag_id"), rs
						.getString("f_tag_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// エラーメッセージをmsgに格納
			setMsg(e.getMessage());
		}
		return retarr;
	}
}
