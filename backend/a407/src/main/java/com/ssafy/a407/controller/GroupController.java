package com.ssafy.a407.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.a407.service.GroupService;



@CrossOrigin(origins = { "*" }, maxAge = 6000)

@RestController
@RequestMapping("/group")
public class GroupController {
	
	
	@Autowired
	private GroupService group;
	
	//그룹 삭제
	@DeleteMapping(value = "/delete")
	private ResponseEntity delete(@RequestHeader Map mem) {
		ResponseEntity entity = null;
		System.out.println("delete =========");
		Map result = new HashMap();
		try {
			if (group.remove(mem) == 1) {
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
}
