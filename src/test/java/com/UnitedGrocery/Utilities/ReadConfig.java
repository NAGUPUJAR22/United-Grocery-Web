package com.UnitedGrocery.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig
{
    String path="C:\\workspace\\UNITED_GROCERY\\Configuration\\config.properties";
    
    Properties p;
	
	
	public ReadConfig()
	{
		p=new Properties();
		try
		{
			FileInputStream fis=new FileInputStream(path);
			try {
				p.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getbaseurl()
	{
		String value = p.getProperty("baseUrl");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("url is not specfied in config file");
		
		
	}
	
	public String getbrowser()
	{
		String value = p.getProperty("browser");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("browser is not specfied in config file");
		
	}
	
	public String getUsername()
	{
		String value = p.getProperty("un");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("username is not specfied in config file");
		
	}
	
	public String getPassword()
	{
		String value = p.getProperty("pw");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("password is not specfied in config file");
		
	}

}
