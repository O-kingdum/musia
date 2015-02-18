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

	/**
	 * insertGenreメソッド
	 * 
	 * @param genre GenreBean
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int insertGenre(GenreBean genre) {
		
		int ret = 0;
		String sql = "INSERT INTO t_genre values(?,?);";
		
		try
		{
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, genre.getGenre_id());
			ps.setString(2, genre.getGenre_name());
			// クエリ発行
			ret = ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	/**
	 * updateGenreメソッド
	 * 
	 * @param genre GenreBean
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateGenre(GenreBean genre) {
		
		int ret = 0;
		String sql = "UPDATE t_genre SET f_genre_name=? WHERE f_genre_id=?;";
		
		try
		{
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, genre.getGenre_name());
			ps.setString(2, genre.getGenre_id());
			// クエリ発行
			ret = ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	public int deleteGenre(GenreBean genre) {
		
	}
	
	public ArrayList<Object> selectGenre(ArrayList<Object> array) {
		
	}

}
