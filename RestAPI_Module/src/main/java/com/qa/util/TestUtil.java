package com.qa.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtil {
	
	//public static JSONObject responsejson;
	
	public static String getValueByJpath(JSONObject responsejson,String jpath)
	{
		Object obj= responsejson;
		for(String s : jpath.split("/"))
			if(!s.isEmpty())
				if(s.contains("[")||s.contains("]"))
					obj=((JSONArray)((JSONObject)obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\]")[0].replace("]", "")));			

			else if(!s.contains("data[")||s.contains("]"))
					obj=((JSONObject)obj).get(s);
				 
		return obj.toString();
}
	
}
	


