package com.crm.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {
	WebDriver driver;
	public CreateNewContact(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name = "lastname")
	private WebElement LastName;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement AssignedToRdBtn;
	
	@FindBy(name = "assigned_group_id")
	private WebElement AssignedDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	public WebElement getContactLastName() {
		return LastName;
	}

	public WebElement getAssignedToRdBtn() {
		return AssignedToRdBtn;
	}
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createContact(String contactLastName) {
		LastName.sendKeys(contactLastName);
		
		
	}
	public void createAssignTo(String assignTo) {
		AssignedDropDown.sendKeys(assignTo);
		
	}
	
	

}
