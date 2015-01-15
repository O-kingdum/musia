package jp.co.musia.okingdum;

public class Tag {
	
	private String tag_id;
	private String tag_name;
	
	/**
	 * 
	 * @param tag_id : タグID
	 * @param tag_name : タグ名
	 *
	 */
	public Tag(String tag_id, String tag_name) {
		this.tag_id = tag_id;
		this.tag_name = tag_name;
	}

	public String getTag_id() {
		return tag_id;
	}

	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
}
