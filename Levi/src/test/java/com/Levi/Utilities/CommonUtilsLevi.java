package com.Levi.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Levi.Test.KidsTestData;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CommonUtilsLevi {
	public static ExtentReports extentReports;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest testCases;
	public static Properties properties;
	public static FileInputStream propertyFile;
	public static WebDriver driver;
	Logger logger = Logger.getLogger(CommonUtilsLevi.class);

	public Properties getLeviProperty() {
		try {
			propertyFile = new FileInputStream("Config.properties");
			properties = new Properties();
			properties.load(propertyFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	@BeforeSuite
	public WebDriver launchBrowser() {
		extentReports = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("ExtentReport.html");
		extentReports.attachReporter(sparkReporter);
		PropertyConfigurator.configure("log4jLevi.properties");
		logger.info("in launch Browser Common Utilitis");
		getLeviProperty();
		String browser = properties.getProperty("browser");
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", properties.getProperty("ChromeDriverLocation"));
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", properties.getProperty("FirefoxDriverLocation"));
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static void TakeScreenshot(String FileName) throws IOException {
		// Creating instance of File
		File File = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(File, new File("" + FileName + ".jpeg"));
		testCases.addScreenCaptureFromPath("" + FileName + ".jpeg");
	}

	@AfterSuite
	public void closeBrowser() {
		extentReports.flush();
		driver.close();
	}
}
