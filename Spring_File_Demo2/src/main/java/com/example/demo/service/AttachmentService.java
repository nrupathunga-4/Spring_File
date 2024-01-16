package com.example.demo.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Attachment;
import com.example.demo.repository.AttachementRepository;

@Service
public class AttachmentService {

	@Autowired
	private AttachementRepository attachementRepository;

    
	public Attachment uploadFile(MultipartFile file) throws IOException
	{
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		Attachment attachment=new Attachment(fileName, file.getContentType(), file.getBytes());
		return attachementRepository.save(attachment);
	}
	
	public Attachment getFile(String id)
	{
		return attachementRepository.findById(id).get();
	}
}
	
