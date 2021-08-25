package com.Levi.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Levi.POM.GlobalPOM;
import com.Levi.POM.ZaHomePOM;
import com.Levi.Utilities.CommonUtilsLevi;

public class ZaHomeTest extends CommonUtilsLevi {
	
	Logger logger=Logger.getLogger(ZaHomeTest.class);
	@Test
	public void ZaHomeTestMethod()
	{
		PageFactory.initElements(CommonUtilsLevi.driver, ZaHomePOM.class);
		 
		WebDriverWait wait2 = new WebDriverWait(driver,10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='fb-root']/following-sibling::header//div[@id='roadblock-container']//button[contains(@class,'close')]")));
		ZaHomePOM.frameClose.click();
		/*
		 * JavascriptExecutor j = (JavascriptExecutor) driver;
		 * j.executeScript("arguments[0].click()",ZaHomePOM.frameClose);
		 */
		 ZaHomePOM.search.sendKeys("success dress");
	}

}
