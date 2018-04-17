package com.archibald.service.impl;

import org.springframework.stereotype.Service;

import com.archibald.domain.Direction;
import com.archibald.domain.Robot;
import com.archibald.domain.Stage;
import com.archibald.domain.StageList;

@Service("MoveService")
public class MoveService implements com.archibald.service.inter.MoveService{
	
	public void move(String token) {
		Stage stage = StageList.stageList.get(token);
		Robot robot = stage.getRobot();
		
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
		}else if(robot.getPosY() > stage.getTable().getY()) {
			robot.setPosY(stage.getTable().getY());
		}else if(robot.getPosX() < 0) {
			robot.setPosX(0);
		}else if(robot.getPosY() < 0) {
			robot.setPosY(0);
		}
		
		stage.setRobot(robot);
		StageList.stageList.put(token, stage);
	}
}
