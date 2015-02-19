package jp.co.musia.okingdum.Bean;

public class Product_TagBean {
	private String product_id;
	private String tag_id;
	
	public Product_TagBean() {
		
	}
	
	public Product_TagBean(String product_id,String tag_id) {
		this.product_id = product_id;
		this.tag_id = tag_id;
	}
	
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getTag_id() {
		return tag_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
}
