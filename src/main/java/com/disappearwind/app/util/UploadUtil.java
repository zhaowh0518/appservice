package com.disappearwind.app.util;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {

	/**
	 * 上传头像或者音频工具类
	 * 
	 * @param request
	 * @param file
	 * @return 上传完的文件的全路径
	 */
	public static String uploads(HttpServletRequest request,
			MultipartFile file, String path) {
		if (null == file) {
			return null;
		}
		File localFile = new File(path);
		if (!localFile.exists()) {
			localFile.mkdirs();
		}
		String fileName = path + file.getOriginalFilename();
		String extName = fileName.substring(fileName.lastIndexOf(".") + 1,
				fileName.length());
		fileName = path + File.separator + UUID.randomUUID().toString() + "."
				+ extName;
		try {
			InputStream stream = file.getInputStream();
			File saveFile = new File(fileName);
			FileUtil.writeFile(stream, saveFile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return fileName;
	}

}
