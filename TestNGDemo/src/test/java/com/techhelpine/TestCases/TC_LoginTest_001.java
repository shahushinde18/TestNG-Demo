package com.techhelpine.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techhelpline.PageObjects.LoginPage;

//actual test case to login application
public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException, InterruptedException {
		System.out.println("In Login Test Executin Method!!!");

		// create login Page class object to access their properties
		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUserName(appUserName);
		System.out.println("Successfully entered the username!!!!");

		loginPage.setPassword(appPassword);
		System.out.println("Successfully entered the Password!!!!");

		loginPage.clickSubmit();
		
		Thread.sleep(3000);
		
		System.out.println("Successfully Clicked On Submit button!!!!");

		// check if test cases is passed or failed based on some condition
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			//if test will pass
			System.out.println("Test case passed!!!");
			captureScreenShot(driver, "LoginTestCase");
			Assert.assertTrue(true);

		} else {
			
			System.out.println("Test case Failed!!!");
			Assert.assertTrue(false);
		}

		// to logout app
		loginPage.clickLogout();

		// to accept logout popup window
		driver.switchTo().alert().accept();
	}

}
