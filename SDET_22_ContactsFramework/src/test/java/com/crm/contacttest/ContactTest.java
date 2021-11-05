package com.crm.contacttest;

import org.testng.annotations.Test;

public class ContactTest {
	
	@Test(groups= {"smoketest"})
	public void ContactTest()
	{
		System.out.println("execuite create contact test");
		String URL=System.getProperty("url");
		System.out.println(URL);
		String BROWSER=System.getProperty("browser");
		System.out.println(BROWSER);
	}
	
	@Test(groups= {"regression"})
	public void editContactTest()
	{
		System.out.println("execuite edit contacttest");
	}

}
