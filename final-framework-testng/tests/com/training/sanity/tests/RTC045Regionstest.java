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
import org.openqa.selenium.support.ui.Select;
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
import com.training.pom.RTC045RegionsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC045Regionstest {

	private WebDriver driver;
	private String baseUrl;
	private String adminUrl;
	private RTC011LoginPOM login;
	private RTC043PropertyPOM props;
	private RTC045RegionsPOM region;
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
		region = new RTC045RegionsPOM(driver);
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
		region.moverPropslnk();
		region.clickregionslink();
		region.sendRegionname("Koramangala");
		region.sendSlugtext("Koramangala");	
		Select parent = new Select(driver.findElement((By.id("parent"))));
		parent.selectByVisibleText("None");
		
		region.sendDescText("Villas,apartments,flats in Koramangala");
		region.clickaddnewBtn();
		region.clickaddnewprops();
		
		props.sendPropsTitle("Prestige");
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		props.sendPropsText("HomeTown");
		WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='regionchecklist']//label[contains(@class,'selectit')][contains(text(),'a')]"))).click();
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

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

