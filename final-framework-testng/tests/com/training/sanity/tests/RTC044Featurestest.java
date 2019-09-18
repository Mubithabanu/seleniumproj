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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTC011LoginPOM;
import com.training.pom.RTC043PropertyPOM;
import com.training.pom.RTC044FeaturesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC044Featurestest {

	private WebDriver driver;
	private String baseUrl;
	private String adminUrl;
	private RTC011LoginPOM login;
	private RTC043PropertyPOM props;
	private RTC044FeaturesPOM feature;
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
		props = new RTC043PropertyPOM(driver);
		feature = new RTC044FeaturesPOM(driver);
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
		feature.moverPropslnk();
		feature.clickfeatureslink();
		feature.sendFeaturename("New Launches2");
		feature.sendSlugtext("Launch2");		
		feature.sendDescText("New Launches2 of Villas,apartments,flats");
		feature.clickaddnewBtn();
		feature.clickaddnewprops();
		
		props.sendPropsTitle("Prestige");
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		props.sendPropsText("HomeTown");
		WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'New Launches2')]"))).click();
        props.clickpublishBtn();
		Thread.sleep(15000);
		driver.switchTo().alert().accept();
	
			
				
		screenShot.captureScreenShot();
		
		
		
		
		
	}	
	@AfterClass
	public void tearDown()  {
		//Thread.sleep(1000);
		driver.quit();
		}
	    
	
}

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

