package com.disappearwind.app.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * 文件操作
 */
public class FileUtil {
	
	public static String DATA_ENCODING = "UTF-8";
	/*
	 * 读取文件
	 */
	public static String readFile(String filePath) {
		String data = "";
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				data = FileUtils.readFileToString(file,DATA_ENCODING);
			} else {
				data = "cann't find your file!";
			}

		} catch (Exception e) {
			data = e.getMessage();
		}
		return data;
	}
	
	
	/*
	 * 将文件写入磁盘
	 */
	public static void writeFile(InputStream upIs, File saveFile)
			throws FileNotFoundException, IOException {
		OutputStream os = new FileOutputStream(saveFile);
		byte[] buffer = new byte[4096];
		int len = 0;
		while ((len = upIs.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		upIs.close();
		os.close();
	}
	
	
}
