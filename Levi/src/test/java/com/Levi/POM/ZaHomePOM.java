package com.Levi.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZaHomePOM {
	
	@FindBy(xpath="//div[@id='fb-root']/following-sibling::header//div[@id='roadblock-container']//button[contains(@class,'close')]")
	public static WebElement frameClose;
	@FindBy(xpath="//input[@id='search-field']")
	public static WebElement search;

}
