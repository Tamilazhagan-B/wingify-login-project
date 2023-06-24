package com.wingify.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "log-in")
	private WebElement login;
	
	@FindBy(xpath = "//div[@class='alert alert-warning']")
	private WebElement errormsg;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement userName() {
		return username;
	}
	
	public WebElement passWord() {
		return password;
	}
	
	public WebElement logIn() {
		return login;
	}
	
	public WebElement errorMsg() {
		return errormsg;
	}
	
	
	
	
}
