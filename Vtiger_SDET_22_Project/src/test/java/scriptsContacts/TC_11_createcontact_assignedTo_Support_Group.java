package scriptsContacts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomrepositorylib.Contacts;
import com.crm.vtiger.pomrepositorylib.ContactsInfo;
import com.crm.vtiger.pomrepositorylib.CreateNewContact;
import com.crm.vtiger.pomrepositorylib.HomePage;
import com.crm.vtiger.pomrepositorylib.LogIn;
/**
 * 
 * @author ARIJIT
 *
 */
@Listeners(com.crm.vtiger.GenericUtils.ListenerImplement.class)
public class TC_11_createcontact_assignedTo_Support_Group extends BaseClass {
	
	@Test(groups= {"smoketest"},invocationCount = 5)
	public void createcontact_assignedTo_Support_Group() throws IOException, InterruptedException {
		
	
		/*read test data*/
		String contactLastName = eUtil.getExcelData("Contacts", 1, 1)+"_"+jUtil.getRandomData();
		String assignedTo = eUtil.getExcelData("Contacts", 1, 3);
		
		
		/*step 1: navigate to contacts page*/
		HomePage home=new HomePage(driver);
		home.getContactsLink().click();
		
		/*step 2:navigate to "create contacts" page*/
		Contacts contPage=new Contacts(driver);
		contPage.getCreateContactImg().click();
		
		/*step 3: create Contact*/
		CreateNewContact cncp=new CreateNewContact(driver);
		cncp.createContact(contactLastName);
		cncp.getAssignedToRdBtn().click();
		cncp.createAssignTo(assignedTo);
		cncp.getSaveBtn().click();
		
		/*step 4: verify*/
		ContactsInfo coninfop=new ContactsInfo(driver);
		wUtil.waitForElementVisibility(driver, coninfop.getSuccessfullMsg());
		String actSucMsg = coninfop.getSuccessfullMsg().getText();
		//Assert.assertEquals("a", "b");
		
		  SoftAssert as= new SoftAssert();
		  as.assertTrue(actSucMsg.contains(contactLastName));
		  System.out.println("========Contacts Created Successfull=========");
		  as.fail(); as.assertAll();
		 
	}

}
