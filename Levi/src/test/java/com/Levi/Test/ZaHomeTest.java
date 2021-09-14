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

	public static void findLinks(List<WebElement> link, String expected, String actionToBe) {
		for (WebElement li : link) {
			if (li.getText().equalsIgnoreCase(expected)) {
				if (actionToBe.equalsIgnoreCase("mouseOver")) {
					mouseOver(li);
					break;
				} else if (actionToBe.equalsIgnoreCase("click")) {
					clickE(li);
					break;
				}
			}
		}

	}

	private static void mouseOver(WebElement title) {
		Actions action = new Actions(driver);
		action.moveToElement(title).perform();
	}

	public static void clickE(WebElement title) {
		title.click();
	}

	@Test
	public static void ZaHomeTestMethod() {
		PageFactory.initElements(CommonUtilsLevi.driver, ZaHomePOM.class);
		 WebDriverWait wait2 = new WebDriverWait(driver, 10);
		/* wait2.until(ExpectedConditions.visibilityOf(ZaHomePOM.popupClose));
		 * ZaHomePOM.popupClose.click();
		 */
		// JavascriptExecutor j =
		// (JavascriptExecutor)driver;j.executeScript("arguments[0].click()",ZaHomePOM.frameClose);
		findLinks(ZaHomePOM.mainLink, "kids", "mouseOver");
		wait2.until(ExpectedConditions.visibilityOf(ZaHomePOM.boysVisibility));
		findLinks(ZaHomePOM.subKids, "Boys", "click");
		System.out.println("za home test end");
	}
}
