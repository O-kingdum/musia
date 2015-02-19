package jp.co.musia.okingdum.Utils;

import java.io.File;

public class FileFactory {

	private String filepath;
	
	
	public String getFilepath() {
		return this.filepath;
	}
	
	public void setFilePath(String path) {
		this.filepath = path;
	}
	
	private boolean mkDir(String path) {
		
		File f = new File(path);
		return f.mkdir();
	}
}
