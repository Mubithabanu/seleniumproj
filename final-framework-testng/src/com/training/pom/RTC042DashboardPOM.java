package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTC042DashboardPOM {
	private WebDriver driver; 
	
	public RTC042DashboardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Posts')]")
	private WebElement postslnk;
	
	@FindBy(xpath= "//li[@id='menu-posts']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement addNewpostlnk; 
	
	@FindBy(id="title")
	private WebElement postTitle;
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement postTextarea; 	
	
	@FindBy(id="publish")
	private WebElement publishbtn;
	
	@FindBy(xpath ="//a[@class='wp-first-item current'][contains(text(),\"All Posts\")]")
	private WebElement allPostslnk;
	
	
	public void moverPostslnk() {
		Actions action = new Actions(this.driver);
		action.moveToElement(postslnk).build().perform();
	}

	public void clickaddNewpost() {
		this.addNewpostlnk.click();
	}
	
	public void sendPostTitle(String posttitle) {
		this.postTitle.clear(); 
		this.postTitle.sendKeys(posttitle); 
	}
	
	public void sendPostText(String posttextarea){
		//this.postTextarea.sendKeys(Keys.TAB);
		
		this.postTextarea.clear();
	
		this.postTextarea.sendKeys(posttextarea); 
		//driver.switchTo().defaultContent();
	}
	
	public void clickpublishBtn() {
		this.publishbtn.submit();
	}
	
	public void clickallPosts() {
		this.allPostslnk.click();
	}
}
