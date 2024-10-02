package com.nt.com.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DataDTO {

	private String planName;
	private String planDescription;
	private Integer planCategoryId;
	private Float planBudget;
	private Integer isPlanActive;
	private Integer budget;
	private String categoryName;
    private String lastUpdatedBy;
    private String loggedBy;
    private Integer rowState;
    private Integer planId;
    private String orgId;
}
