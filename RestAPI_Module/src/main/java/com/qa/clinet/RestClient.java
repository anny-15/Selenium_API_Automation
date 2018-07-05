package com.qa.clinet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
	
	public CloseableHttpResponse closable ;
	//1 get call method without headers
	public CloseableHttpResponse get(String URL) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(URL);//http get request
		
		closable = httpclient.execute(httpget);//hit the get url
		return closable;
		
	}
	//2 get call method with headers
		public CloseableHttpResponse get(String URL,Map<String, String> hashmap) throws ClientProtocolException, IOException
		{
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(URL);//http get request
			for(Map.Entry<String, String> entry:hashmap.entrySet())
			{
				httpget.addHeader(entry.getKey(),entry.getValue());
			}
			closable = httpclient.execute(httpget);//hit the get url
			return closable;
			
		}

	
	
}
