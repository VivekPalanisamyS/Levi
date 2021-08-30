package com.Levi.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZaHomePOM {
	
	@FindBy(xpath="//div[@id='fb-root']/following-sibling::header//div[@id='roadblock-container']//button[contains(@class,'close')]")
	public static WebElement popupClose;
	@FindBy(xpath="//input[@id='search-field']")
	public static WebElement search;
	
	@FindBy(xpath="//div[@id='fb-root']/following-sibling::header//li[contains(@class,'dropdown dropdown__full navbar-sub')]//a[@class='navbar-link']")
	public static List<WebElement> mainLink;
	
	@FindBy(xpath="//div[@id='fb-root']/following-sibling::header//a[text()='Men']/ancestor::li[contains(@class,'dropdown dropdown__full navbar-sub')]/ul/descendant::a[@class='item-title']")
	public static List<WebElement> menItemTitle;
	
	@FindBy(xpath="//div[@id='fb-root']/following-sibling::header//li//a[text()='Kids']")
	public static WebElement kids;
	
	@FindBy(xpath="//div[@id='fb-root']/following-sibling::header//li//a[text()='Kids']/ancestor::li//a[@class='item-title']")
	public static List<WebElement> subKids;
	
	@FindBy(xpath="//div[@id='fb-root']/following-sibling::header//li//a[text()='Kids']/ancestor::li[1]/descendant::a[2]")
	public static WebElement boysVisibility;
}
