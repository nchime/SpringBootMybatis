package com.mnlsolution.controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mnlsolution.domain.Useraccount;
import com.mnlsolution.mapper.UseraccountMapper;

@Controller
@RequestMapping("/")
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UseraccountMapper mapper;
	
	
	@RequestMapping("/") 
	public String home() {
		logger.info(">>>> home controller"); 
		
		return "redirect:/list";
	} 
	
	

	@RequestMapping("/list")
	public @ResponseBody List<Useraccount> list() {
		logger.info(">>> list Controller");

		List<Useraccount> selList = mapper.selectUseraccount();
		for (Useraccount useraccount : selList) {
			logger.info(useraccount.toString());

		}
		return selList;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public @ResponseBody Useraccount insert(@RequestParam(value = "loginid") String loginid,
			@RequestParam(value = "passwd") String passwd, @RequestParam(value = "username") String username,
			@RequestParam(value = "email") String email) {
		logger.info(">>> insert Controller");

		Useraccount ua = new Useraccount();
		ua.setLoginId(loginid);
		ua.setPasswd(passwd);
		ua.setUsername(username);
		ua.setEmail(email);

		Date cd = new Date();
		ua.setRegdate(new Timestamp(cd.getTime()));
		logger.info("resut : {}", ua.toString());

		// TODO 예외처리 방법 정리할 것..
		int insertResult = mapper.insertUseraccount(ua);
		if (insertResult > 1) {
			logger.info("정상 등록되었습니다. result : {}", insertResult);
		}

		Useraccount selUa = mapper.selectOneUseraccount(loginid);

		logger.info("resut : {}", selUa.toString());

		return selUa;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public @ResponseBody Useraccount update(@RequestParam(value = "loginid") String loginid, 
			@RequestParam(value = "username") String username) {
		logger.info(">>>> update controller");

		Useraccount ua = new Useraccount();
		ua.setUsername(username);
		Date cd = new Date();
		ua.setUpddate(new Timestamp(cd.getTime()));
		logger.info("result : {}", ua.toString());		

		mapper.updateUseraccount(ua);

		return mapper.selectOneUseraccount(loginid); 
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Useraccount delete(@RequestParam(value = "loginid") String loginid) {
		logger.info(">>>> delete controller");

		mapper.deleteUseraccount(loginid);

		return mapper.selectOneUseraccount(loginid); 
	}

	

}
