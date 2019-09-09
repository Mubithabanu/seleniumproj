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
import com.training.pom.RTC014GeneratepasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC014Generatepasswordtest{

	private WebDriver driver;
	private String baseUrl;
	private RTC011LoginPOM login;
	private RTC014GeneratepasswordPOM genpswd;
	private static Properties properties;
	private ScreenShot screenShot;
	private Boolean title;
	private WebElement msgtext;
	private WebElement pswdstrength;

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
		genpswd = new RTC014GeneratepasswordPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
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
		genpswd.moverAdminlnk();
		genpswd.editprfllnk();
		genpswd.genpswdclick();
		genpswd.sendNewPassword("test@123456789");
		
		screenShot.captureScreenShot();
		
	    pswdstrength = driver.findElement(By.xpath("//div[@id='pass-strength-result']"));
	    String passwdstrength = pswdstrength.getText();
	    System.out.println(passwdstrength);
	    
	    if((passwdstrength.equalsIgnoreCase("weak")) || (passwdstrength.equalsIgnoreCase("Very weak"))) {
	    	genpswd.checkWeakpswd();
	    }
	    
	    genpswd.clickUpdtprofileBtn(); 
		
		//After Screenshot	
		screenShot.captureScreenShot();
		String actualtext = "Profile updated.";
		msgtext = driver.findElement(By.xpath("//strong[contains(text(),'Profile updated.')]"));
		String expectedtext = msgtext.getText();
		Assert.assertTrue(actualtext.equals(expectedtext),"Profile got updated successfully");;
		
}
}

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

