package com.nt.com.Primaryconcept;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("p2")

public class Q2 implements PrimaryInterface {
	@Override
	public String m1() {
		return "Printing M1 method from Q2 Class";

	}

}
