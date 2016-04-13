package com.caicai.www.intercepter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.ThrowsAdvice;

public class ExceptionInterceptor{
	
	private Log log = LogFactory.getLog(ExceptionInterceptor.class.getName());
	
	public void before() throws Exception{
		System.out.println(23123);
	}

	public void afterThrowing(JoinPoint jointPoint , Exception e){
		log.debug("", e);
//		log.error(e.getStackTrace(), e);
		System.out.println(2323);
	}
	
}
