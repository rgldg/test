package com.example.demo.util;

import java.io.File;

public class UploadUtil {
	public final static String IMG_PATH_STRING="static/upload/imgs";
	
	public static File getImgDirFile() {
		String fileDirPath=new String("src/main/resources/"+IMG_PATH_STRING);
		File fileDir=new File(fileDirPath);
		if(!fileDir.exists()) {
			fileDir.mkdirs();
		}
		return fileDir;		
	}
}
