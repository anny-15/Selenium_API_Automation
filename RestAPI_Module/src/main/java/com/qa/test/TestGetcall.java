package com.qa.test;


import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.Testbase;
import com.qa.clinet.RestClient;

public class TestGetcall extends Testbase{
	Testbase testbase;
	String url;
	String seviceurl;
	
	
	
	@BeforeMethod
	public void setup()
	{
		testbase = new Testbase();
	    url=prop.getProperty("Url");  
	    seviceurl= prop.getProperty("Serviceurl");
		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException
	
	{
		String URI= url+seviceurl;
		RestClient client = new RestClient();
		client.get(URI);
		
	}
	
	

}
