package com.nt.com.qualifierconcept;

import org.springframework.stereotype.Service;

@Service("q2")
public class Q2 implements QualifierInterface {
	@Override
	public String m1() {
		return "Printing M1 method from Q2 Class";

	}

}
