package scriptsContacts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomrepositorylib.Contacts;
import com.crm.vtiger.pomrepositorylib.ContactsInfo;
import com.crm.vtiger.pomrepositorylib.HomePage;
import com.crm.vtiger.pomrepositorylib.LogIn;

public class TC_14_Delete_Particular_Contact extends BaseClass {
	@Test
	public void Delete_Particular_Contact() throws IOException, InterruptedException {
		
		
		/*step 3: navigate to contacts page*/
		HomePage home=new HomePage(driver);
		home.getContactsLink().click();
		
		/*step 4: select particular contact in row*/
		driver.findElement(By.xpath("//a[contains(text(),'piyush1_')]/../../../tr[5]/td[4]/a[1]")).click();
		
		/*step 5: delete particular contact*/
		ContactsInfo coinfop=new ContactsInfo(driver);
		coinfop.getDelParticularCont().click();
		wUtil.acceptAlert(driver);
		
		
	}

}
