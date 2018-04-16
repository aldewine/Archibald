package com.archibald.archibald;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.archibald.service.InitializeStageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArchibaldApplicationTests {

	@Autowired
	InitializeStageService initStageService;
	
	@Test
	public void contextLoads() {
		
	}

}
