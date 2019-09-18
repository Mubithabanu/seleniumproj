package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTC043PropertyPOM {
	private WebDriver driver; 
	
	public RTC043PropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement propslnk;
	
	@FindBy(xpath= "//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement addnewpropslnk; 
	
	@FindBy(id="title")
	private WebElement propsTitle;
	
	@FindBy(id="content")
	private WebElement propsTextarea; 	
	
	@FindBy(xpath ="//input[@id='publish']")
	private WebElement publishbtn;
	
	@FindBy(xpath ="//a[contains(text(),'View post')]")
	private WebElement viewpostlnk;
	
	//@FindBy()
	
	
	public void moverPropslnk() {
		Actions action = new Actions(this.driver);
		action.moveToElement(propslnk).build().perform();
	}

	public void clickaddNewprop() {
		this.addnewpropslnk.click();
	}
	
	public void sendPropsTitle(String propertytitle) {
		this.propsTitle.clear(); 
		this.propsTitle.sendKeys(propertytitle); 
	}
	
	public void sendPropsText(String propertytextarea){
		this.propsTextarea.clear();
		this.propsTextarea.sendKeys(propertytextarea); 
	}
	
	public void clickpublishBtn() {
		this.publishbtn.submit();
	}
	
	public void clickviewpost() {
		this.viewpostlnk.click();
	}
}
