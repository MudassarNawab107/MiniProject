package com.nt.com.qualifierconcept;

import org.springframework.stereotype.Service;

@Service("q1")
public class Q1 implements QualifierInterface {
	@Override
	public String m1() {
		return "Printing M1 method from Q1 Class";
	}

}
