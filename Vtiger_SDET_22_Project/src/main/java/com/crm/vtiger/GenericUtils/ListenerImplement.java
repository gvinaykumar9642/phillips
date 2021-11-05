package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListenerImplement implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		EventFiringWebDriver takescreenshot=new EventFiringWebDriver(BaseClass.staticDriver);
		File source = takescreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./screenshot/"+result.getMethod().getMethodName()+"_"+JavaUtility.getCurrentDate()+".png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		/*
		 * String screenshotPath =
		 * System.getProperty("user.dir")+"//screenshot//"+result.getMethod().
		 * getMethodName()+"_"+JavaUtility.getCurrentDate()+".PNG"; File dest=new
		 * File(screenshotPath); try { Files.copy(source, dest); } catch(IOException e)
		 * { e.printStackTrace(); }
		 */
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
