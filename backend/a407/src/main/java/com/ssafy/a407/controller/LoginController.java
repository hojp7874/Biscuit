package com.ssafy.a407.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.a407.dto.UserDto;
import com.ssafy.a407.service.JwtService;
import com.ssafy.a407.service.LoginService;



@CrossOrigin(origins = { "*" }, maxAge = 6000)

@RestController
@RequestMapping("/user")
public class LoginController{


//	@Autowired
//	private JwtService jwtService;
	
	@Autowired
	private LoginService login;
	

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping(value = "/test")
	private String test() {
		return "test";
	}
	
	//로그인
	@PostMapping(value = "/login")
    private ResponseEntity login(@RequestBody Map mem) {
        Map result = new HashMap();
        System.out.println("email : " + mem.get("email") + " pw : " + mem.get("password"));
        ResponseEntity entity = null;
        try {
            UserDto member = login.login(mem);
            if (member == null) {
            	result.put("success", "fail"); 
                entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
            else {
//                String token = jwtService.create(member);
//                System.out.println(token);
//                logger.trace("token " , token);
//
//                result.put("x-access-token", token);
                result.put("success", "success");                
                

            entity = new ResponseEntity<>("success", HttpStatus.OK);
            
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        //model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
	        result.put("success", "error"); 
	        entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	}

	
	//회원가입
	@PostMapping(value = "/join")
    private ResponseEntity register(@RequestBody UserDto user) {
		System.out.println("email : "+user.getEmail()+"/ nickname : "+user.getNickname()+" / password : "+user.getPassword());
		Map result = new HashMap();
        ResponseEntity entity = null;
        try {
			login.join(user);
			result.put("success", "success");
			entity = new ResponseEntity<>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error"); 
	        entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}