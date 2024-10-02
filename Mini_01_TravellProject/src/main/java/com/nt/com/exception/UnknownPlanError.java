package com.nt.com.exception;

public class UnknownPlanError extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

    public UnknownPlanError(String message) {
    	 super(message);
       }

}
