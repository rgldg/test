package com.example.demo.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


public class UploadUtils {
	/**
	 * 图片上传
	 * @return 返回相对路径
	 * @param photo 图片文件
	 * @param photoname 文件名
	 * @param path 文件保存路径(相对于web根目录)
	 * @return
	 */
	public static String fileload(@RequestParam("photoname")MultipartFile photo,String photoname,String path) {
		if (photo==null) {
			return null;
		}//上传图片不为空则执行以下上传操作
		String realPath=path+"/"+photoname;
		File savefile=new File(realPath);
		//判断文件父目录是否存在
		if (!savefile.getParentFile().exists()) {
			savefile.getParentFile().mkdir();//不存在则创建
		}
		System.out.println("上传文件绝对路径: "+savefile.getPath());
		try {
			//保存文件
			photo.transferTo(savefile);
			
		} catch (IllegalStateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		return realPath;
		
		return photoname;//返回文件名
	}
}
