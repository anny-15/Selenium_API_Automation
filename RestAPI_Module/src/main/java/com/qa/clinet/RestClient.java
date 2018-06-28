package com.qa.clinet;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient  {
	
	//get call method
	public void get(String URL) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(URL);//http get request
		
		CloseableHttpResponse closable = httpclient.execute(httpget);//hit the get url
		int statuscode = closable.getStatusLine().getStatusCode();
		//get the status 
		System.out.println("staus is"+statuscode);
		String responseobject = EntityUtils.toString(closable.getEntity(),"UTF-8");
		//get the json response
		JSONObject jsonobj = new JSONObject(responseobject);
		
		System.out.println("json response is"+jsonobj);
		
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
