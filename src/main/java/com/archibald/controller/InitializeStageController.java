package com.archibald.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.archibald.domain.Direction;
import com.archibald.service.contract.InitializeStageService;
import com.archibald.service.input.InitializeStageInput;
import com.archibald.service.output.ServiceOutput;

@RestController
public class InitializeStageController {

	@Autowired
	InitializeStageService initializeStageService;
	
	@PostMapping("/initializeStage")
	public ServiceOutput initializeStage(@RequestBody InitializeStageInput input,
			                             @RequestHeader("Authorization") String token) {
		return initializeStageService.initializeStage(input, token);
	}
}
