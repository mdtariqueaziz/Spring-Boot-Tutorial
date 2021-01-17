package com.example.file.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.file.helper.FileUploadHelper;

@RestController
public class FileControler {
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/file-upload")
	public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {

		try {

			if (file.isEmpty()) {
				ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File not found");
			}
			if (!file.getContentType().equals("image/jpeg")) {

				ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG content type are allowed");

			}

			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {

				 return ResponseEntity.ok().body("File Uploaded Successfully");
			//	Dynamin File Uploading
//				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
//						.path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}

}
