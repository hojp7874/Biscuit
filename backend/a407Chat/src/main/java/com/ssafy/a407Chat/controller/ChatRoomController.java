package com.ssafy.a407Chat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.a407Chat.dto.ChatRoomDto;
import com.ssafy.a407Chat.service.ChatService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
	@Autowired
	private ChatService chatService;
	
	@GetMapping(value = "/test")
	public String test() {
		return "test";
	}
	
	@GetMapping(value = "/room")
	public String rooms(Model model) {
		return "/chat/room";
	}
	@GetMapping(value = "/rooms")
	@ResponseBody
	public List<ChatRoomDto> room(){
		return chatService.findAllRoom();
	}
	
	@PostMapping(value = "/room")
	public ResponseEntity createRoom(@RequestBody ChatRoomDto dto) {
		
		Map result = new HashMap();
        ResponseEntity entity = null;

        ChatRoomDto data = chatService.createRoom(dto);
        	if (data != null) {
        		result.put("chatRoom", data);
        		result.put("success", "success");
        		entity = new ResponseEntity<>(result, HttpStatus.OK);
        		
        	}
        	else {
        		result.put("success", "error");
				entity = new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        	}
			
		return entity;
	}
	
	@GetMapping(value = "room/{roomId}")
	public ChatRoomDto roomInfo(@PathVariable String roomId) {
		return chatService.findRoomById(roomId);
	}
}
