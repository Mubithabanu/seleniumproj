package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTC014GeneratepasswordPOM {
	private WebDriver driver; 
	
	public RTC014GeneratepasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Howdy,')]")
	private WebElement adminlnk;
	
	@FindBy(xpath="//a[contains(text(),'Edit My Profile')]")
	private WebElement editprfllnk; 
	
	@FindBy(xpath="//button[@class='button wp-generate-pw hide-if-no-js']")
	private WebElement genpswdbtn;
	
	@FindBy(id="pass1-text")
	private WebElement newpswdtxt;
	
	@FindBy(xpath="//input[@name='pw_weak']")
	private WebElement wkpswdchk; 
	
	@FindBy(xpath="//input[@id='submit' and @name='submit']")
	private WebElement UpdtprofileBtn; 	
	
	public void moverAdminlnk() {
		Actions action = new Actions(this.driver);
		action.moveToElement(adminlnk).build().perform();
    }
	

	public void editprfllnk() {
			this.editprfllnk.click();
	}

	public void genpswdclick() {
			this.genpswdbtn.click();
	}
	
	public void sendNewPassword(String newpassword) {
			this.newpswdtxt.clear();
			this.newpswdtxt.sendKeys(newpassword);
	}
	
	public void checkWeakpswd() {
			this.wkpswdchk.click();
	}
	
	public void clickUpdtprofileBtn() {
		this.UpdtprofileBtn.click(); 
	}
	
}
