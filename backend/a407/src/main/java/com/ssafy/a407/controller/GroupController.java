package com.ssafy.a407.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.a407.dto.GroupDto;
import com.ssafy.a407.dto.MemberDto;
import com.ssafy.a407.dto.UserDto;
import com.ssafy.a407.service.GroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/group")
@Api("GroupController")
public class GroupController {
	
	
	@Autowired
	private GroupService group;
	
	//그룹 삭제
	@DeleteMapping(value = "/delete")
	private ResponseEntity delete(@RequestHeader int gId) {
		ResponseEntity entity = null;
		System.out.println("delete =========");
		Map result = new HashMap();
		try {
			if (group.remove(gId) == 1) {
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
	

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping(value = "/test")
	private String test() {
		return "test";
	}
	
	@GetMapping(value = "/list")
	private ResponseEntity list(@RequestParam String type, @RequestParam String word) {
		//type을 어레이로 받으면 여러개로 받을 수 있을까요?
		ResponseEntity entity = null;
		Map result = new HashMap();
		try {
			System.out.println("controller. type : " + type + " word : " + word);
			if(type.equals("")) {
				List<GroupDto> list = group.searchList();
		        System.out.println(list);
		        if(list != null) {
		            result.put("list", list);
		            result.put("success", "success");
		            entity = new ResponseEntity(result, HttpStatus.OK);
		        } else {
		        	result.put("success", "fail");
		        	entity = new ResponseEntity(result, HttpStatus.OK);
		        }
			}
			else if(type.equals("groupName")) {
				List<GroupDto> list = group.searchGroupName(word);
				System.out.println(list);
				if(list != null) {
					result.put("list", list);
					result.put("success", "success");
					entity = new ResponseEntity(result, HttpStatus.OK);
				} else {
		        	result.put("success", "fail");
		        	entity = new ResponseEntity(result, HttpStatus.OK);
		        }
			}
			else if(type.equals("groupDesc")) {
				List<GroupDto> list = group.searchGroupDesc(word);
				System.out.println(list);
				if(list != null) {
					result.put("list", list);
					result.put("success", "success");
					entity = new ResponseEntity(result, HttpStatus.OK);
				} else {
		        	result.put("success", "fail");
		        	entity = new ResponseEntity(result, HttpStatus.OK);
		        }
			}
			if(type.equals("category")) {
				List<GroupDto> list = group.searchCategory(word);
				System.out.println(list);
				if(list != null) {
					result.put("list", list);
					result.put("success", "success");
					entity = new ResponseEntity(result, HttpStatus.OK);
				} else {
		        	result.put("success", "fail");
		        	entity = new ResponseEntity(result, HttpStatus.OK);
		        }
			}
			if(type.equals("region")) {
				List<GroupDto> list = group.searchRegion(word);
				System.out.println(list);
				if(list != null) {
					result.put("list", list);
					result.put("success", "success");
					entity = new ResponseEntity(result, HttpStatus.OK);
				} else {
		        	result.put("success", "fail");
		        	entity = new ResponseEntity(result, HttpStatus.OK);
		        }
			}

		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
		}
		return entity;
	}
	
	//그룹정보수정
	@PutMapping(value = "/update")
	private ResponseEntity update(@ApiParam(value = "필요한 정보 : email, max, ...", required = true) @RequestBody Map mem) {
		ResponseEntity entity = null;
		System.out.println("update ========");
		Map result = new HashMap();
		try {
			if (group.update(mem) == 1) {
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

	@ApiOperation(httpMethod = "POST"
			,value = "그룹 생성"
			,notes = "그룹 생성하는 API"
			,response = ResponseEntity.class
			,responseContainer = "ResponseEntity")
	//group 생성할 때 member에도 추가해야됨
	@PostMapping(value = "/create")
    private ResponseEntity register(@RequestBody GroupDto groupDto) {
		System.out.println("controller >> " + groupDto.toString());
		ResponseEntity entity = null;
		Map result = new HashMap();
		
		try {
			if( group.createGroup(groupDto)==1) {
				result.put("success", "success");
				entity = new ResponseEntity(result, HttpStatus.OK);
			}else {
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
