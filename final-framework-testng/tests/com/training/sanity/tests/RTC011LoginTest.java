package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTC011LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC011LoginTest {

	private WebDriver driver;
	private String baseUrl;
	private RTC011LoginPOM login;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebElement admintxt;
	private Boolean title;
	private String pagetitle;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		login = new RTC011LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		
	}
	
	@AfterMethod
	public void tearDown()  {
		//Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		
		//actual test scenario
		login.clickSigninlnk();
		login.sendUserName("admin");
		login.sendPassword("adminuser@12345");
		login.clickSigninBtn(); 
		
		//capture screenshot of admin dashboard
		screenShot.captureScreenShot("First");
		
		//Getting admin text for validation 
		String actualtext = "admin";
		admintxt = driver.findElement(By.xpath("//a[contains(text(),'Howdy,')]"));
		String expectedtext = admintxt.getText();
		System.out.println(expectedtext);
	
		//Assertion for login 
		Assert.assertTrue(expectedtext.contains(actualtext),"Logged in successfully");
	    
	}
}

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

