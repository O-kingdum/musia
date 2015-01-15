package jp.co.musia.okingdum;

public class Album {

	private String album_id;
	private String product_id;
	private String album_name;
	private String artist_name;
	
	/**
	 * 
	 * @param album_id
	 * @param product_id
	 * @param album_name
	 * @param artist_name
	 *
	 */
	public Album(String album_id, String product_id, String album_name,
			String artist_name) {
		this.album_id = album_id;
		this.product_id = product_id;
		this.album_name = album_name;
		this.artist_name = artist_name;
	}

	public String getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(String album_id) {
		this.album_id = album_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getArtist_name() {
		return artist_name;
	}

	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
}
