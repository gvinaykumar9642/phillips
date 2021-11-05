package com.crm.vtiger.pomrepositorylib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class HomePage  {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignoutLink;
	
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}
	public WebElement getContactsLink() {
		return ContactsLink;
	}
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
	public WebElement getSignoutLink() {
		return SignoutLink;
	}
	
	public void logout() throws InterruptedException {
		WebDriverUtility wUtil=new WebDriverUtility();
		wUtil.waitUntilPageLoad(driver);
		Thread.sleep(3000);
		wUtil.mouseOver(driver, AdministratorImg);
		SignoutLink.click();

	}

}
