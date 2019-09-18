package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTC044FeaturesPOM {
	private WebDriver driver; 
	
	public RTC044FeaturesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement propslnk;
	
	@FindBy(xpath= "//a[contains(text(),'Features')]")
	private WebElement featureslnk; 
	
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement featurename;
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement slugtext; 
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	private WebElement Featuredesc;
		
	@FindBy(xpath="//input[@id='submit']")	
	private WebElement addnewbtn;
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement addnewprops;
	
	

	public void moverPropslnk() {
		Actions action = new Actions(this.driver);
		action.moveToElement(propslnk).build().perform();
	}

	public void clickfeatureslink() {
		this.featureslnk.click();
	}
	
	public void sendFeaturename(String feature_name) {
		this.featurename.clear(); 
		this.featurename.sendKeys(feature_name); 
	}
	
	public void sendSlugtext(String slug) {
		this.slugtext.clear(); 
		this.slugtext.sendKeys(slug); 
	}
	
	public void sendDescText(String desctextarea){
		//this.postTextarea.sendKeys(Keys.TAB);
		this.Featuredesc.clear();
		this.Featuredesc.sendKeys(desctextarea); 
	}
	
	public void clickaddnewBtn() {
		this.addnewbtn.submit();
	}
	
	public void clickaddnewprops() {
		this.addnewprops.click();
	}
	
	
}
