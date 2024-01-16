package com.example.demo.model;

public class ResponseData {

	private String fileName;
	private String URL;
	private String fileType;
	private long fileSize;
	
	public ResponseData() {
	
	}

	public ResponseData(String fileName, String URL, String fileType, long fileSize) {
		super();
		this.fileName = fileName;
		this.URL = URL;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
}
