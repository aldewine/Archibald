package com.archibald.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.archibald.domain.Direction;
import com.archibald.domain.Robot;
import com.archibald.domain.Rotation;
import com.archibald.domain.Stage;
import com.archibald.domain.StageList;
import com.archibald.service.output.ServiceOutput;

@Service
public class ChangeDirectionService implements com.archibald.service.contract.ChangeDirectionService{
	private static final Logger logger = LoggerFactory.getLogger(ChangeDirectionService.class);
	
	public ServiceOutput changeDirection(String token, Rotation rotation) {
		Stage stage = StageList.stageList.get(token);
		Robot robot = stage.getRobot();
		
		logger.info("Initial rotation is " + robot.getDirection());
		
		if(rotation.equals(Rotation.LEFT)) {
			if(robot.getDirection().equals(Direction.EAST)) {
				robot.setDirection(Direction.NORTH);
			}else if(robot.getDirection().equals(Direction.NORTH)) {
				robot.setDirection(Direction.WEST);
			}else if(robot.getDirection().equals(Direction.WEST)) {
				robot.setDirection(Direction.SOUTH);
			}else if(robot.getDirection().equals(Direction.SOUTH)) {
				robot.setDirection(Direction.EAST);
			}
		}else if(rotation.equals(Rotation.RIGHT)) {
			if(robot.getDirection().equals(Direction.EAST)) {
				robot.setDirection(Direction.SOUTH);
			}else if(robot.getDirection().equals(Direction.SOUTH)) {
				robot.setDirection(Direction.WEST);
			}else if(robot.getDirection().equals(Direction.WEST)) {
				robot.setDirection(Direction.NORTH);
			}else if(robot.getDirection().equals(Direction.NORTH)) {
				robot.setDirection(Direction.EAST);
			}
		}
		
		logger.info(" final rotation is " + robot.getDirection());
		stage.setRobot(robot);
		StageList.stageList.put(token, stage);
		
		return new ServiceOutput("0", " Successful.");
	}
}
