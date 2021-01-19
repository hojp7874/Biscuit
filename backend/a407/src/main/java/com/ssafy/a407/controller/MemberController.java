package com.ssafy.a407.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.a407.dto.MemberDto;
import com.ssafy.a407.dto.UserMemberDto;
import com.ssafy.a407.service.MemberService;

@RestController
@RequestMapping("/group/member")
public class MemberController {
	
	@Autowired
	private MemberService member;
	
	
	@GetMapping(value = "/test")
	private String test() {
		return "test";
	}
	
	
	@GetMapping(value = "/test/test2")
	private String test2() {
		return "test2";
	}
	
	//멤버 신청
	@PostMapping(value = "/apply")
	private ResponseEntity apply(@RequestBody Map map) {
		//gid와 email을 파라미터로 받음
		ResponseEntity entity = null;
		Map result = new HashMap();
		MemberDto dto = new MemberDto();
		dto.setEmail((String)map.get("email"));
		dto.setgId((int)map.get("gId"));
		dto.setPermission(0);
		
		try {
			if(member.joinMember(dto) == 1) {
				result.put("success", "success");
				entity = new ResponseEntity<>(result, HttpStatus.OK);	
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		
		}
		return entity;
	}
	
	//멤버 승인
	@PutMapping(value = "/accept")
	private ResponseEntity accept(@RequestBody Map map) {
		ResponseEntity entity = null;
		Map result = new HashMap();
		Map input = new HashMap();
		input.put("mId", map.get("mId"));
		input.put("permission", 1);
		
		try {
			if(member.updateMemberPermission(input) == 1) {
				result.put("success", "success");
				entity = new ResponseEntity<>(result, HttpStatus.OK);	
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		
		}
		return entity;
		
	}
	//멤버 신청 취소
	@DeleteMapping(value = "/cancel")
	private ResponseEntity cancel(@RequestBody Map map) {
		ResponseEntity entity = null;
		Map result = new HashMap();
		int mId = (int)map.get("mId");
		try {
			if(member.cancelApply(mId) == 1) {
				result.put("success", "success");
				entity = new ResponseEntity<>(result, HttpStatus.OK);	
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		
		}
		return entity;
		
	}
	//멤버 신청 반려
	@PutMapping(value = "/deny")
	private ResponseEntity deny(@RequestBody Map map)
	{
		
		ResponseEntity entity = null;
		Map result = new HashMap();
		Map input = new HashMap();
		input.put("mId", map.get("mId"));
		input.put("permission", 4);
		
		try {
			if(member.updateMemberPermission(input) == 1) {
				result.put("success", "success");
				entity = new ResponseEntity<>(result, HttpStatus.OK);	
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		
		}
		return entity;
		
	}
	
	//신청 목록 조회(유저)
	@GetMapping(value = "/apply/user/list")
	private ResponseEntity groupList(@RequestParam String email) {
		ResponseEntity entity = null;
		Map result = new HashMap();
		List list = new ArrayList();
		
		try {
			list = member.getGroupList(email);
		
			if(list != null) {
				result.put("success", "success");
				result.put("list", list);
				entity = new ResponseEntity<>(result, HttpStatus.OK);	
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		
		}
		return entity;
		
	}
	//신청 목록 조회(그룹장)
	@GetMapping(value = "/apply/group/list")
	private ResponseEntity applyList(@RequestParam int gId) {
		ResponseEntity entity = null;
		Map result = new HashMap();
		List list = new ArrayList();
		
		try {
			list = member.getApplyList(gId);
		
			if(list != null) {
				result.put("success", "success");
				result.put("list", list);
				entity = new ResponseEntity<>(result, HttpStatus.OK);	
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		
		}
		return entity;
		
	}
	//권한 변경
	@PutMapping(value = "/permission")
	private ResponseEntity permission(@RequestBody Map map)
	{
		ResponseEntity entity = null;
		Map result = new HashMap();
		Map input = new HashMap();
		input.put("mId", map.get("mId"));
		input.put("permission", map.get("permission"));
		
		try {
			if(member.updateMemberPermission(input) == 1) {
				result.put("success", "success");
				entity = new ResponseEntity<>(result, HttpStatus.OK);	
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		
		}
		return entity;
	}
	//그룹 멤버보기
	
	@GetMapping(value = "/list")
	private ResponseEntity listMember(@RequestParam int gId) {
		ResponseEntity entity = null;
		Map result = new HashMap();
		try {
			List<UserMemberDto> list = member.getMemberList(gId);
			if(list != null) {
				result.put("list", list);
				result.put("success", "success");
				entity = new ResponseEntity(result, HttpStatus.OK);
			} else {
	        	result.put("success", "fail");
	        	entity = new ResponseEntity(result, HttpStatus.OK);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("success", "error"); 
	        entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
