package jp.co.musia.okingdum.Utils;

public class Sanitizer {
	
	/**
	 * タグを無害化。
	 * @param str
	 * @return
	 */
	public static String convertSanitize( String str ) {
	    if(str==null) {
	        return str;
	    }
	    str = str.replaceAll("&" , "＆" );
	    str = str.replaceAll("<" , "&lt;"  );
	    str = str.replaceAll(">" , "&gt;"  );
	    str = str.replaceAll("\"", "&quot;");
	    str = str.replaceAll("'" , "&#39;" );
	    return str;
	 }
	 
	/**
	 * 無害化されたタグを元に戻す
	 * @param str
	 * @return
	 */
	public static String convertUnsanitize( String str ) {
	    if(str==null) {
	        return str;
	    }
	    str = str.replaceAll("&#39;" , "'" );
	    str = str.replaceAll("&quot;", "\"");
	    str = str.replaceAll("&gt;"  , ">" );
	    str = str.replaceAll("&lt;"  , "<" );
	    str = str.replaceAll("&amp;" , "&" );
	    return str;
	 }
}
