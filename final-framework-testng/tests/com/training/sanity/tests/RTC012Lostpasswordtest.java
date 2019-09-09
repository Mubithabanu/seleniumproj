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
import com.training.pom.RTC012LostpasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC012Lostpasswordtest {

	private WebDriver driver;
	private String baseUrl;
	private RTC011LoginPOM login;
	private RTC012LostpasswordPOM lstpswd;
	private static Properties properties;
	private ScreenShot screenShot;
	private Boolean title;
	private Boolean errorpage;


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
		lstpswd = new RTC012LostpasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		login.clickSigninlnk();
		lstpswd.lostpswdclick();
		lstpswd.sendEmail("mubithabanujaffar@gmail.com");
		lstpswd.clickResetBtn();
		screenShot.captureScreenShot("Lostpassword");
		
		errorpage = driver.findElement(By.xpath("//body[@id='error-page']")).isDisplayed();
	
		
		//Assertion for logout		
		Assert.assertTrue(errorpage,"Error in sending mail");	
	    
	}
}

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

