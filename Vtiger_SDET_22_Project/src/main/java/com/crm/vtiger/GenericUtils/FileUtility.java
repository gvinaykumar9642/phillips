package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * 
 * @author ARIJIT
 *
 */
public class FileUtility {
	
	/**
	 * The method used to read data from properties and return the value based on key specific
	 * @param Key
	 * @param path
	 * @return
	 * @throws IOException
	 */
	
	public String getPropertyKeyValue(String Key) throws IOException {
		
		FileInputStream file=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties prop=new Properties();
		prop.load(file);
		return prop.getProperty(Key);
		
	}
	
	/**
	 * This method will return json value based on json key
	 * @param jsonKey
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public String getDataFromJson(String jsonKey) throws IOException, ParseException {
		FileReader reader=new FileReader(IPathConstant.JSONFILELEPATH);
		JSONParser parser=new JSONParser();
		Object object=parser.parse(reader);
		JSONObject jsonObject=(JSONObject) object;
		String value=jsonObject.get(jsonKey).toString();
		return value;
	}


}
