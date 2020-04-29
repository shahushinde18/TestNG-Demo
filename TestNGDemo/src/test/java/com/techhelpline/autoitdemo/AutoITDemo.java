package com.techhelpline.autoitdemo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {
	
	// I will show you which application we are using to upload the file.
	
	String url = "https://www.remove.bg/";  //so guys have copied url in this app we are uploading file using AutoIT
	//script, because w=in selenium we can not handle window based pop ups let's see
	//So this pop we have to handled let's write code
	
	String autoITScriptPath="D:\\Practise\\AutoIT\\fileUploadeScript.exe";
	WebDriver driver;
	ChromeOptions options;
	
	@Test
	public void uploadFileUsingAutoIT() throws InterruptedException, IOException
	{
		System.out.println("In file Upload method!!!!");
		
		//giving some wait
		Thread.sleep(3000);
		
		//till now we have opened URL now we need to click on select button
		// first will execute this part
		
		//Have seen ? so let's find out the expath of upload image button
		//so i have copied default x-path
		driver.findElement(By.xpath("//*[@id='page-content']/section[1]/div[4]/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/button")).click();
		
		Thread.sleep(2000);
		
		//so let's run this part so after clicking we got the windows pop up to upload the file right?
		//and that thing we have to handle by AutoIT script
		//so let's write AutoIT script in AutoIT script editor
		
		//from this tool will find element value and then will write script
		//so we have to use displayed details in screen
		
		//so guys we have written and complied AutoIT script now call that script here
		
		//so guys for that we have to just import one class here i.e Runtime
		Runtime.getRuntime().exec(autoITScriptPath);
	
		Thread.sleep(4000);
		
		//let's run the code
		
		//SO guys we have successfully uploaded the file using AutoIT
	}

	
	
	//first will create before class and after class methods
	
	@BeforeClass
	public void setup()
	{
		System.out.println("In setup method!!!!!");
		WebDriverManager.chromedriver().setup();
		options=new ChromeOptions();
		options.addArguments("--ignore-certificate-errors"); // to ignore the SSL certificate error
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("In Tear Down Method!!!!");
		if (driver !=null)
		{
			driver.close();
			driver.quit();
		}
	}
}
