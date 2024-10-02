package com.nt.com.qualifierconcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.com.exception.ErrorException;
@RestController
@RequestMapping("/q1")
public class QualifierController {
	@Autowired
	@Qualifier("q2")
	QualifierInterface qualifierInterface;
	

	@GetMapping("/qualifierTest")
	ResponseEntity<String> getTravelleplan() throws ErrorException {
		return ResponseEntity.ok(qualifierInterface.m1());
	}
}
