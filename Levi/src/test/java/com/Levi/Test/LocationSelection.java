package com.Levi.Test;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Levi.POM.GlobalPOM;
import com.Levi.Utilities.CommonUtilsLevi;

public class LocationSelection extends CommonUtilsLevi {
	static Logger logger = Logger.getLogger(LocationSelection.class);

	public static void findLocationPath(List<WebElement> actual, String expected) {
		for (WebElement li : actual) {
			String actualS = li.getText();
			if (actualS.equalsIgnoreCase(expected)) {
				li.click();
			}
		}
	}

	@Test
	public static void selectLocation() {
		PageFactory.initElements(CommonUtilsLevi.driver, GlobalPOM.class);
		findLocationPath(GlobalPOM.role, properties.getProperty("location"));
		findLocationPath(GlobalPOM.subLocation, properties.getProperty("subLocation"));
	}
}
