package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.Contest_MusicBean;

public class Contest_MusicDao extends Dao {
	/**
	 * insertContest_Musicメソッド : Contest_Musicを追加する
	 * 
	 * @param Contest_Music
	 *            Contest_MusicBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertContest_Music(Contest_MusicBean contest_Music) {

		int ret = 0;
		String sql = "INSERT INTO t_contest_music VALUES(?,?,?,?,?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, contest_Music.getContest_id());
			ps.setString(2, contest_Music.getProduct_id());
			ps.setString(3, contest_Music.getContest_admin_id());
			ps.setInt(4, contest_Music.getContest_examination());
			ps.setString(5, contest_Music.getRecord_date());

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
	 * updateContest_Musicメソッド
	 * 
	 * @param contest_Music
	 *            Contest_MusicBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateContest_Music(Contest_MusicBean contest_Music) {

		int ret = 0;
		String sql = "UPDATE t_contest_music SET f_product_id=?,f_contest_admin_id=?,f_contest_examination=?,f_record_date=? WHERE f_contest_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, contest_Music.getProduct_id());
			ps.setString(2, contest_Music.getContest_admin_id());
			ps.setInt(3, contest_Music.getContest_examination());
			ps.setString(4, contest_Music.getRecord_date());
			ps.setString(5, contest_Music.getContest_id());
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
	 * deleteContest_Musicメソッド
	 * 
	 * @param contest_Music
	 *            Contest_MusicBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteContest_Music(Contest_MusicBean contest_Music) {

		int ret = 0;
		String sql = "DELETE FROM t_contest_music WHERE f_contest_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, contest_Music.getContest_id());
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
	 * selectContest_Musicメソッド
	 * 
	 * @param array
	 *            ArrayList<Contest_MusicBean> Contest_MusicBean
	 * @return retarr ArrayList<Contest_MusicBean> 検索結果
	 */
	public ArrayList<Contest_MusicBean> selectContest_Music(ArrayList<Contest_MusicBean> array) {

		String sql = "SELECT * FROM t_contest_Music WHERE f_contest_id in('";
		ArrayList<Contest_MusicBean> retarr = new ArrayList<Contest_MusicBean>();

		for (int i = 0; i < array.size(); i++) {
			sql += array.get(i).getContest_id() + "','";
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
				retarr.add(new Contest_MusicBean(rs.getString("f_contest_id"),
						rs.getString("f_product_id"), rs
								.getString("f_contest_admin_id"), rs
								.getInt("f_contest_examination"), rs
								.getString("f_record_date")));
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
