package com.archibald.service;

import org.springframework.stereotype.Service;

import com.archibald.domain.Archibald;
import com.archibald.domain.Direction;
import com.archibald.domain.Stage;
import com.archibald.domain.StageList;
import com.archibald.domain.Table;

@Service
public class InitializeStageService {
	
	public void initializeStage(int dimensionX, int dimensionY, int posX, int posY, Direction direction) {
		Table table = new Table(dimensionX, dimensionY);
		Archibald archie = new Archibald(posX, posY, direction);
		Stage stage = new Stage(archie, table);
		StageList.stageList.add(stage);
	}
}
