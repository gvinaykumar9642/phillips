package scriptsContacts;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_01_05 {
/*	
	@Test(priority=1)
	public void tc_01_create_contact_without_mandatory_fields() throws IOException {
		
		WebDriverUtility wUtil=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		wUtil.waitUntilPageLoad(driver);
		
		
		// reading the data from property file by using generic file
		FileUtility file=new FileUtility();
		String Url = file.getPropertyKeyValue("url");
		String Username = file.getPropertyKeyValue("username");
		String Password = file.getPropertyKeyValue("password");
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement name = driver.findElement(By.name("salutationtype"));
		wUtil.SelectOption(name, "Mr.");
		
		ExcelUtility excel=new ExcelUtility();
		String FirstName = excel.getExcelData("Sheet1", 1, 1);
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		
		//save contancts
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Alert act = driver.switchTo().alert();
		String Text = act.getText();
		wUtil.acceptAlert(driver);
		String ExpectedTitle = "Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		String ActualTitle = driver.getTitle();
		SoftAssert as=new SoftAssert();
		as.assertEquals(ExpectedTitle, ActualTitle);
		{
			System.out.println(Text);
		}
		
		
		//to logout
		WebElement target = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		wUtil.mouseOver(driver, target);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		as.assertAll();
		
	}*/
	
	@Test(priority=1)
	public void tc_02_select_atleast_one_existing_organisation() throws IOException {
		
		WebDriverUtility wUtil=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		wUtil.waitUntilPageLoad(driver);
		
		
		// reading the data from property file by using generic file
		FileUtility file=new FileUtility();
		String Url = file.getPropertyKeyValue("url");
		String Username = file.getPropertyKeyValue("username");
		String Password = file.getPropertyKeyValue("password");
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement name = driver.findElement(By.name("salutationtype"));
		wUtil.SelectOption(name, "Mr.");
		
		ExcelUtility excel=new ExcelUtility();
		String LastName = excel.getExcelData("Sheet1", 4, 2);
		String FirstName = excel.getExcelData("Sheet1", 4, 1);
		driver.findElement(By.name("lastname")).sendKeys(LastName+JavaUtility.getRandomData());
		
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		
		
	}

}
