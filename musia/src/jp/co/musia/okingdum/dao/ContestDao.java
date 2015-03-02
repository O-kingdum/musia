package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.ContestBean;

public class ContestDao extends Dao {
	/**
	 * insertContestメソッド : Contestを追加する
	 * 
	 * @param contest
	 *            ContestBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertContest(ContestBean contest) {

		int ret = 0;
		String sql = "INSERT INTO t_contest VALUES(?,?,?,?,?,?,?,?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, contest.getContest_id());
			ps.setString(2, contest.getContest_name());
			ps.setString(3, contest.getEnterprise_name());
			ps.setString(4, contest.getStart_date());
			ps.setString(5, contest.getEnd_date());
			ps.setString(6, contest.getMembers());
			ps.setString(7, contest.getRequirements());
			ps.setString(8, contest.getRemarks());

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
	 * updateContestメソッド
	 * 
	 * @param contest
	 *            ContestBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateContest(ContestBean contest) {

		int ret = 0;
		String sql = "UPDATE t_contest SET f_contest_name=?,f_enterprise_name=?,f_start_date=?,f_end_date=?,f_members=?,f_requirements=?,f_remarks=? WHERE f_contest_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, contest.getContest_name());
			ps.setString(2, contest.getEnterprise_name());
			ps.setString(3, contest.getStart_date());
			ps.setString(4, contest.getEnd_date());
			ps.setString(5, contest.getMembers());
			ps.setString(6, contest.getRequirements());
			ps.setString(7, contest.getRemarks());
			ps.setString(8, contest.getContest_id());
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
	 * deleteContestメソッド
	 * 
	 * @param contest
	 *            ContestBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteContest(ContestBean contest) {

		int ret = 0;
		String sql = "DELETE FROM t_contest WHERE f_contest_id=?;";

		try {
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, contest.getContest_id());
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
	 * selectContestメソッド
	 * 
	 * @param array
	 *            ArrayList<ContestBean> ContestBean
	 * @return retarr ArrayList<ContestBean> 検索結果
	 */
	public ArrayList<ContestBean> selectContest(ArrayList<ContestBean> array) {

		String sql = "SELECT t_contest WHERE f_contest_id in('";
		ArrayList<ContestBean> retarr = new ArrayList<ContestBean>();

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
				retarr.add(new ContestBean(rs.getString("f_contest_id"), rs
						.getString("f_contest_name"), rs
						.getString("f_enterprise_name"), rs
						.getString("f_start_date"), rs.getString("f_end_date"),
						rs.getString("f_members"), rs
								.getString("f_requirements"), rs
								.getString("f_remarks")));
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
