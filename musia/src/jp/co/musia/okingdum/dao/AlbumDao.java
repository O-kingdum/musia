package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.AlbumBean;

public class AlbumDao extends Dao {
	/**
	 * insertAlbumメソッド : albumを追加する
	 * 
	 * @param album
	 *            AlbumBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	@SuppressWarnings("finally")
	public int insertAlbum(AlbumBean album) {

		int ret = 0;
		String sql = "INSERT INTO t_album VALUES(?,?,?,?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, album.getAlbum_id());
			ps.setString(2, album.getProduct_id());
			ps.setString(3, album.getAlbum_name());
			ps.setString(4, album.getArtist_name());

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
		} finally {
			this.close();
			return ret;
		}
	}

	/**
	 * deleteAlbumメソッド
	 * 
	 * @param album
	 *            AlbumBeanオブジェクト
	 * @param flg
	 *            boolen : true:完全削除/false:ソフトデリート
	 * @return 成功:1 失敗: 0以下
	 */
	@SuppressWarnings("finally")
	public int deleteAlbum(AlbumBean album, boolean flg) {

		int ret = 0;
		String sql = "";

		if (flg) {
			sql = "UPDATE t_album SET f_delflg = 1;";
		} else {
			sql = "UPDATE t_album SET f_delflg = 1 WHERE f_album_id ="
					+ album.getAlbum_id() + ";";
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
		} finally {
			this.close();
			return ret;
		}
	}

	/**
	 * updateAlbumメソッド
	 * 
	 * @param album
	 *            AlbumBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	@SuppressWarnings("finally")
	public int updateAlbum(AlbumBean album) {

		int ret = 0;
		String sql = "UPDATE t_album SET f_album_id=?,f_product_id=?, f_album_name=?,f_artist_name=? WHERE f_album_id=?;";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);
			ps.setString(1, album.getAlbum_id());
			ps.setString(2, album.getProduct_id());
			ps.setString(3, album.getAlbum_name());
			ps.setString(4, album.getArtist_name());
			ps.setString(5, album.getAlbum_id());

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
		} finally {
			this.close();
			return ret;
		}
	}

	/**
	 * selectAlbumメソッド
	 * 
	 * @param array
	 * @return 成功:ArrayListにオブジェクトを格納　失敗:nullのArrayList
	 */
	@SuppressWarnings("finally")
	public ArrayList<Object> selectAlbum(ArrayList<Object> array) {

		ArrayList<Object> retarr = new ArrayList<Object>();
		String sql = "SELECT * FROM t_album WHERE f_delflg=0 and f_album_id in('";

		for (int i = 0; i < array.size(); i++) {
			sql += ((AlbumBean) array.get(i)).getAlbum_id() + "','";
		}
		sql += "');";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);
			// クエリ発行
			rs = ps.executeQuery();
			while (rs.next()) {
				retarr.add(new AlbumBean(
						rs.getString("f_album_id"), 
						rs.getString("f_product_id"), 
						rs.getString("f_album_name"), 
						rs.getString("f_artist_name")
				));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			retarr = null;

		} catch (Exception e) {
			e.printStackTrace();
			retarr = null;
		} finally {
			this.close();
			return retarr;
		}
	}
}
