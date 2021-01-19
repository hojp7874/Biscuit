package com.ssafy.a407.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group/member")
public class MemberController {
	
	//멤버 신청
	@PostMapping(value = "/apply")
	private ResponseEntity apply(@RequestBody Map input)
	
	//멤버 승인
	@PutMapping(value = "/accept")
	private ResponseEntity accept(@RequestBody String email)
	//멤버 신청 취소
	
	//멤버 신청 반려
	@PutMapping(value = "/deny")
	private ResponseEntity deny(@RequestBody String mId)
	
	//신청 목록 조회(유저)
	
	//신청 목록 조회(그룹장)
	
	//권한 변경
	@PutMapping(value = "/permission")
	private ResponseEntity permission(@RequestBody String email)
	
	//그룹 멤버보기
	
}
