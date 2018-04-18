package com.archibald.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.archibald.service.contract.MoveService;
import com.archibald.service.output.ServiceOutput;

@RestController
public class MoveController {
	
	@Autowired
	MoveService moveService;
	
	@PostMapping("/move")
	public ServiceOutput move(@RequestHeader("Authorization") String token) {
		return moveService.move(token);
	}
}
