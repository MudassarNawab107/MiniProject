package com.nt.com.Primaryconcept;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("p1")
@Primary
public class Q1 implements PrimaryInterface {
	@Override
	public String m1() {
		return "Printing M1 method from Q1 Class";
	}

}
