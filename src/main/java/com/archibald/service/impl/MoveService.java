package com.archibald.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.archibald.domain.Direction;
import com.archibald.domain.Robot;
import com.archibald.domain.Stage;
import com.archibald.domain.StageList;
import com.archibald.service.output.ServiceOutput;

@Service
public class MoveService implements com.archibald.service.contract.MoveService{
	
	private static final Logger logger = LoggerFactory.getLogger(MoveService.class);
	
	public ServiceOutput move(String token) {
		Stage stage = StageList.stageList.get(token);
		if(null == stage) {
			return new ServiceOutput("-1", "Please call initializeStage service first with the token provided."+
		                                   " If you do not have a token, please call login service to acquire one.");
		}
		Robot robot = stage.getRobot();
		boolean check = false;
		logger.info(" Archibald is at x:" + robot.getPosX() + 
				    ", y:" + robot.getPosY() + 
				    " direction:" + robot.getDirection());
		
		if(robot.getDirection().equals(Direction.EAST)) {
			robot.setPosX(robot.getPosX()+1);
		}else if(robot.getDirection().equals(Direction.NORTH)) {
			robot.setPosY(robot.getPosY()+1);
		}else if(robot.getDirection().equals(Direction.WEST)) {
			robot.setPosX(robot.getPosX()-1);
		}else if(robot.getDirection().equals(Direction.SOUTH)) {
			robot.setPosY(robot.getPosY()-1);
		}
		
		if(robot.getPosX() > stage.getTable().getX()) {
			robot.setPosX(stage.getTable().getX());
			check = true;
		}else if(robot.getPosY() > stage.getTable().getY()) {
			robot.setPosY(stage.getTable().getY());
			check = true;
		}else if(robot.getPosX() < 0) {
			robot.setPosX(0);
			check = true;
		}else if(robot.getPosY() < 0) {
			robot.setPosY(0);
			check = true;
		}
		
		stage.setRobot(robot);
		StageList.stageList.put(token, stage);
		if(check) {
			logger.info(" Movement is ignored.");
			return new ServiceOutput("-1", "Movement is ignored.");
		}else {
			logger.info(" Archibald moved to x:" + robot.getPosX() + 
					    ", y:" + robot.getPosY() + 
					    " direction:" + robot.getDirection());
			return new ServiceOutput("0","Successful");
		}
	}
}
