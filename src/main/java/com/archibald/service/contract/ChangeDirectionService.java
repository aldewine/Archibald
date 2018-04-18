package com.archibald.service.contract;

import com.archibald.domain.Rotation;
import com.archibald.service.output.ServiceOutput;

public interface ChangeDirectionService {
	public ServiceOutput changeDirection(String token, Rotation rotation);
}
