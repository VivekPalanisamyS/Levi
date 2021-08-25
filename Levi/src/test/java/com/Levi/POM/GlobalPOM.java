package com.Levi.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlobalPOM {
	@FindBy(xpath = "//a[contains(@data-target,'data-drilldown')]")
	public static List<WebElement> role;
	
	@FindBy(xpath="//div[@class='global-country-list']//div[contains(@style,'block')][2]/div/div/a")
	public static List<WebElement> subLocation;

}
