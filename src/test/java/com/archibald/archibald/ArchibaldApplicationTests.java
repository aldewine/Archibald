package com.archibald.archibald;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.archibald.domain.Direction;
import com.archibald.domain.Rotation;
import com.archibald.service.contract.ChangeDirectionService;
import com.archibald.service.contract.InitializeStageService;
import com.archibald.service.contract.MoveService;
import com.archibald.service.contract.ReportService;
import com.archibald.service.input.InitializeStageInput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArchibaldApplicationTests {

	@Autowired
	InitializeStageService initStageService;
	
	@Autowired
	ChangeDirectionService changeDirectionService;
	
	@Autowired
	MoveService moveService;
	
	@Autowired
	ReportService reportService;
	
	@Test
	public void happyPath() {
		InitializeStageInput input = new InitializeStageInput();
		input.setDimensionX(10);
		input.setDimensionY(10);
		input.setPosX(1);
		input.setPosY(1);
		input.setDirection(Direction.NORTH);
		
		initStageService.initializeStage(input, "Temp");
		moveService.move("Temp");
		changeDirectionService.changeDirection("Temp", Rotation.LEFT);
		moveService.move("Temp");
		moveService.move("Temp");
	}
	
	@Test(expected = IllegalStateException.class)
	public void badInitX() {
		InitializeStageInput input = new InitializeStageInput();
		input.setDimensionX(10);
		input.setDimensionY(10);
		input.setPosX(11);
		input.setPosY(1);
		input.setDirection(Direction.NORTH);
		
		initStageService.initializeStage(input, "Temp");
	}
	
	@Test(expected = IllegalStateException.class)
	public void badInitY() {
		InitializeStageInput input = new InitializeStageInput();
		input.setDimensionX(10);
		input.setDimensionY(10);
		input.setPosX(1);
		input.setPosY(11);
		input.setDirection(Direction.NORTH);
		
		initStageService.initializeStage(input, "Temp");
	}
	
	@Test(expected = IllegalStateException.class)
	public void badInitNegativeX() {
		InitializeStageInput input = new InitializeStageInput();
		input.setDimensionX(10);
		input.setDimensionY(10);
		input.setPosX(-1);
		input.setPosY(1);
		input.setDirection(Direction.NORTH);
		
		initStageService.initializeStage(input, "Temp");
	}
	
	@Test(expected = IllegalStateException.class)
	public void badInitNegativeY() {
		InitializeStageInput input = new InitializeStageInput();
		input.setDimensionX(10);
		input.setDimensionY(10);
		input.setPosX(1);
		input.setPosY(-1);
		input.setDirection(Direction.NORTH);
		
		initStageService.initializeStage(input, "Temp");
	}
	
	@Test(expected = IllegalStateException.class)
	public void negativeStageInitX() {
		InitializeStageInput input = new InitializeStageInput();
		input.setDimensionX(-10);
		input.setDimensionY(10);
		input.setPosX(1);
		input.setPosY(1);
		input.setDirection(Direction.NORTH);
		
		initStageService.initializeStage(input, "Temp");
	}
	
	@Test(expected = IllegalStateException.class)
	public void negativeStageInitY() {
		InitializeStageInput input = new InitializeStageInput();
		input.setDimensionX(10);
		input.setDimensionY(-10);
		input.setPosX(1);
		input.setPosY(1);
		input.setDirection(Direction.NORTH);
		
		initStageService.initializeStage(input, "Temp");
	}
}
