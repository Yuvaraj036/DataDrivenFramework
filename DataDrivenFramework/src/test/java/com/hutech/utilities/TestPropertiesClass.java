package com.hutech.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class TestPropertiesClass {

	public static void main(String[] args) throws Exception {
		
		System.getProperty("user.dir");
		
		Properties config=new Properties();
		
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\properties\\Config.properties");
		config.load(fis);
		
		
		
		
		
		
	}

}
