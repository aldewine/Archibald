package com.archibald.archibald;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.archibald.domain.Direction;
import com.archibald.domain.Rotation;
import com.archibald.service.inter.ChangeDirectionService;
import com.archibald.service.inter.InitializeStageService;
import com.archibald.service.inter.MoveService;
import com.archibald.service.inter.ReportService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArchibaldApplicationTests {

	@Autowired(required = true)
	InitializeStageService initStageService;
	
	@Autowired(required = true)
	ChangeDirectionService changeDirectionService;
	
	@Autowired(required = true)
	MoveService moveService;
	
	@Autowired(required = true)
	ReportService reportService;
	
	@Test
	public void contextLoads() {
		initStageService.initializeStage(10, 10, 5, 5, Direction.NORTH);
		System.out.println(reportService.report("Temp"));
		moveService.move("Temp");
		System.out.println(reportService.report("Temp"));
		changeDirectionService.changeDirection("Temp", Rotation.LEFT);
		System.out.println(reportService.report("Temp"));
		moveService.move("Temp");
		System.out.println(reportService.report("Temp"));
	}
}
