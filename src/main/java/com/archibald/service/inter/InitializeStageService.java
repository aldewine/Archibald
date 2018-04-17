package com.archibald.service.inter;

import com.archibald.domain.Direction;

public interface InitializeStageService {
	
	public void initializeStage(int dimensionX, int dimensionY, int posX, int posY, Direction direction);
}
