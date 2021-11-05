package com.crm.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class LogIn extends WebDriverUtility {
	WebDriver driver;
	public LogIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="user_name")
	private WebElement usernameLogin;
	@FindBy(name="user_password")
	private WebElement pwdLogin;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginBtn;
	
	public WebElement getUsernameLogin() {
		return usernameLogin;
	}

	public WebElement getPwdLogin() {
		return pwdLogin;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void LoginToApp(String username, String password) {
		
		
		
		usernameLogin.sendKeys(username);
		pwdLogin.sendKeys(password);
		loginBtn.click();
	}

}
