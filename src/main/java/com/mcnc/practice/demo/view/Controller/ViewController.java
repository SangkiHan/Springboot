package com.mcnc.practice.demo.view.Controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);
	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	final static String namespace = "com.mcnc.practice.test";
	
//	@GetMapping("/")
//	public String home() {
//		
//		logger.info("page home");
//		
//		return "/home";
//	}
//	
//	@GetMapping("/login")
//	public String login() {
//		
//		logger.info("page login");
//		
//		return "/login";
//	}
//	
//	@GetMapping("/join")
//	public String join() {
//		
//		logger.info("page join");
//		
//		return "/join";
//	}

}
