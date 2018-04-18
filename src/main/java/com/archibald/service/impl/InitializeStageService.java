package com.archibald.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.archibald.domain.Robot;
import com.archibald.domain.Stage;
import com.archibald.domain.StageList;
import com.archibald.domain.Table;
import com.archibald.service.input.InitializeStageInput;
import com.archibald.service.output.ServiceOutput;

@Service
public class InitializeStageService implements com.archibald.service.contract.InitializeStageService{
	private static final Logger logger = LoggerFactory.getLogger(InitializeStageService.class);
	
	public ServiceOutput initializeStage(InitializeStageInput input, String token) {
		Table table = new Table(input.getDimensionX(), input.getDimensionY());
		Robot archie = new Robot(input.getPosX(), input.getPosY(), input.getDirection());
		Stage stage = new Stage(archie, table);
		StageList.stageList.put(token, stage);
		
		logger.info("Stage is initialized with dimensions x:" + input.getDimensionX() + 
				    ", y:" + input.getDimensionY() + " Archibald is located at x:" + input.getPosX() +
				    ", y:" + input.getPosY() + " direction:" + input.getDirection());
		
		return new ServiceOutput("0", "Successful.");
	}
}
