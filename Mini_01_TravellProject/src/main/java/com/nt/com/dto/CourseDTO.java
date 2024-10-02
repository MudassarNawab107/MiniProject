package com.nt.com.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Integer courseId;
    private String courseName;
    private String facultyName;
    private LocalDateTime courseStartDate;
    private BigDecimal fee;
    private String trainingMode;
    //private String lastUpdatedBy;
    //private LocalDateTime lastUpdateDate;
   // private LocalDateTime createDate;
    private String location;
    private String adminContactNumber;
    private String orgId;

}
