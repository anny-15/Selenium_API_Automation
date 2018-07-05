package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Testbase {

	public Properties prop;
	
	public  Testbase()
	{
		
		prop = new Properties();
			try {
				prop.load(new FileInputStream("C:\\Automation\\RestAPI_Module\\src\\main\\java\\com\\qa\\config\\config.properties"));
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
