package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTC013EditprofilePOM {
	private WebDriver driver; 
	
	public RTC013EditprofilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Howdy,')]")
	private WebElement adminlnk;
	
	@FindBy(xpath="//a[contains(text(),'Edit My Profile')]")
	private WebElement editprfllnk; 
	
	@FindBy(id="last_name")
	private WebElement lastname;
	
	@FindBy(id="phone")
	private WebElement phoneno;
	
	@FindBy(xpath="//input[@id='submit' and @name='submit']")
	private WebElement UpdtprofileBtn; 
	
	public void moverAdminlnk() {
		Actions action = new Actions(this.driver);
		action.moveToElement(adminlnk).build().perform();
    }
	

	public void editprfllnk() {
			this.editprfllnk.click();
	}

	
	public void sendLastname(String lastName) {
		this.lastname.clear();
		this.lastname.sendKeys(lastName);
	}
	
	public void sendPhone(String phone) {
		this.phoneno.clear(); 
		this.phoneno.sendKeys(phone); 
	}
	
	public void clickUpdtprofileBtn() {
		this.UpdtprofileBtn.click(); 
	}
}
