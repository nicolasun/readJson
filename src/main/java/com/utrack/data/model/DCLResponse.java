package com.utrack.data.model;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.utrack.data.service.WhiteSpaceRemovalDeserializer;

import lombok.Data;

@Data
public class DCLResponse {

	private ArrayList<DCLDetails> results;
	
	 @JsonDeserialize(using=WhiteSpaceRemovalDeserializer.class)
	 public void setAString(String aString) {
	    // body
	 }
}
