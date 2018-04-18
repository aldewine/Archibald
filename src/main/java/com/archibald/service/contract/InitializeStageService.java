package com.archibald.service.contract;

import com.archibald.service.input.InitializeStageInput;
import com.archibald.service.output.ServiceOutput;

public interface InitializeStageService {
	
	public ServiceOutput initializeStage(InitializeStageInput input, String token);
}
