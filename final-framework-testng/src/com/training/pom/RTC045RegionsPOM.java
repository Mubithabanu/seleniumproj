package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTC045RegionsPOM {
	private WebDriver driver; 
	
	public RTC045RegionsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement propslnk;
	
	@FindBy(xpath= "//a[contains(text(),'Regions')]")
	private WebElement regionslnk; 
	
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement regionname;
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement slugtext; 
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	private WebElement regiondesc;
		
	@FindBy(xpath="//input[@id='submit']")	
	private WebElement addnewbtn;
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement addnewprops;
	
	

	public void moverPropslnk() {
		Actions action = new Actions(this.driver);
		action.moveToElement(propslnk).build().perform();
	}

	public void clickregionslink() {
		this.regionslnk.click();
	}
	
	public void sendRegionname(String region_name) {
		this.regionname.clear(); 
		this.regionname.sendKeys(region_name); 
	}
	
	public void sendSlugtext(String slug) {
		this.slugtext.clear(); 
		this.slugtext.sendKeys(slug); 
	}
	
	public void sendDescText(String desctextarea){
		//this.postTextarea.sendKeys(Keys.TAB);
		this.regiondesc.clear();
		this.regiondesc.sendKeys(desctextarea); 
	}
	
	public void clickaddnewBtn() {
		this.addnewbtn.submit();
	}
	
	public void clickaddnewprops() {
		this.addnewprops.click();
	}
	
	
}
