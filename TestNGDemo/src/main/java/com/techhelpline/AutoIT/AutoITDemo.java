package com.techhelpline.AutoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {

	//app url
	String appURL = "https://www.remove.bg/";
	
	//script path
	String scriptPath="D:\\Practise\\AutoIT\\FileUpload.exe";

	WebDriver driver;
	ChromeOptions options;
		
	@Test
	public void uploadFileUsingAutoIT() throws InterruptedException, IOException
	{
		System.out.println("In File Upload Method!!!");
		Thread.sleep(3000);
		
		//till now we have opened URL now we need to click on choose button
		//so let's take Xpath of choose element
		
		driver.findElement(By.xpath("//*[@id='page-content']/section[1]/div[4]/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/button"));
		Thread.sleep(3000);
		//After clicking will get windows pop up to select the file from dir and
		//that part we have to handle by using AutoIT Script
		//So let's write script in AutoIT script editor
		
		//Now will call that script here by using below code
		//so just we need to import Runtime class and pass the script name with path
		Runtime.getRuntime().exec(scriptPath);	
				
		Thread.sleep(5000);
		
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("In setup method!!!!");
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors"); // I am adding this to ignore SSL cert
		driver=new ChromeDriver(options);
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

}
