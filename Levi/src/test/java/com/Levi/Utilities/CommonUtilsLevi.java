package com.Levi.Utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class CommonUtilsLevi {
	
	public static Properties properties;
	public static FileInputStream propertyFile;
	public static WebDriver driver;
	Logger logger=Logger.getLogger(CommonUtilsLevi.class);
	public Properties getLeviProperty()
	{
		try {
			propertyFile=new FileInputStream("Config.properties");
			properties=new Properties();
			properties.load(propertyFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
	@BeforeSuite
	public WebDriver launchBrowser()
	{
		PropertyConfigurator.configure("log4jLevi.properties");
		logger.info("in launch Browser Common Utilitis");
		getLeviProperty();
		String browser=properties.getProperty("browser");
		switch (browser)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", properties.getProperty("ChromeDriverLocation"));
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", properties.getProperty("FirefoxDriverLocation"));
			driver=new FirefoxDriver();
		}
		return driver;
	}
	/*
	 * @AfterSuite public static void closeBrowser()
	 * {driver.manage().timeouts().implicitlyWait(10,
	 * TimeUnit.SECONDS);driver.close();}
	 */
}
