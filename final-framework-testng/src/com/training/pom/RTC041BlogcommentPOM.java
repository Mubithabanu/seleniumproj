package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTC041BlogcommentPOM {
	private WebDriver driver; 
	
	public RTC041BlogcommentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='menu-item-617']//a[contains(text(),'Blog')]")
	private WebElement bloglnk;
	
	//div[@id='post-5619']//a[@class='read-more'][contains(text(),'Read More')]
	@FindBy(xpath= "//a[@class='read-more'][contains(text(),'Read More')]")
	private WebElement readMorelnk; 
	
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement commentTxt;
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement postCmtbtn; 	
	
	@FindBy(id="author")
	private WebElement nameTxt;
	
	@FindBy(id="email")
	private WebElement emailTxt;

	
	public void clickBloglnk() {
			this.bloglnk.click();
	}

	public void clickReadmore() {
		this.readMorelnk.click();
	}
	
	public void sendComment(String commenttext) {
		this.commentTxt.clear(); 
		this.commentTxt.sendKeys(commenttext); 
	}
	
	public void sendName(String name){
		this.nameTxt.clear();
		this.nameTxt.sendKeys(name); 
	}
	
	public void sendEmail(String email) {
		this.emailTxt.clear();
		this.emailTxt.sendKeys(email);
	}
	
	public void clickPostcmnt() {
		this.postCmtbtn.click();
	}
}
