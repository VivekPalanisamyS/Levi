package com.Levi.Test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Levi.Utilities.CommonUtilsLevi;

public class LaunchBrowser extends CommonUtilsLevi{
	Logger logger = Logger.getLogger(LaunchBrowser.class);

	@Test
	public void launchBrowserTest() {
		PropertyConfigurator.configure("log4jLevi.properties");
		logger.info("test started");
			CommonUtilsLevi.driver.get(CommonUtilsLevi.properties.getProperty("url"));
			Assert.assertEquals(CommonUtilsLevi.driver.getCurrentUrl(), "https://www.levi.com/global");
	}
}
