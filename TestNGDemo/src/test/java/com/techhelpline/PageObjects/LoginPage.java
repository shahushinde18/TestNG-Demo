package com.techhelpline.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//To store element values
public class LoginPage {

	WebDriver lDriver;

	// constructor
	public LoginPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	// username
	@FindBy(name = "uid")
	WebElement textUserName;

	// password
	@FindBy(name = "password")
	WebElement textPassword;

	// to click on submit button
	@FindBy(name = "btnLogin")
	WebElement btnLogin;

	// To Logout
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement btnLogout;

	// method for SetUserName
	public void setUserName(String uName) {
		textUserName.sendKeys(uName);
	}

	// method for SetPassword
	public void setPassword(String password) {
		textPassword.sendKeys(password);
	}

	// method for submit
	public void clickSubmit() {
		btnLogin.click();
	}

	// method for logout
	public void clickLogout() {
		btnLogout.click();
	}

}
