package com.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 
public class PropertyReader {
	
	public String readProperty(String propertyName)
	{
		Properties prop=new Properties();//take single property like username
		String FilePath="C:\\Users\\dhrushil.panchal\\eclipse-workspace\\TestingFramework\\src\\test\\resources\\TestData.properties";
		FileInputStream fs; //data fetch from file
		
		try {
			fs=new FileInputStream(new File(FilePath));//giving file path to input stream
			prop.load(fs);//loading to property
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return prop.getProperty(propertyName);
		
	}
 
}