package com.nt.com.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nt.com.aop.LogExecutionTime;
import com.nt.com.dto.CourseDTO;
import com.nt.com.dto.SearcInputhDTO;
import com.nt.com.entity.CourseEntity;
import com.nt.com.repo.CourseRepo;
import com.nt.com.util.PDFService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	PDFService pdfService;
	
	@LogExecutionTime
	@Override
	public Set<String> showAllAvailableCourses() {
		return courseRepo.findDistinctByCourseName();	
	}

	@Override
	public List<CourseDTO> findResultsBasedOnSearch(SearcInputhDTO searcInputhDTO) {
		
		CourseEntity courseEntity = new CourseEntity();
		if(StringUtils.hasLength(searcInputhDTO.getCourseName()))
		{
			courseEntity.setCourseName(searcInputhDTO.getCourseName());
		}
		if(StringUtils.hasLength(searcInputhDTO.getTrainingMode()))
		{
			courseEntity.setTrainingMode(searcInputhDTO.getTrainingMode());
		}
		LocalDateTime courseStartDate = searcInputhDTO.getCourseStartDate();
		if(ObjectUtils.isNotEmpty(courseStartDate))
		{
			courseEntity.setCourseStartDate(searcInputhDTO.getCourseStartDate());
		}
		Example<CourseEntity> searchVariables = Example.of(courseEntity);
		Pageable pageable = PageRequest.of(Integer.parseInt(searcInputhDTO.getPageNo()),Integer.parseInt(searcInputhDTO.getPageSize()) );
		   
		Page <CourseEntity> pageEntities = courseRepo.findAll(searchVariables, pageable);

	    List<CourseDTO> listCourses = new ArrayList<>();
	    pageEntities.forEach(course -> {
	        CourseDTO dto = new CourseDTO();
	        BeanUtils.copyProperties(course, dto);
	        listCourses.add(dto);
	    });
		return listCourses;
	}

	@Override
	@SneakyThrows
	public void downloadPDF(SearcInputhDTO searcInputDTO, HttpServletResponse response) {
		 //https://springjava.com/spring-boot/export-data-into-pdf-file-in-spring-boot/
		    
		    List<CourseDTO> courses = findResultsBasedOnSearch(searcInputDTO);
		    
		    pdfService.downloadPDF(response, courses);
	}
    

	@Override
	public void downloadExcel(SearcInputhDTO searcInputDTO, HttpServletResponse res) {

	   
// Will download in browser
		
//	    // Create a Workbook
//	    try (Workbook workbook = new XSSFWorkbook()) {
//	        Sheet sheet = workbook.createSheet("Courses");
//
//	        // Create header row
//	        Row headerRow = sheet.createRow(0);
//	        headerRow.createCell(0).setCellValue("Course Name");
//	        headerRow.createCell(1).setCellValue("Training Mode");
//	        headerRow.createCell(2).setCellValue("Course Start Date");
//
//	        // Fetch data based on the search input (replace with your actual data retrieval logic)
//	        List<CourseDTO> courses = findResultsBasedOnSearch(searcInputhDTO);
//
//	        // Populate the data rows
//	        int rowNum = 1;
//	        for (CourseDTO course : courses) {
//	            Row row = sheet.createRow(rowNum++);
//	            row.createCell(0).setCellValue(course.getCourseName());
//	            row.createCell(1).setCellValue(course.getTrainingMode());
//	            row.createCell(2).setCellValue(course.getCourseStartDate() != null ? course.getCourseStartDate().toString() : "");
//	        }
//
//	        // Write the workbook to the response output stream
//	        workbook.write(res.getOutputStream());
//	        res.getOutputStream().flush();
//	    } catch (IOException e) {
//	        // Handle exception (logging, rethrowing, etc.)
//	        e.printStackTrace();
//	    }
//		
		 String filePath = "D:/excelDownload/courses.xlsx";
		
	      // Create a Workbook
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Courses");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Course Name");
            headerRow.createCell(1).setCellValue("Training Mode");
            headerRow.createCell(2).setCellValue("Course Start Date");

            // Fetch data based on the search input
            List<CourseDTO> courses = findResultsBasedOnSearch(searcInputDTO);

            // Populate the data rows
            int rowNum = 1;
            for (CourseDTO course : courses) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(course.getCourseName());
                row.createCell(1).setCellValue(course.getTrainingMode());
                row.createCell(2).setCellValue(course.getCourseStartDate() != null ? course.getCourseStartDate().toString() : "");
            }

            // Save the workbook to the specified file path
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                System.out.println("Excel file has been downloaded to: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }
	
	
	
	
	
	
	

	}


