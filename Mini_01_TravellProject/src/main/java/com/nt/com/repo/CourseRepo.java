package com.nt.com.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.com.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {

	@Query("SELECT DISTINCT c.courseName FROM CourseEntity c")
	Set<String> findDistinctByCourseName();
}
