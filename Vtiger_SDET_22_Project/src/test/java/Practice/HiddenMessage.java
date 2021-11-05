package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class HiddenMessage {
	@Test
	public void hiddenMessage() throws EncryptedDocumentException, IOException {
		
	WebDriver driver=new ChromeDriver();
	ExcelUtility eUtil=new ExcelUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	wUtil.waitUntilPageLoad(driver);
	String URL = eUtil.getExcelData("Contacts", 5, 1);
	driver.get(URL);
	WebElement toolTipBtn = driver.findElement(By.id("toolTipButton"));
	wUtil.mouseOver(driver, toolTipBtn);
	String InnerMsg = driver.findElement(By.className("tooltip-inner")).getText();
	driver.findElement(By.id("toolTipTextField")).sendKeys(InnerMsg);
	}

}
