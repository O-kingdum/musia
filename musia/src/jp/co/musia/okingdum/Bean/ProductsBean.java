package jp.co.musia.okingdum.Bean;

public class ProductsBean {

	private String product_id;
	private String user_id;
	private String product_name;
	private String artist_name;
	private int price;
	private String product_details;
	private String genre_id;
	private String measure;
	private String file_type;
	private int file_size;
	private String directory_path;
	private String img_path;
	private String posted_date;
	private String remarks;
	private int examination;
	private String product_admin_id;
	private int delflg;
	
	public ProductsBean(String product_id, String user_id, String product_name,
			String artist_name, int price, String product_details,
			String genre_id, String measure, String file_type, int file_size,
			String directory_path, String img_path, String posted_date,
			String remarks, int examination, String product_admin_id, int delflg) {
		super();
		this.product_id = product_id;
		this.user_id = user_id;
		this.product_name = product_name;
		this.artist_name = artist_name;
		this.price = price;
		this.product_details = product_details;
		this.genre_id = genre_id;
		this.measure = measure;
		this.file_type = file_type;
		this.file_size = file_size;
		this.directory_path = directory_path;
		this.img_path = img_path;
		this.posted_date = posted_date;
		this.remarks = remarks;
		this.examination = examination;
		this.product_admin_id = product_admin_id;
		this.delflg = delflg;
	}
	public ProductsBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProduct_details() {
		return product_details;
	}
	public void setProduct_details(String product_details) {
		this.product_details = product_details;
	}
	public String getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public String getDirectory_path() {
		return directory_path;
	}
	public void setDirectory_path(String directory_path) {
		this.directory_path = directory_path;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getPosted_date() {
		return posted_date;
	}
	public void setPosted_date(String posted_date) {
		this.posted_date = posted_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getExamination() {
		return examination;
	}
	public void setExamination(int examination) {
		this.examination = examination;
	}
	public String getProduct_admin_id() {
		return product_admin_id;
	}
	public void setProduct_admin_id(String product_admin_id) {
		this.product_admin_id = product_admin_id;
	}
	public int getDelflg() {
		return delflg;
	}
	public void setDelflg(int delflg) {
		this.delflg = delflg;
	}
}
