package com.nt.com.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsynServiceImpl {

	
	public Boolean doPayments() {
		log.error("paymnet Done");
		return Boolean.TRUE;
	}
	@SneakyThrows
    @Async("taskExecutor")
	public void sendEmailNotification()
	{
		Thread.sleep(4000);
		log.error("sendEmailNotification Excuted");
	}
	@SneakyThrows
	@Async("taskExecutor")
	public void sendWhatsAppNotification()
	{
		Thread.sleep(4000);
		log.error("sendWhatsAppNotification Excuted");
	}
	@SneakyThrows
	 @Async("taskExecutor")
	public void assignDeliveyPartner()
	{
		Thread.sleep(4000);
		log.error("assignDeliveyPartner Excuted");
	}
	
	
}
