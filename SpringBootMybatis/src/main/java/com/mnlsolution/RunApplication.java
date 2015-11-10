package com.mnlsolution;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mnlsolution.domain.Useraccount;
import com.mnlsolution.mapper.UseraccountMapper;

public class RunApplication {
	public static void main(String[] args) {
		   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		   ctx.register(AppConfig.class);
		   ctx.refresh();
		   UseraccountMapper mapper = ctx.getBean(UseraccountMapper.class);	
		   Useraccount ua = new Useraccount();
		   ua.setEmail("test@");
		   ua.setLoginId("test3"); 
		   ua.setPasswd("test3");
		   
		   mapper.insertUseraccount(ua);
	           System.out.println("---Data saved---");
		}

}
