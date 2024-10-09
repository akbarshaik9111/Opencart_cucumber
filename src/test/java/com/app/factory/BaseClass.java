package com.app.factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties props;
	public static Logger logger;
	
	public static WebDriver initializeBrowser() throws IOException {
		props = getProperties();
		String executionEnv = props.getProperty("execution_env");
		String os = props.getProperty("os").toLowerCase();
		String browser = props.getProperty("browser").toLowerCase();
		
		if(executionEnv.equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			switch(os) {
			case "mac": 
				capabilities.setPlatform(Platform.MAC);
				break;
			case "windows":
				capabilities.setPlatform(Platform.WINDOWS);
				break;
			case "linux":
				capabilities.setPlatform(Platform.LINUX);
				break;
			default:
				System.out.println("No Matching Found..!");
				return null;
			}
			
			switch(browser) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;
			default:
				System.out.println("No Matching Found..!");
				return null;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}
		else if(executionEnv.equalsIgnoreCase("local")) {
			switch(browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("No Matching Found..!");
				driver= null;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		props = new Properties();
		props.load(file);
		return props;
	}
	
	public static Logger getLogger() {
		logger = LogManager.getLogger();
		return logger;
	}
	
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public static String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public static String randomAlphaNumberic() {
		String alphabetic = RandomStringUtils.randomAlphabetic(5);
		String numeric = RandomStringUtils.randomNumeric(10);
		return alphabetic+numeric;
	}
}