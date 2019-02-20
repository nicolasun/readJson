package com.utrack.data.test.utility;

import org.junit.Assert;
import org.junit.Test;

import com.utrack.data.utility.StringFormat;

public class StringFormatTest {

	@Test
	public void testString() {
		
		Assert.assertTrue(StringFormat.capital("AB").equals("Ab"));
		
		String a = null;
		Assert.assertTrue(StringFormat.capital(a)==a);
	}
	
}
