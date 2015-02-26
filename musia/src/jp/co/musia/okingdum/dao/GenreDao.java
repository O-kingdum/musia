package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.GenreBean;
import jp.co.musia.okingdum.Bean.TagBean;

/**
 * 
 * @author watanabe.yuta
 * 
 */
public class GenreDao extends Dao {

	/**
	 * insertGenreメソッド
	 * 
	 * @param genre
	 *            GenreBean
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int insertGenre(GenreBean genre) {

		int ret = 0;
		String sql = "INSERT INTO t_genre values(?,?);";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, genre.getGenre_id());
			ps.setString(2, genre.getGenre_name());
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
	 * updateGenreメソッド
	 * 
	 * @param genre
	 *            GenreBean
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateGenre(GenreBean genre) {

		int ret = 0;
		String sql = "UPDATE t_genre SET f_genre_name=? WHERE f_genre_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, genre.getGenre_name());
			ps.setString(2, genre.getGenre_id());
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
	 * deleteGenreメソッド
	 * 
	 * @param genre
	 *            GenreBean
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteGenre(GenreBean genre) {

		int ret = 0;
		String sql = "DELETE FROM t_genre WHERE f_genre_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, genre.getGenre_id());
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
	 * selectGenreメソッド
	 * 
	 * @param array
	 *            ArrayList<Object> GenreBean
	 * @return retarr ArrayList<Object> 検索結果
	 */
	public ArrayList<Object> selectGenre(ArrayList<Object> array) {

		String sql = "SELECT f_genre_id, f_genre_name FROM t_genre WHERE f_genre_id in('";
		ArrayList<Object> retarr = new ArrayList<Object>();

		for (int i = 0; i < array.size(); i++) {
			sql += ((GenreBean) array.get(i)).getGenre_id() + "','";
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
				retarr.add(new TagBean(rs.getString("f_genre_id"), rs
						.getString("f_genre_name")));
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
