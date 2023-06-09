package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	private FileInputStream stream=null;
	private Properties propertyFile=null;
	
	public  Properties loadFile(String filename){
		propertyFile = new Properties();
		String  PropertyFilePath=null;
		switch(filename) {
		case "applicationDataProperties":
			PropertyFilePath =Constants.APPLICATION_PROPERTIES;
							break;
		
		}
		try {
			stream=new FileInputStream(PropertyFilePath);
			propertyFile.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyFile;
	}
	
	public String getPropertyValue(String Key) {//,Properties file
		
		String value = propertyFile.getProperty(Key);
		//System.out.println("Property we got from the file is::" + value);
		try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	/*
	 * public int getPropertyValue(int Key) {//,Properties file
	 * 
	 * int value = propertyFile.getProperty(Key);
	 * //System.out.println("Property we got from the file is::" + value); try {
	 * stream.close(); } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return value; }
	 */
	
	
	

	 

	/*
	 * public static String readPropertyFile(String key) throws IOException {
	 * FileInputStream fs = new FileInputStream(Constants.APPLICATION_PROPERTIES);
	 * Properties propertyFile = new Properties();
	 * 
	 * propertyFile.load(fs); String value = propertyFile.getProperty(key);
	 * 
	 * return value;
	 * 
	 * }
	 */

	

	



}