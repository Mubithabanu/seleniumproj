package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTC012LostpasswordPOM {
	private WebDriver driver; 
	
	public RTC012LostpasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//a[contains(text(),'Lost Your Password?')]")
	private WebElement lostpswdlnk;
	
	@FindBy(xpath="//input[@id='user_login']")
	private WebElement emailtxtbox;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement resetbtn;

	
	public void lostpswdclick() {
		this.lostpswdlnk.click();
	}
	
	public void sendEmail(String email) {
		this.emailtxtbox.clear(); 
		this.emailtxtbox.sendKeys(email); 
	}
	
	public void clickResetBtn() {
		this.resetbtn.click(); 
	}
}
