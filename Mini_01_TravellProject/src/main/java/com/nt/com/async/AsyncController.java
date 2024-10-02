package com.nt.com.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.com.exception.ErrorException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/getPaymentStatus")
	ResponseEntity<Boolean> getTravelleplan() throws ErrorException {
		Boolean status = paymentService.downStreamActivity();
		return ResponseEntity.ok(status);
	}
}
