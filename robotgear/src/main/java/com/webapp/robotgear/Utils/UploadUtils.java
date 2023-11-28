package com.webapp.robotgear.Utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UploadUtils {
	
	@Value("classpath:static/assets")
	private static String path;
	
	
	public static boolean checkFileExtension(MultipartFile file) {
		String filename = file.getOriginalFilename();
		int index = filename.indexOf('.');
		String extension = filename.substring(index+1, filename.length()).toUpperCase();
		if("PNG".equals(extension) || "JPG".equals(extension) || "JPEG".equals(extension) || "TIFF".equals(extension) ) {
			return true;}
		return false;
		
	}
}

