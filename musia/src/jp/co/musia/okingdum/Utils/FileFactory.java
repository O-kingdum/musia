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
	private ArrayList<String> msg;
	
	public FileFactory() {
		factory = new DiskFileItemFactory();
		products = new ProductsBean();
	}
	
	public void setFactoryPath(String path) {
		this.path = path;
	}
	
	public String getFactoryPath() {
		return this.path;
	}
	
	public String getSuffix( String fileName ) {
		
		if (fileName == null)
	        return null;
	    
		int point = fileName.lastIndexOf(".");
	    
	    if (point != -1) {
	        return fileName.substring(point + 1);
	    }
	    
	    return fileName;
	}
	
	public boolean saveFileFacotry(HttpServletRequest request) {
		
		File file = new File(this.path);
		// 一時保存先フォルダ指定
		factory.setRepository(file);
		// バッファサイズ
		factory.setSizeThreshold(1024);
		//
		uploader = new ServletFileUpload(factory);
		// ファイルサイズ（無限）
		uploader.setSizeMax(-1);
		// エンコーディング
		uploader.setHeaderEncoding("UTF-8");
		
		try {
			// アップロードされたファイル情報をFileItemオブジェクトのリストとして取得
		    List<FileItem> objLst = uploader.parseRequest(request);
		    Iterator<FileItem> objItr = objLst.iterator();
		    
		    while(objItr.hasNext()) {

		    	FileItem objFi = (FileItem)objItr.next();

		    	if(!objFi.isFormField()) {
		    		  // アップロードファイルの元ファイル名を取得
		    		  String strNam = objFi.getName();

		    		  products.setDirectory_path(path + "/" + strNam);
		    		  if(strNam != null && !strNam.isEmpty()) {
		    			  strNam = ( new File( strNam ) ).getName();
		    			  objFi.write( new File( path + "/" + strNam ) );
		    			  // ディレクトリパス
			    		  products.setDirectory_path( path + "/" + strNam );
			    		  // ファイル種別
			    		  products.setFile_type( this.getSuffix( strNam ) );
			    		  // 
		    		  }
		       	} else {
		       		
		       	}
		    }
		      
		      
		} catch( FileUploadException e ) {
			
		} catch( Exception e ) {
			
		}
		return true;
	}
}
