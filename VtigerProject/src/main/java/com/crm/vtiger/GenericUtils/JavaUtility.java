package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/*
	 * author @vinaykumaryadav
	 */
	/**
	 * This method is generate random number to avoid duplication
	 * @return
	 */
	public static String getRandomData()
	{
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}
	/**
	 * @vinaykumaryadav
	 * this method is used to generate currentdata
	 * @return currentdata
	 */
	public static String getCurrentData()
	{
		Date data=new Date();
		String currentdata=data.toString();
		return currentdata;
	}
}
