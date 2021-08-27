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
	
	@FindBy(xpath="//div[@id='fb-root']/following-sibling::header//li[contains(@class,'dropdown dropdown__full navbar-sub')]//a[contains(@class,'item-title')]")
	public static List<WebElement> itemTitle;

}
