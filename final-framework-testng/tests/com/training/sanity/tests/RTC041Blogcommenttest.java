package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTC011LoginPOM;
import com.training.pom.RTC041BlogcommentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC041Blogcommenttest {

	private WebDriver driver;
	private String baseUrl;
	private String adminUrl;
	private RTC011LoginPOM login;
	private RTC041BlogcommentPOM blogcmnt;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebElement authortxt;
	private Boolean title;

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
		blogcmnt = new RTC041BlogcommentPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		
	}
	
	
	@Test
	public void blogcommentValidateTest() {
		
		//actual test scenario
		blogcmnt.clickBloglnk();
		blogcmnt.clickReadmore();
		blogcmnt.sendComment("Good");
		blogcmnt.sendName("Mubitha");
		blogcmnt.sendEmail("mubithabanujaffar@gmail.com");
		blogcmnt.clickPostcmnt();
		screenShot.captureScreenShot();
		
		
		((JavascriptExecutor)driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.get(adminUrl);
		
		
		login.sendUserName("admin");
		login.sendPassword("adminuser@12345");
		login.clickSigninBtn(); 
		login.clickcommentlnk();
		
		
		//capture screenshot of admin dashboard
		screenShot.captureScreenShot();
		
		//Getting admin text for validation 
		String actualtext = "Mubitha";
		authortxt = driver.findElement(By.xpath("//strong[contains(text(),'Mubitha')]"));
		String expectedtext =authortxt.getText();
		System.out.println(expectedtext);
	
		//Assertion for login 
		Assert.assertTrue(expectedtext.contains(actualtext),"Blog comment posted successfully");
		
	}	
	@AfterTest
	public void tearDown()  {
		//Thread.sleep(1000);
		driver.quit();
		}
	    
	
}

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

