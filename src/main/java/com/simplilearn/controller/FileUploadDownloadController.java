package com.simplilearn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadDownloadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {

		// STEP 1: Create New File Object
		File newFile = new File("c://temp//" + multipartFile.getOriginalFilename());

		// STEP 2: If it doesn't Exist, create new one
		if (!newFile.exists()) {
			newFile.createNewFile();
		}

		// STEP 3: Read data (from multipartFile) and write it to new file that we
		// created in STEP 2.
		FileOutputStream fos = new FileOutputStream(newFile);
		fos.write(multipartFile.getBytes());
		fos.close();

		return "File uploaded successfully";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@RequestParam("fileName") String fileName) throws FileNotFoundException {

		// STEP 1: Read your file
		File file = new File("c://temp//" + fileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		// STEP 2: Set up headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; fileName=" + fileName);

		// STEP 3: return Resonse
		return ResponseEntity.ok().headers(headers)
				.contentType(MediaType.parseMediaType("application/txt")).body(resource);

	}

}
