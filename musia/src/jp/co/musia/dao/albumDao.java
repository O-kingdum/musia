package jp.co.musia.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.AlbumBean;

public class albumDao extends Dao {

	/**
	 * insertAlbumメソッド : albumを追加する
	 * 
	 * @param album
	 *            AlbumBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertAlbum(AlbumBean album) {

		int ret = 0;
		String sql = "INSERT INTO t_album VALUES(?, ?, ?, ?, ?)";

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
		}

		return ret;
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
		}
		return ret;
	}

	/**
	 * updateAlbumメソッド
	 * 
	 * @param album
	 *            AlbumBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int updateAlbum(AlbumBean album) {

		int ret = 0;
		String sql = "UPDATE t_album SET f_album_id=?,";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);
			ps.setString(1, album.getAlbum_id());

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
	public AlbumBean selectAlbum(AlbumBean album) {

		ArrayList<AlbumBean> ret = new ArrayList<AlbumBean>();
		String sql = "SELECT * FROM t_admin WHERE t_admin_id=?;";
		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);
			ps.setString(1, album.getAlbum_id());

			// クエリ発行
			rs = ps.executeQuery();
			rs.next();

			//albumの内容をsetする
			//admin.setAdmin_password(rs.getString("f_admin_password"));
			ret.add(album);

		} catch (SQLException e) {
			e.printStackTrace();
			ret = null;

		} catch (Exception e) {
			e.printStackTrace();
			ret = null;
		}
		return album;
	}

}
