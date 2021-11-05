package scriptsContacts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomrepositorylib.ContactsInfo;
import com.crm.vtiger.pomrepositorylib.CreateNewContact;
import com.crm.vtiger.pomrepositorylib.EditContactInfo;
import com.crm.vtiger.pomrepositorylib.HomePage;
import com.crm.vtiger.pomrepositorylib.LogIn;

public class TC_15_Edit_Contacts extends BaseClass{
	@Test(groups= {"regressiontest"})
	public void Edit_Contacts() throws IOException, InterruptedException {

		
		/*read test data*/
		String EditedLastName = eUtil.getExcelData("Contacts", 3, 1)+"_"+jUtil.getRandomData();
		
		/*step 3: navigate to contacts page*/
		HomePage home=new HomePage(driver);
		home.getContactsLink().click();
		
		
		/*step 4: select particular contact in row*/
		driver.findElement(By.xpath("//a[contains(text(),'piyush1_')]/../../../tr[5]/td[4]/a[1]")).click();
		
		/*step 5: click on particular contact to Edit*/
		ContactsInfo coinfop=new ContactsInfo(driver);
		coinfop.getEdtParticularCont().click();
		
		/*step 6: Edit for particular contact */
		EditContactInfo edtConInfo=new EditContactInfo(driver);
		edtConInfo.clearContact();
		edtConInfo.editContact(EditedLastName);
		CreateNewContact cncp=new CreateNewContact(driver);
		cncp.getSaveBtn().click();
		
		/*step 7: verify*/
		ContactsInfo coninfop=new ContactsInfo(driver);
		wUtil.waitForElementVisibility(driver, coninfop.getSuccessfullMsg());
		String actSucMsg = coninfop.getSuccessfullMsg().getText();
		Assert.assertTrue(actSucMsg.contains(EditedLastName));
		System.out.println("========Contacts Created Successfull=========");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//		ExcelUtility excel=new ExcelUtility();
//		WebDriverUtility wUtil=new WebDriverUtility();
//		
//		WebDriver driver=new ChromeDriver();
//		wUtil.waitUntilPageLoad(driver);
//		
//		// reading the data from property file by using generic file
//		FileUtility file=new FileUtility();
//		String Url = file.getPropertyKeyValue("url");
//		String Username = file.getPropertyKeyValue("username");
//		String Password = file.getPropertyKeyValue("password");
//		driver.get(Url);
//		driver.findElement(By.name("user_name")).sendKeys(Username);
//		driver.findElement(By.name("user_password")).sendKeys(Password);
//		driver.findElement(By.id("submitButton")).click();
//		
//		driver.findElement(By.linkText("Contacts")).click();
//		
//		//edit particular contact
//		driver.findElement(By.xpath("(//input[@name='selected_id'])[3]")).click();
//		driver.findElement(By.linkText("edit")).click();
//		driver.findElement(By.name("lastname")).clear();
//		String LastName = excel.getExcelData("Sheet1", 3, 2);
//		String FirstName = excel.getExcelData("Sheet1", 3, 1);
//		driver.findElement(By.name("lastname")).sendKeys(LastName+JavaUtility.getRandomData());
//		driver.findElement(By.name("firstname")).sendKeys(FirstName);
//		
//		//save contancts
//		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
//		
//		SoftAssert as=new SoftAssert();
//		String ExpectedTitle = "Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
//		String ActualTitle = driver.getTitle();
//		as.assertEquals(ExpectedTitle, ActualTitle);
//		{
//			System.out.println(FirstName+"Edited contact information must be present there");
//		}
//		as.assertAll();
//		
//		/*//to logout
//		WebElement target = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
//		wUtil.mouseOver(driver, target);
//		driver.findElement(By.linkText("Sign Out")).click();
//		driver.close();*/
//		
		
	}

}
