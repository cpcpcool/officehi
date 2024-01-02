package com.groupware.officehi.dto;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 박재용
 * @editDate 23.12.26 ~ 23.12.27
 */

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class FileDTO {
	
	private Long userNo;
	private String fileName;
	private String originalFileName;
	private String filePath;
	private String fileTypeNo;
	private MultipartFile multipartFile;
	
	public FileDTO(@Param("originalFileName") String originalFileName) {
		this.originalFileName = originalFileName;
	}
}
