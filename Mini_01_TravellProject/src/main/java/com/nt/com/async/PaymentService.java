package com.nt.com.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.com.aop.LogExecutionTime;

@Component
public class PaymentService {
	@Autowired
	AsynServiceImpl asynServiceImpl;
	@LogExecutionTime
	public Boolean downStreamActivity()
	{
		Boolean paymantStatus = asynServiceImpl.doPayments();
		asynServiceImpl.sendEmailNotification();
		asynServiceImpl.sendWhatsAppNotification();
		asynServiceImpl.assignDeliveyPartner();
		if(paymantStatus)
		{
			return paymantStatus;
		}
		return Boolean.FALSE;
	}
}
