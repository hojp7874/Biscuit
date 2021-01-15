package com.ssafy.a407.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.a407.service.EmailService;
import com.ssafy.a407.service.EmailServiceImpl;


@Controller
@RequestMapping("/service/*")
public class MailController {
	@Autowired
	EmailService service;

	private static final Logger logger = LoggerFactory.getLogger(MailController.class);

	@PostMapping("/mail")
	@ResponseBody
	public void emailConfirm(String userId) throws Exception {
		logger.info("post emailConfirm");
		System.out.println("전달 받은 이메일 : " + userId);
		service.sendSimpleMessage(userId);
	}

	@PostMapping("/verifyCode")
	@ResponseBody
	public int verifyCode(String code) {
		logger.info("Post verifyCode");

		int result = 0;
		System.out.println("code : " + code);
		System.out.println("code match : " + EmailServiceImpl.ePw.equals(code));
		if (EmailServiceImpl.ePw.equals(code)) {
			result = 1;
		}

		return result;
	}
	
}