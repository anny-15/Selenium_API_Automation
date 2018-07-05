package com.qa.test;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.Testbase;
import com.qa.clinet.RestClient;
import com.qa.util.TestUtil;

public class TestGetcall extends Testbase{
	Testbase testbase;
	String url;
	String seviceurl;
	RestClient client;
	
	
	@BeforeMethod
	public void setup()
	{
		testbase = new Testbase();
	    url=prop.getProperty("Url");  
	    seviceurl= prop.getProperty("Serviceurl");
		
	}
	
	@Test
	public void getAPITestwithHeaders() throws ClientProtocolException, IOException
	
	{
		
		/*Map<String, String> hashmap = new HashMap<String,String>();
		hashmap.put("Content-Type", "application/json");*/
		String URI= url+seviceurl;
		 client = new RestClient();
		 CloseableHttpResponse closable =client.get(URI);
		//get the status 
		int statuscode = closable.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode,200);
		System.out.println("staus is"+statuscode);
		
		
		String responseobject = EntityUtils.toString(closable.getEntity(),"UTF-8");
		//get the json response
		JSONObject jsonobj = new JSONObject(responseobject);
		System.out.println("json response is"+jsonobj);
		String per_page=TestUtil.getValueByJpath(jsonobj,"/per_page");
	    System.out.println(per_page); 
	    Assert.assertEquals(per_page,"3");
	    String total_page=TestUtil.getValueByJpath(jsonobj,"/total");
	    System.out.println(total_page); 
	    Assert.assertEquals(total_page,"12");
	    
	    //get value form json array
	    String lastname=TestUtil.getValueByJpath(jsonobj,"/data[0]/last_name");
	   //String id=TestUtil.getValueByJpath(jsonobj,"/data[0]/id");
	    //String firstname=TestUtil.getValueByJpath(jsonobj,"/data[0]/first_name");
	   // String avatar=TestUtil.getValueByJpath(jsonobj,"/data[0]/avatar");
	    
	    //System.out.println("lastname"+lastname+"id"+id+"firstname"+firstname+"avatar"+avatar);
		//get the header
		Header[] headerarray = closable.getAllHeaders();
		HashMap<String, String> headerhashmap = new HashMap<String, String>();
		
		for(Header header:headerarray)
		{
			headerhashmap.put(header.getName(), header.getValue());
			
		}
		
		System.out.println("header value"+headerhashmap);
		
		
	}
	
	

}
