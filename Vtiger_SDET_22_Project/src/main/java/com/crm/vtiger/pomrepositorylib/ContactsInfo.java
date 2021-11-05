package com.crm.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class ContactsInfo extends WebDriverUtility {
	WebDriver driver;
	public ContactsInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement successfullMsg;
	
	@FindBy(name = "Edit")
	private WebElement EdtParticularCont;
	
	@FindBy(name = "Delete")
	private WebElement DelParticularCont;
	
	public WebElement getEdtParticularCont() {
		return EdtParticularCont;
	}



	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}
	
	
	
	public WebElement getDelParticularCont() {
		return DelParticularCont;
	}

	public void deleteParticularContact() {
		acceptAlert(driver);
	}
}
