package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_17CreateContacts {

	

	public static void main(String []args) throws IOException, InterruptedException
	{
		// using property file
		    FileUtility file=new FileUtility();
		    String url=file.getpropertykeyvalue("url");
		    String username=file.getpropertykeyvalue("username");
		    String password=file.getpropertykeyvalue("password");
		    WebDriver driver=new ChromeDriver();
		    
			driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).submit();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//			Actions a=new Actions(driver);
//			WebElement target = driver.findElement(By.xpath("//img[@src='themes/images/findduplicates.gif']"));
//			a.moveToElement(target).perform();
			driver.findElement(By.xpath("//img[@src='themes/images/findduplicates.gif']")).click();
			
//			Thread.sleep(3000);
//			Actions a3=new Actions(driver);
//			WebElement target3 = driver.findElement(By.xpath("//input[@type='submit']"));
//			a3.moveToElement(target3).perform();
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			WebDriverUtility web=new WebDriverUtility();
			//Actions a1=new Actions(driver);
			WebElement target1=driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
			//a1.moveToElement(target1).perform();
			web.mouseOver(driver,target1);
			driver.findElement(By.linkText("Sign Out")).click();
}
}