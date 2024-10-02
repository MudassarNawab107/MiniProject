package com.nt.com.service;

import java.util.List;
import java.util.Set;

import com.nt.com.dto.CourseDTO;
import com.nt.com.dto.SearcInputhDTO;

import jakarta.servlet.http.HttpServletResponse;


public interface CourseService {

	Set<String> showAllAvailableCourses();
	
	List<CourseDTO>findResultsBasedOnSearch(SearcInputhDTO searcInputhDTO);
	
	void downloadPDF(SearcInputhDTO searcInputhDTO, HttpServletResponse res);
	void downloadExcel(SearcInputhDTO searcInputhDTO, HttpServletResponse res);
}
