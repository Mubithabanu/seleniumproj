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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTC011LoginPOM;
import com.training.pom.RTC042DashboardPOM;
import com.training.pom.RTC043PropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC043Addpropertytest {

	private WebDriver driver;
	private String baseUrl;
	private String adminUrl;
	private RTC011LoginPOM login;
	private RTC043PropertyPOM props;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebElement pageposttext;
	private WebElement viewpost;
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
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		login = new RTC011LoginPOM(driver); 
		props = new RTC043PropertyPOM(driver);
		//baseUrl = properties.getProperty("baseURL");
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl); 
		
		
	}
	
	
	@Test
	public void addPostvalidateTest() throws Exception {
		
		//actual test scenario
		
		login.sendUserName("admin");
		login.sendPassword("adminuser@12345");
		login.clickSigninBtn(); 
		
		props.moverPropslnk();
		props.clickaddNewprop();
		props.sendPropsTitle("Villa");
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		props.sendPropsText("Villa in Bangalore");
		props.clickpublishBtn();
		
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		
				
	
		
				
		//capture screenshot of 
		screenShot.captureScreenShot();
		
		
		
	}	
	@AfterTest
	public void tearDown()  {
		//Thread.sleep(1000);
		driver.quit();
		}
	    
	
}

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

