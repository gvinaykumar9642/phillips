package com.crm.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContactInfo {
	WebDriver driver;
	public EditContactInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement LastNameEdtp;
	
	public WebElement getLastNameEdtp() {
		return LastNameEdtp;
	}
	
	public void clearContact() {
		LastNameEdtp.clear();	
	}
	public void editContact(String editedContact) {
		LastNameEdtp.sendKeys(editedContact);
	}
}
