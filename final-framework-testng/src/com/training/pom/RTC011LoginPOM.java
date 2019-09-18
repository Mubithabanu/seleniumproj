package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTC011LoginPOM {
	private WebDriver driver; 
	
	public RTC011LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='http://realestatem1.upskills.in/my-profile/']")
	private WebElement Signinlnk;
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @name ='login']")
	private WebElement SigninBtn;
	
	@FindBy(xpath="//div[contains(text(),'Comments')]")
	private WebElement commentlnk;
	
	
	public void clickSigninlnk() {
			this.Signinlnk.click();
	}

	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickSigninBtn() {
		this.SigninBtn.click(); 
	}
	
	public void clickcommentlnk( ) {
		this.commentlnk.click();
	}

}
