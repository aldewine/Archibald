package com.archibald.service.impl;

import org.springframework.stereotype.Service;

import com.archibald.domain.Robot;
import com.archibald.domain.Direction;
import com.archibald.domain.Stage;
import com.archibald.domain.StageList;
import com.archibald.domain.Table;

@Service("InitializeStageService")
public class InitializeStageService implements com.archibald.service.inter.InitializeStageService{
	
	public void initializeStage(int dimensionX, int dimensionY, int posX, int posY, Direction direction) {
		Table table = new Table(dimensionX, dimensionY);
		Robot archie = new Robot(posX, posY, direction);
		Stage stage = new Stage(archie, table);
		StageList.stageList.put("Temp", stage);
	}
}
