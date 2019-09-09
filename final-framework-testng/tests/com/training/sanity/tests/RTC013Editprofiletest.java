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
import com.training.pom.RTC013EditprofilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC013Editprofiletest{

	private WebDriver driver;
	private String baseUrl;
	private RTC011LoginPOM login;
	private RTC013EditprofilePOM edtprfl;
	private static Properties properties;
	private ScreenShot screenShot;
	private Boolean title;
	private WebElement msgtext;

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
		edtprfl = new RTC013EditprofilePOM(driver); 
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
		login.sendUserName("Mubitha");
		login.sendPassword("test@123456789");
		login.clickSigninBtn(); 
		
		//Before screenshot
		screenShot.captureScreenShot();
		
		//Test scenario
		edtprfl.moverAdminlnk();
		edtprfl.editprfllnk();
		edtprfl.sendLastname("Testlastname");
		edtprfl.sendPhone("9080706050");
		edtprfl.clickUpdtprofileBtn(); 
		
		//After Screenshot	
		screenShot.captureScreenShot();
		String actualtext = "Profile updated.";
		msgtext = driver.findElement(By.xpath("//strong[contains(text(),'Profile updated.')]"));
		String expectedtext = msgtext.getText();
		Assert.assertTrue(actualtext.equals(expectedtext),"Profile got updated successfully");;
		
}
}

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

