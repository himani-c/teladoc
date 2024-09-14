package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties prop;
	

	public Properties readFile()
	{
	try {
		
		String path=System.getProperty("user.dir");		
		prop=new Properties();
		FileInputStream fis=new FileInputStream(path+"\\src\\test\\resources\\configurations\\config.properties");
		prop.load(fis);
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
	}
	
	
}
