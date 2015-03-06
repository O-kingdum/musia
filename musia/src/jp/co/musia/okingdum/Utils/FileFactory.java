package jp.co.musia.okingdum.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jp.co.musia.okingdum.Bean.ProductsBean;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileFactory {

	private DiskFileItemFactory factory;
	private ServletFileUpload uploader;
	private ProductsBean products;
	private String path;
	private String msg;
	
	/**
	 * const
	 */
	public FileFactory() {
		factory = new DiskFileItemFactory();
		products = new ProductsBean();
	}
	
	/**
	 * factory path setter 
	 * @param String: path
	 */
	public void setFactoryPath(String path) {
		this.path = path;
	}
	
	/**
	 * factory path getter
	 * @return String: path
	 */
	public String getFactoryPath() {
		return this.path;
	}
	
	/**
	 * products getter
	 * @return ProductsBean: products
	 */
	public ProductsBean getProducts() {
		return this.products;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * getSuffix メソッド
	 * 
	 * @param fileName String: ファイル名
	 * @return fileName String: ファイル拡張子　null:ファイルなし
	 */
	public String getSuffix( String fileName ) {
		
		if (fileName == null)
	        return null;
	    
		int point = fileName.lastIndexOf(".");
	    
	    if (point != -1) {
	        return fileName.substring(point + 1);
	    }
	    
	    return fileName;
	}
	
	/**
	 * saveFileFactory メソッド
	 * 
	 * @param request : ファイル/商品情報
	 * @return boolean : true:成功  false:失敗
	 */
	public boolean saveFileFacotry(HttpServletRequest request, String path) {
		
		File file = new File( path );
		// 一時保存先フォルダ指定
		factory.setRepository( file );
		// バッファサイズ
		factory.setSizeThreshold( 1024 );
		//
		uploader = new ServletFileUpload( factory );
		// ファイルサイズ（無限）
		uploader.setSizeMax( -1 );
		// エンコーディング
		uploader.setHeaderEncoding("UTF-8");
		// フラグ
		boolean flg = true;
		
		try {
			// アップロードされたファイル情報をFileItemオブジェクトのリストとして取得
		    List<FileItem> objLst = uploader.parseRequest( request );
		    Iterator<FileItem> objItr = objLst.iterator();
		    
		    while(objItr.hasNext()) {

		    	FileItem objFi = ( FileItem )objItr.next();

		    	if(!objFi.isFormField()) {

		    		// アップロードファイルの元ファイル名を取得
		    		String strNam = objFi.getName();

		    		if( strNam != null && !strNam.isEmpty() ) {
		    			strNam = ( new File( strNam ) ).getName();
		    			objFi.write( new File( path + "/" + strNam ) );
		    			/* ディレクトリパス */
			    		products.setDirectory_path( "music_file/" + strNam );
			    		/* imgパス */
			    		products.setImg_path( "music_img/" + strNam );
			    		/* ファイル種別 */
			    		products.setFile_type( this.getSuffix( strNam ) );
		    		}
		       	} else if( objFi.isFormField() ) {
		       		
		       		/* 商品名 */
		       		if( "product_name".equals( objFi.getFieldName() ) ) {
		       			products.setProduct_name( objFi.getString("UTF-8") );
		       		}
		       		/* アーティスト名 */
		       		if( "artist_name".equals( objFi.getFieldName() ) ) {
		       			products.setArtist_name( objFi.getString("UTF-8") );
		       		}
		       		/* 価格 */
		       		if( "price".equals( objFi.getFieldName() ) ) {
		       			products.setPrice( Integer.parseInt( objFi.getString() ) );
		       		}
		       		/* 商品詳細 */
		       		if( "product_details".equals( objFi.getFieldName() ) ) {
		       			products.setProduct_details( objFi.getString("UTF-8") );
		       		}
		       		/* ジャンルID */
		       		if( "genre_id".equals( objFi.getFieldName() ) ) {
		       			products.setGenre_id( objFi.getString() );
		       		}
		       		/* 曲尺 */
		       		if( "measure".equals( objFi.getFieldName() ) ) {
		       			products.setMeasure( objFi.getString() );
		       		}
		       		/* 備考 */
		       		if( "remarks".equals( objFi.getFieldName() ) ) {
		       			products.setRemarks( objFi.getString("UTF-8") );
		       		}
		       	}
		    }

		} catch( FileUploadException e ) {
			flg = false;
			this.setMsg(e.getMessage());
		} catch( Exception e ) {
			flg = false;
			this.setMsg(e.getMessage());
		}
		
		return flg;
	}
}
