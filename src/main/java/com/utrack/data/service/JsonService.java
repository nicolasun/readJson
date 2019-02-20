package com.utrack.data.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.utrack.data.model.DCLResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class JsonService {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonService.class);
	
	@Value("${download.url}")
	private String url;
	
	public DCLResponse jsonToObject() {
		ObjectMapper mapper = new ObjectMapper();
		DCLResponse dclResponse = null;
		try{
			URL url = new URL(this.url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			int countConnect = 0;
			while((conn.getResponseCode()!=200)&&(countConnect < 3)) {
				Thread.sleep(5000/3);
				countConnect++;
			}
			if(countConnect > 2) {
				throw new ConnectException();
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			dclResponse = mapper.readValue(in, DCLResponse.class);
		}
		catch(IOException | InterruptedException e) {
			logger.error(e.getMessage());
		}
		return dclResponse;
		
	}
}
