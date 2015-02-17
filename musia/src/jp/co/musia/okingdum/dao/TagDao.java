package jp.co.musia.okingdum.dao;

import java.sql.SQLException;

import jp.co.musia.okingdum.TagBean;

public class TagDao extends Dao {

	/**
	 * insertTag
	 * 
	 * @param tag TagBean: タグオブジェクト
	 * @return ret int: -1:異常終了  0:更新失敗  1:更新成功
	 */
	public int insertTag(TagBean tag) {
	
		int ret = 0;
		String sql = "INSERT INTO t_tag values(?,?);";
		
		try
		{
			// コネクション生成
			this.getConnection();
			// プリコンパイル
			ps = this.con.prepareStatement(sql);
			// バインドセット
			ps.setString(1, tag.getTag_id());
			ps.setString(2, tag.getTag_name());
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
	
	public int updateTag() {
		
	}
	
	public int deleteTag() {
		
	}
	
	public TagBean selectTag() {
		
	}
}
