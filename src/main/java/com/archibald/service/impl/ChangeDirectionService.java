package com.archibald.service.impl;

import org.springframework.stereotype.Service;

import com.archibald.domain.Direction;
import com.archibald.domain.Robot;
import com.archibald.domain.Rotation;
import com.archibald.domain.Stage;
import com.archibald.domain.StageList;

@Service("ChangeDirectionService")
public class ChangeDirectionService implements com.archibald.service.inter.ChangeDirectionService{

	public void changeDirection(String token, Rotation rotation) {
		Stage stage = StageList.stageList.get(token);
		Robot robot = stage.getRobot();
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
		stage.setRobot(robot);
		StageList.stageList.put(token, stage);
	}
}
