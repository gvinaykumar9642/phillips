package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class FileUtility {
    /**
     * This is used to read data from properties and return the value based on key specified
     * @param key
     * @return
     * @throws IOException
     */
	/*
	 * author @ vinaykumaryadav
	 */
	@Test
	public String getpropertykeyvalue(String key) throws IOException
	{
		FileInputStream file=new FileInputStream(IpathContact.PROPERTY_FILEPATH);
		Properties prop=new Properties();
		prop.load(file);
		
		return prop.getProperty(key);
	}
	/**
	 * This is used to read data from json file and return the value based on key specified
	 * @param jsonkey
	 * @return
	 * @throws Throwable
	 */
	
	public String getDataFromJson(String jsonkey) throws Throwable
	{
		FileReader reader=new FileReader(IpathContact.JSONFILEPATH);
		JSONParser parser=new JSONParser();
		Object object=parser.parse(reader);
		JSONObject jsonObject= (JSONObject)object;
	    String value=jsonObject.get(jsonkey).toString();
		return value;
}
}