package com.utrack.data.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.utrack.data.test.config.SpringTestConfiguration;;


@SpringJUnitWebConfig(SpringTestConfiguration.class)
public class HomeControllerTest {
	
	private MockMvc mockMvc;
	
	@BeforeEach
    void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void home() throws Exception {
		
		  this.mockMvc.perform(get("/")) .andExpect(status().isOk())
		  .andExpect(view().name("home"));
		 
    }

}