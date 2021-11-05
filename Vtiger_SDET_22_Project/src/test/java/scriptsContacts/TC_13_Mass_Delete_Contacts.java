package scriptsContacts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomrepositorylib.Contacts;
import com.crm.vtiger.pomrepositorylib.ContactsInfo;
import com.crm.vtiger.pomrepositorylib.HomePage;
import com.crm.vtiger.pomrepositorylib.LogIn;

public class TC_13_Mass_Delete_Contacts extends BaseClass {
	
	@Test
	public void Mass_Delete_Contacts() throws IOException, InterruptedException {
		
		
		
		/*step 1: navigate to contacts page*/
		HomePage home=new HomePage(driver);
		home.getContactsLink().click();
		
		/*step 2: Select All Contacts and Delete all */
		Contacts cp=new Contacts(driver);
		cp.getAllSelectChkBox().click();
		cp.DeleteAllContact();
		wUtil.acceptAlert(driver);
		
		/*step 3: Verification*/
		Contacts conp=new Contacts(driver);
		//wUtil.waitForElementVisibility(driver, conp);
		String ExpectedMsg="No contact Found";
		String actSucMsg = conp.getAllDeletedMsg().getText();
		Assert.assertTrue(actSucMsg.contains(ExpectedMsg));
		System.out.println("========Contacts Created Successfull=========");


		
		
	}

}
