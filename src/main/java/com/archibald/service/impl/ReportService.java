package com.archibald.service.impl;

import org.springframework.stereotype.Service;

import com.archibald.domain.Robot;
import com.archibald.domain.Stage;
import com.archibald.domain.StageList;

@Service("ReportService")
public class ReportService implements com.archibald.service.inter.ReportService{

	public String report(String token) {
		Stage stage = StageList.stageList.get(token);
		Robot robot = stage.getRobot();
		
		StringBuilder sb = new StringBuilder();
		sb.append("Archibald is at x:");
		sb.append(robot.getPosX());
		sb.append(", y:");
		sb.append(robot.getPosY());
		sb.append(" direction:");
		sb.append(robot.getDirection());
		return sb.toString();
	}
}
