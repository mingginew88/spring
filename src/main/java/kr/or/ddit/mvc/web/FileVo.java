package kr.or.ddit.mvc.web;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileVo {
	
	private List<MultipartFile> files;

	
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	

}
