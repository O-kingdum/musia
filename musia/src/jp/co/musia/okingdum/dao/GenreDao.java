package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.GenreBean;

/**
 * 
 * @author watanabe.yuta
 * 
 */
public class GenreDao extends Dao {

	public String getNextId() {
		
		String sql = "SELECT count(*) from t_genre;";
		String id_str = "";
		
		try {
			// コネクション生成
			this.getConnection();
			// ステートメント作成
			st = this.con.createStatement();
			// クエリ発行
			rs = st.executeQuery(sql);
			
			if( rs.next() ) {
				id_str = String.valueOf( rs.getInt("count(*)") + 1 );
				
				for( int i = id_str.length() ; i <= 5; i++ ) {
					id_str = "0" + id_str;
				}
				id_str = "GE" + id_str;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return id_str;
	}
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
	 *            ArrayList<GenreBean> GenreBean
	 * @return retarr ArrayList<GenreBean> 検索結果
	 */
	public ArrayList<GenreBean> selectGenre(ArrayList<GenreBean> array) {

		String sql = "SELECT f_genre_id, f_genre_name FROM t_genre WHERE f_genre_id in('";
		ArrayList<GenreBean> retarr = new ArrayList<GenreBean>();
		
		if(array != null && array.size() > 0) {
			for (int i = 0; i < array.size(); i++) {
				sql += array.get(i).getGenre_id() + "','";
			}
			sql += "');";
		} else {
			sql = "SELECT f_genre_id, f_genre_name FROM t_genre;";
		}
		try {
			// コネクション生成
			this.getConnection();
			// ステートメント
			st = con.createStatement();
			// クエリ発行
			rs = st.executeQuery(sql);

			while (rs.next()) {
				retarr.add(new GenreBean(rs.getString("f_genre_id"), rs
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
