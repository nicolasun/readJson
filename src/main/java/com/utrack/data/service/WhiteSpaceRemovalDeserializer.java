package com.utrack.data.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.utrack.data.controller.HomeController;

public class WhiteSpaceRemovalDeserializer extends JsonDeserializer<String> {
	private static final Logger logger = LoggerFactory.getLogger(WhiteSpaceRemovalDeserializer.class);
	
    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException{
        // This is where you can deserialize your value the way you want.
        // Don't know if the following expression is correct, this is just an idea.
    	logger.info("remove all space");
        return jp.getCurrentToken().asString().trim();
        
    }

}
