package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTC015LogoutPOM {
	private WebDriver driver; 
	
	public RTC015LogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Howdy,')]")
	private WebElement adminlnk;
	
	@FindBy(xpath="//a[@class='ab-item'][contains(text(),'Log Out')]")
	private WebElement logoutlnk; 
	
	@FindBy(xpath="//a[contains(text(),'log out')]")
	private WebElement logoutconfirmlnk;
	
	public void moverAdminlnk() {
		Actions action = new Actions(this.driver);
		action.moveToElement(adminlnk).build().perform();
    }
	

	public void logoutlnkclick() {
			this.logoutlnk.click();
	}
	
	public void logoutconfirmlnkclick() {
			this.logoutconfirmlnk.click();
	}

	

}
