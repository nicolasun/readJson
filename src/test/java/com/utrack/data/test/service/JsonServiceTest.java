package com.utrack.data.test.service;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import com.utrack.data.model.DCLResponse;
import com.utrack.data.service.JsonService;
import com.utrack.data.test.config.SpringTestConfiguration;

@SpringJUnitWebConfig(SpringTestConfiguration.class)
public class JsonServiceTest {

	private JsonService jsonService;
	
	@Test
	public void jsonObejctTest() {
		
		DCLResponse a = jsonService.jsonToObject();
		
		assertNotEquals(null,a);
	}
}
