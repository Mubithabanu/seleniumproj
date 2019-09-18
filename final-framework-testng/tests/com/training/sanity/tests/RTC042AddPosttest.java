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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTC011LoginPOM;
import com.training.pom.RTC042DashboardPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC042AddPosttest {

	private WebDriver driver;
	private String baseUrl;
	private String adminUrl;
	private RTC011LoginPOM login;
	private RTC042DashboardPOM dashb;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebElement authortxt;
	private Boolean title;
	private WebElement pageposttext;
	private WebElement viewpost;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		login = new RTC011LoginPOM(driver); 
		dashb = new RTC042DashboardPOM(driver);
		//baseUrl = properties.getProperty("baseURL");
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		
		
	}
	
	
	@Test
	public void addPostValidateTest() throws InterruptedException {
		
		//login steps
		login.sendUserName("admin");
		login.sendPassword("adminuser@12345");
		login.clickSigninBtn();
		
		//add new post
		dashb.moverPostslnk();
		dashb.clickaddNewpost();
		dashb.sendPostTitle("New launch");
		
		//driver.switchTo().frame("content_ifr");
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		dashb.sendPostText("New launch");
		
		dashb.clickpublishBtn();
		Thread.sleep(15000);
		driver.switchTo().alert().accept();
		dashb.clickallPosts();	
		
		
        screenShot.captureScreenShot();
		
		//Getting post text for validation
		String posttext = "View Post";
		pageposttext = driver.findElement(By.xpath("//table[@class=\"wp-list-table widefat fixed striped posts\"]/tbody[@id=\"the-list\"]/tr[1]//a[@class='row-title']"));
		String expectedtext = pageposttext.getText();
		System.out.println(expectedtext);
		pageposttext.click();
		screenShot.captureScreenShot();
		viewpost = driver.findElement(By.xpath("//a[contains(text(),'View Post')]"));
		String viewposttxt = viewpost.getText();
	
		//Assertion for post displayed
		Assert.assertTrue(viewposttxt.equals(posttext)," Post published successfully");
		
		
		
		
	}	
	@AfterClass
	public void tearDown()  {
		//Thread.sleep(1000);
		driver.quit();
		}
	    
	
}

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

