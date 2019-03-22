package com.neoxamhr.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.swing.filechooser.FileNameExtensionFilter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.neoxamhr.services.StorageImageService;


import ch.qos.logback.core.Context;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UploadController {

	@Autowired
	private StorageImageService sis;
	
	@Autowired
	private ServletContext sc;
	
	List<String> files = new ArrayList<String>();

	@PostMapping("/addimage")
	public boolean handleFileUpload(@RequestParam("file") MultipartFile formdata) {
		try {
			System.out.println(formdata.getContentType());
			System.out.println(formdata.getOriginalFilename());
			sis.store(formdata);
			return true;
		} catch (Exception e) {
			System.out.println("fail");
			return false;
		}
	}

	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
	 Resource file = sis.loadFile(filename);
	 return ResponseEntity.ok()
	 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
	 .body(file);
	}
}
