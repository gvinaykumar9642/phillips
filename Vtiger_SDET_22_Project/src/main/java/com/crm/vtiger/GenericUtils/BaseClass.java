package com.crm.vtiger.GenericUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.vtiger.pomrepositorylib.HomePage;
import com.crm.vtiger.pomrepositorylib.LogIn;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ExcelUtility eUtil=new ExcelUtility();
	public FileUtility fileUtility=new FileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver staticDriver;//null
	
	@Parameters(value= {"browser"})	//chrome,firefox
	@BeforeClass(groups= {"smoketest","regression"})
	public void launchBrowser(@Optional("chrome") String browserValue) throws IOException {
		/*read data from property file*/
		//String BROWSER = fileUtility.getPropertyKeyValue("browser");
		String URL = fileUtility.getPropertyKeyValue("url");
		/*launch browser*/
		if(browserValue.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(); 
		}else if(browserValue.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("Invalid browser name");
		}
		System.out.println("=============Browser Launch Successfully============");
		staticDriver=driver;// assigning driver reference
		wUtil.waitUntilPageLoad(driver);
		driver.get(URL);
	}
		
		@BeforeMethod(groups= {"smoketest","regression"})
		public void logInApp() throws IOException {
			/*read data from property file*/
			String USERNAME = fileUtility.getPropertyKeyValue("username");
			String PASSWORD = fileUtility.getPropertyKeyValue("password");
			
			//LogIn App
			LogIn lp=new LogIn(driver);
			lp.LoginToApp(USERNAME, PASSWORD);
			System.out.println("============Log In Successfully===========");
		}
		@AfterMethod(groups= {"smoketest","regression"})
		public void logOutApp() throws InterruptedException {
			//signout
			HomePage hp=new HomePage(driver);
			hp.logout();
			System.out.println("============Sign out Successfully===========");
		}
		@AfterClass(groups= {"smoketest","regression"})
		public void closeBrowser() {
			driver.close();
			System.out.println("==========Browser Closed=================");
		}
		

}
