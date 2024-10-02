package com.nt.com.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SearcInputhDTO {

	private String courseName;
	private String trainingMode;
	private String facultyName;
	private LocalDateTime courseStartDate;
	private String pageNo;
	private String pageSize;
	private String orgId;
}
