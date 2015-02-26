package jp.co.musia.okingdum.Utils;

import java.io.File;

public class FileFactory {

	public void setFilePath(String path) {
		
	}
	
	private boolean mkDir(String path) {
		
		File f = new File(path);
		return f.mkdir();
	}
}
