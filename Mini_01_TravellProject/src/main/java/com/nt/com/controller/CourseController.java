package com.nt.com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.com.dto.CourseDTO;
import com.nt.com.dto.SearcInputhDTO;
import com.nt.com.service.CourseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Endpoint to get distinct course names
    @GetMapping("/getAllAvailableCourse")
    public ResponseEntity<Set<String>> getDistinctCourseNames(HttpServletRequest request) {
    	request.getAttribute("Org");
        Set<String> distinctCourseNames = courseService.showAllAvailableCourses();
        return ResponseEntity.ok(distinctCourseNames);
    }
    
    @PostMapping("/getSearchedResults")
    public ResponseEntity<List<CourseDTO>> findResultsBasedOnSearch(@RequestBody SearcInputhDTO searchInputDTO) {
        List<CourseDTO> results = courseService.findResultsBasedOnSearch(searchInputDTO);
        return ResponseEntity.ok(results);
    }
    
    
    @PostMapping("/downLoadSerachResultExcel")
    public void downLoadSerachResultExcel(@RequestBody SearcInputhDTO searchInputDTO,HttpServletResponse res) {
    	 res.setContentType("application/vnd.ms-excel");
 	     res.setHeader("Content-Disposition","attachment; filename=courses.xlsx");
    	courseService.downloadExcel(searchInputDTO, res);
       
    }
    
    
    @PostMapping("/downLoadSerachResultPdf")
    public void downLoadPdf(@RequestBody SearcInputhDTO searchInputDTO,HttpServletResponse res) {
    	  res.setContentType("application/pdf");
    	  DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
    	  String currentDateTime = dateFormat.format(new Date());
 	     res.setHeader("Content-Disposition","attachment; filename=Course" + currentDateTime + ".pdf");
    	courseService.downloadPDF(searchInputDTO, res);
       
    }
}
