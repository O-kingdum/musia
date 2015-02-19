package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.Contest_CheckBean;

public class Contest_CheckDao extends Dao{
	/**
	 * insertContest_Checkメソッド
	 * 
	 * @param contest_Check
	 *            Contest_CheckBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertContest_Check(Contest_CheckBean contest_Check) {

		int ret = 0;
		String sql = "INSERT INTO t_contest_check VALUES(?,?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, contest_Check.getContest_id());
			ps.setString(2, contest_Check.getList_id());

			// クエリ発行
			ret = ps.executeUpdate();
			// エラーフラグ
			if (ret < 1) {
				ret = -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			ret = -1;
		} finally {
			// クローズ
			this.close();
		}
		return ret;
	}
	
	/**
	 * updateContest_Checkメソッド
	 * 
	 * @param contest_Check Contest_CheckBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateContest_Check(Contest_CheckBean contest_Check) {
		
		int ret = 0;
		String sql = "UPDATE t_contest_check SET f_list_id=? WHERE f_contest_id=?;";
		
		try
		{
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, contest_Check.getList_id());
			ps.setString(2, contest_Check.getContest_id());
			// クエリ発行
			ret = ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			ret = -1;
		}
		finally
		{
			// クローズ
			this.close();
		}
		return ret;
	}
	
	/**
	 * deleteContest_Checkメソッド
	 * 
	 * @param contest_Check Contest_CheckBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteContest_Check(Contest_CheckBean contest_Check) {
		
		int ret = 0;
		String sql = "DELETE FROM t_contest_check WHERE f_contest_id=?;";
		
		try
		{
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, contest_Check.getContest_id());
			// クエリ発行
			ret = ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			ret = -1;
		}
		finally
		{
			// クローズ
			this.close();
		}
		return ret;
	}
	
	/**
	 * selectContest_Checkメソッド
	 * 
	 * @param array ArrayList<Object> Contest_CheckBean
	 * @return retarr ArrayList<Object> 検索結果
	 */
	public ArrayList<Object> selectContest_Check(ArrayList<Object> array) {
		
		String sql = "SELECT t_contest_check WHERE f_contest_id in('";
		ArrayList<Object> retarr = new ArrayList<Object>();
		
		for(int i = 0; i < array.size(); i++) {
			sql += ((Contest_CheckBean)array.get(i)).getContest_id() + "','";
		}
		sql += "');";
		
		try
		{
			// コネクション生成
			this.getConnection();
			// ステートメント
			st = con.createStatement();
			// クエリ発行
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				retarr.add(new Contest_CheckBean(
						rs.getString("f_contest_id"),
						rs.getString("f_list_id")
						)
				);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// クローズ
			this.close();
		}
		return retarr;
	}
}