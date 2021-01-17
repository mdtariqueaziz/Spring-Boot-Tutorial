package com.example.file.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadHelper {

	 public final String UPLOAD_DIR =
	 "F:\\Spring-Boot-Tutorial\\FileUploading-REST-API\\src\\main\\resources\\static\\image";
	//public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();

	public FileUploadHelper() throws IOException {

	}

	boolean uploaded = false;

	public boolean uploadFile(MultipartFile multipartFile) {
		try {
			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR + "/" + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			uploaded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uploaded;

	}

}
