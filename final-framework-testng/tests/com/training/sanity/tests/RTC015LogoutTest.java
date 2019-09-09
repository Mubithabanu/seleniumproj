package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
import com.training.pom.RTC015LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC015LogoutTest{

	private WebDriver driver;
	private String baseUrl;
	private RTC011LoginPOM login;
	private RTC015LogoutPOM logout;
	private static Properties properties;
	private ScreenShot screenShot;
	private Boolean title;
	private Boolean loginlnk;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		login = new RTC011LoginPOM(driver); 
		logout = new RTC015LogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	

	@Test
	public void validLoginTest() {
		//login with admin credentials
		
		login.clickSigninlnk();
		login.sendUserName("admin");
		login.sendPassword("adminuser@12345");
		login.clickSigninBtn(); 
		
		//Login Screen screenshot
		screenShot.captureScreenShot("login screen_ELTC015");
		
		//Test scenario
		logout.moverAdminlnk();
		logout.logoutlnkclick();
		
		//Logout screen screenshot
		screenShot.captureScreenShot("logout screen_ELTC015");
		//logout.logoutconfirmlnkclick();
	
		loginlnk = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/my-profile/']")).isDisplayed();
		System.out.println(loginlnk);
		
		//Assertion for logout		
		Assert.assertTrue(loginlnk,"Logged out successfully");	
		
}
}

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

