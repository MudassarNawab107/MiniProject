package com.nt.com.Primaryconcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.com.exception.ErrorException;
@RestController
@RequestMapping("/p1")
public class PrimaryController {
	@Autowired
	PrimaryInterface primaryInterface;
	

	@GetMapping("/primaryTest")
	ResponseEntity<String> getTravelleplan() throws ErrorException {
		return ResponseEntity.ok(primaryInterface.m1());
	}
}
