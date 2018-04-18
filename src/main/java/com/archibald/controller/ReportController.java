package com.archibald.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.archibald.service.impl.ReportService;
import com.archibald.service.output.ServiceOutput;

@RestController
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@PostMapping("/report")
	public ServiceOutput report(@RequestHeader("Authorization") String token) {
		return reportService.report(token);
	}
}
