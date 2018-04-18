package com.archibald.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.archibald.domain.Robot;
import com.archibald.domain.Stage;
import com.archibald.domain.StageList;
import com.archibald.service.output.ServiceOutput;

@Service
public class ReportService implements com.archibald.service.contract.ReportService{

	private static final Logger logger = LoggerFactory.getLogger(ReportService.class);
	
	public ServiceOutput report(String token) {
		Stage stage = StageList.stageList.get(token);
		if(null == stage) {
			return new ServiceOutput("-1", "Please call initializeStage service first with the token provided."+
		                                   " If you do not have a token, please call login service to acquire one.");
		}
		Robot robot = stage.getRobot();
		
		StringBuilder sb = new StringBuilder();
		sb.append("Archibald is at x:");
		sb.append(robot.getPosX());
		sb.append(", y:");
		sb.append(robot.getPosY());
		sb.append(" direction:");
		sb.append(robot.getDirection());
		
		logger.info(" service is finished.");
		
		return new ServiceOutput("0", "Successful. " + sb.toString());
	}
}
