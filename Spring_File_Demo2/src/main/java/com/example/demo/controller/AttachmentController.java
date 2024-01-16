package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.entity.Attachment;
import com.example.demo.model.ResponseMessage;
import com.example.demo.service.AttachmentService;

@RestController
public class AttachmentController {
	
	@Autowired
	private AttachmentService attachmentService;
	

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file)
	{
		String message="";
		try
		{
			attachmentService.uploadFile(file);
			message = "Uploaded File SuccessFully :"+file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}catch(Exception e)
		{
			message ="Coludn't Upload The File :"+file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@GetMapping("files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id)
	{
		Attachment attachment=attachmentService.getFile(id);
		
		return ResponseEntity.ok()
				.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName=\"" +attachment.getFileName() +"\"")
				.body(attachment.getData());
	}
	
}
