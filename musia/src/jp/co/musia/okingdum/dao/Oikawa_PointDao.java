package jp.co.musia.okingdum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.musia.okingdum.Bean.Oikawa_PointBean;

public class Oikawa_PointDao extends Dao{
	/**
	 * insertOikawa_Pointメソッド
	 * 
	 * @param oikawa_point
	 *            Oikawa_PointBeanオブジェクト
	 * @return 成功:1 失敗:-1
	 */
	public int insertOikawa_Point(Oikawa_PointBean oikawa_point) {

		int ret = 0;
		String sql = "INSERT INTO t_oikawa_point VALUES(?,?,?,?)";

		try {
			// コネクション作成
			this.getConnection();
			// プリコンパイル
			ps = con.prepareStatement(sql);

			ps.setString(1, oikawa_point.getUser_id());
			ps.setInt(2, oikawa_point.getOp());
			ps.setString(3, oikawa_point.getOp_date());
			ps.setInt(4, oikawa_point.getOp_flg());

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
	 * updateOikawa_Pointメソッド
	 * 
	 * @param oikawa_point Oikawa_PointBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int updateOikawa_Point(Oikawa_PointBean oikawa_point) {
		
		int ret = 0;
		String sql = "UPDATE t_oikawa_point SET f_op=?,f_op_date=?,f_op_flg=? WHERE f_user_id=?;";
		
		try
		{
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setInt(1, oikawa_point.getOp());
			ps.setString(2, oikawa_point.getOp_date());
			ps.setInt(3, oikawa_point.getOp_flg());
			ps.setString(4, oikawa_point.getUser_id());
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
	 * deleteOikawa_Pointメソッド
	 * 
	 * @param oikawa_point Oikawa_PointBeanオブジェクト
	 * @return ret -1:異常終了 0:更新失敗 1:更新成功
	 */
	public int deleteOikawa_Point(Oikawa_PointBean oikawa_point) {
		
		int ret = 0;
		String sql = "DELETE FROM t_oikawa_point WHERE f_user_id=?;";
		
		try
		{
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, oikawa_point.getUser_id());
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
	 * selectOikawa_Pointメソッド
	 * 
	 * @param array ArrayList<Object> Oikawa_PointBean
	 * @return retarr ArrayList<Object> 検索結果
	 */
	public ArrayList<Object> selectOikawa_Point(ArrayList<Object> array) {
		
		String sql = "SELECT t_oikawa_point WHERE f_user_id in('";
		ArrayList<Object> retarr = new ArrayList<Object>();
		
		for(int i = 0; i < array.size(); i++) {
			sql += ((Oikawa_PointBean)array.get(i)).getUser_id() + "','";
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
				retarr.add(new Oikawa_PointBean(
						rs.getString("f_user_id"),
						rs.getInt("f_op"),
						rs.getString("f_op_date"),
						rs.getInt("f_op_flg")
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
