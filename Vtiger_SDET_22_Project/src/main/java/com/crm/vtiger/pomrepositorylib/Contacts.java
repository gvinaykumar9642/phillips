package com.crm.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class Contacts extends WebDriverUtility {
	WebDriver driver;
	public Contacts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactImg;
	
	@FindBy(name = "selectall")
	private WebElement allSelectChkBox;
	
	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement DeleteBtn;
	
	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}
	@FindBy(partialLinkText = "No Contact Found !")
	private WebElement allDeletedMsg;
	
	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	public WebElement getAllDeletedMsg() {
		return allDeletedMsg;
	}

	public WebElement getAllSelectChkBox() {
		return allSelectChkBox;
	}
	
	public void DeleteAllContact() {
		
		DeleteBtn.click();
		
			}
	public void DeletedMsg() {
		String ActualMsg = allDeletedMsg.getText();
		
	}
}
