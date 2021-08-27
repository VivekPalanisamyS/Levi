package com.Levi.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Levi.POM.GlobalPOM;
import com.Levi.POM.ZaHomePOM;
import com.Levi.Utilities.CommonUtilsLevi;

public class ZaHomeTest extends CommonUtilsLevi {

	Logger logger = Logger.getLogger(ZaHomeTest.class);
	Map<String, WebElement> links = new LinkedHashMap<String, WebElement>();
	
	public void findLinks(List<WebElement> link) {
		for (WebElement li : link) {
			if(li.getText()!=null)
			links.put(li.getText(), li);
		}
		System.out.println(links.keySet());
	}

	private void mouseOver(String title) {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText(title))).perform();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='fb-root']/following-sibling::header//li[contains(@class,'dropdown dropdown__full navbar-sub')]//a[contains(@class,'item-title')]")));
		findLinks(ZaHomePOM.itemTitle);
	}


	@Test
	public void ZaHomeTestMethod() {
		PageFactory.initElements(CommonUtilsLevi.driver, ZaHomePOM.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='fb-root']/following-sibling::header//div[@id='roadblock-container']//button[contains(@class,'close')]")));
		ZaHomePOM.popupClose.click();
		// JavascriptExecutor j = (JavascriptExecutor)driver;j.executeScript("arguments[0].click()",ZaHomePOM.frameClose);
		findLinks(ZaHomePOM.mainLink);
		for(String title : links.keySet())
		mouseOver(title);
		System.out.println(links.keySet());
	}
}
