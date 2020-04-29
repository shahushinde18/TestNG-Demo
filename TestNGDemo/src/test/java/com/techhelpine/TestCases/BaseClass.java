package com.techhelpine.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

//To keep common methods
public class BaseClass {

	String appURL = "https://demo.guru99.com/v4/";
	String appUserName = "mngr47659";
	String appPassword = "123456@";

	WebDriver driver;
	ChromeOptions options;

	@BeforeClass
	public void setup() {
		System.out.println("In setup method!!!!");

		// To handle SSL Certificate
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		System.setProperty("webdriver.chrome.driver", "./" + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		System.out.println("In Tear Down Method!!!!");
		if (driver != null)
			driver.quit();
	}
	
	//pass parameters as driver and screenshot name
	public void captureScreenShot(WebDriver driver, String Name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		//Here we need to create dest path
		File dest=new File("./" + "/Screenshots/" +Name +".png");
		FileUtils.copyFile(src, dest);
		System.out.println("Successfully capture screenshot!!!!!!!");		
	}
	
	
	
	
}
