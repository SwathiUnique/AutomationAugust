package com.examAPI.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.examAPI.constants.SourcePaths;





public class projectUtilities {
	
public static FileInputStream inputfile=null;
public static FileOutputStream outputfile = null;	
	public Properties loadFile(String filename) {
		
		Properties propertyFile = new Properties();
		String propertyFilepath = null;
		
		switch(filename) {
			case "baseURI" :
				propertyFilepath = SourcePaths.BASE_URI_PROPERTIES_PATH;
				break;
			case "createDetails" :
				propertyFilepath = SourcePaths.CREATE_DETAILS_PROPERTIES_PATH;
				break;
			case "updateDetails" :
				propertyFilepath = SourcePaths.UPDATE_DETAILS_PROPERTIES_PATH;
				break;
			case "deleteDetails" :
				propertyFilepath = SourcePaths.DELETE_DETAILS_PROPERTIES_PATH;
				break;
			default :
				System.out.println("Wrong file name");
		}
		try {
			inputfile = new FileInputStream(propertyFilepath);
			if(filename.equalsIgnoreCase("updateDetails")) {
				outputfile = new FileOutputStream(propertyFilepath,true); 
			}
			propertyFile.load(inputfile);
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		//System.out.println(filename +" loaded");
		return propertyFile;
	}
	
	
	public String getPropertyValue(String key, String filename) {
		Properties propertyFile = loadFile(filename);
		String value = propertyFile.getProperty(key);
		//System.out.println("We got "+value +" for "+key);
		try {
			inputfile.close();
		}catch(IOException e2) {
			e2.printStackTrace();
		}
		return value;  
	}
	public void setProperty(String key,String value, String filename) {
		Properties propertyFile = loadFile(filename);
		//if(filename.equalsIgnoreCase(filename))
		propertyFile.setProperty(key, value);
		try {
			propertyFile.store(outputfile, filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
