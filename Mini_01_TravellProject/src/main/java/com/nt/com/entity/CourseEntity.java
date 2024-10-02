package com.nt.com.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer courseId;

	@Column(name = "course_name", nullable = false)
	private String courseName;

	@Column(name = "faculty_name", nullable = false)
	private String facultyName;

	@Column(name = "course_start_date", nullable = false)
	private LocalDateTime courseStartDate;

	@Column(name = "fee", nullable = false)
	private BigDecimal fee;

	@Column(name = "training_mode", nullable = false)
	private String trainingMode;

	@Column(name = "last_updated_by")
	private String lastUpdatedBy;

	@UpdateTimestamp
	@Column(name = "last_update_date", insertable=false,updatable = true)
	private LocalDateTime lastUpdateDate;

	@CreationTimestamp
	@Column(name = "create_date",insertable=true, updatable = false)
	private LocalDateTime createDate;

	@Column(name = "location")
	private String location;

	@Column(name = "admin_contact_number", nullable = false)
	private String adminContactNumber;

	
}
