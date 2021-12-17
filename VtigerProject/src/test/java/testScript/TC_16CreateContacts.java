package testScript;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_16CreateContacts {
	
	@Test
	public void createcontact() throws IOException, InterruptedException
	//public static void main(String []args)  throws IOException, InterruptedException
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
			
			Thread.sleep(2000);
//			Actions a=new Actions(driver);
//			WebElement target=driver.findElement(By.xpath("//img[@alt='Last Viewed']"));
//			a.moveToElement(target).perform();
			driver.findElement(By.xpath("//img[@alt='Last Viewed']")).click();
			
			/*Actions a1=new Actions(driver);
			WebElement target1=driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
			a1.moveToElement(target1).perform();
			driver.findElement(By.linkText("Sign Out")).click();*/
			
			WebDriverUtility web=new WebDriverUtility();
			WebElement target1=driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
			web.mouseOver(driver,target1);
			driver.findElement(By.linkText("Sign Out")).click();
			
			
	}		
	}
	
	
			
			/*String title=driver.getCurrentUrl();
			SoftAssert a2=new SoftAssert();
			a2.assertEquals(title,"Administrator-home-vtiger CRM 5 - Commercial oOpen Source CRM");
			WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			//wb.mouseover(driver,signout);
			driver.findElement(By.xpath("//a[.='sign out']")).click();
			/*driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			driver.findElement(By.name("salutationtype")).sendKeys("Mr.");
			driver.findElement(By.name("firstname")).sendKeys("vinay");
			driver.findElement(By.name("lastname")).sendKeys("kumar");
			
			driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
			driver.findElement(By.name("mobile")).sendKeys("7989227895");
			
		/*	String pr = driver.getWindowHandle();
			Set<String> child = driver.getWindowHandles();
			int count = child.size();
			Iterator<String> itr = child.iterator();
			while(itr.hasNext()) {
				String cwh = itr.next();
				if(!pr.equals(cwh))
				{
					WebDriver a = driver.switchTo().window(cwh);
					System.out.println(a.getTitle());
					driver.findElement(By.name("search_text")).sendKeys("G vinaykumar2");
					driver.findElement(By.name("search")).click();
					driver.findElement(By.linkText("G vinaykumar2")).click();
					//driver.findElement(By.linkText("Orbinet Technology")).click();
			
				}  */
			/*Thread.sleep(2000);
			Actions a=new Actions(driver);
			WebElement target=driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
			a.moveToElement(target).perform();
			driver.findElement(By.linkText("Sign Out")).click();
	}
}
}*/