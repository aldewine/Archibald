package com.archibald.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.archibald.domain.Rotation;
import com.archibald.service.contract.ChangeDirectionService;
import com.archibald.service.output.ServiceOutput;

@RestController
public class ChangeDirectionController {
	
	@Autowired
	ChangeDirectionService changeDirectionService;
	
	@PostMapping("/turnLeft")
	public ServiceOutput turnLeft(@RequestHeader("Authorization") String token) {
		return changeDirectionService.changeDirection(token, Rotation.LEFT);
	}
	
	@PostMapping("/turnRight")
	public ServiceOutput turnRight(@RequestHeader("Authorization") String token) {
		return changeDirectionService.changeDirection(token, Rotation.RIGHT);
	}
}
