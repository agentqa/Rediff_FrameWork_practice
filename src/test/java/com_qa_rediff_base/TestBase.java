package com_qa_rediff_base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {

	public static WebDriver driver;
	public static ChromeOptions options;
	public static Properties config;
	public static Properties testdata;

	public TestBase() throws IOException {
		config = new Properties();
		FileInputStream con = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com_qa_rediff_property\\config.properties");
		config.load(con);

		testdata = new Properties();
		FileInputStream test = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com_qa_rediff_property\\TestData.properties");
		testdata.load(test);

	}

	public WebDriver browserInitialization() {

		if (config.getProperty("browserName").equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("ignore-certificate-errors");// for certificate errors ??
			options.addArguments("--disable-notifications");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));// remove the automation notification
			options.addArguments("incognito");
			driver = new ChromeDriver(options);
		}else if(config.getProperty("browserName").equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("-private");
			driver = new FirefoxDriver(options);
		}else if(config.getProperty("browserName").equals("edge")) {
			 EdgeOptions options = new EdgeOptions();

			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("-InPrivate");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			driver = new EdgeDriver(options);
			
		}
		
		driver.get(config.getProperty("url"));

		return driver;
	}
	
	public Timeouts implicitTimeWait(int seconds) {
		Timeouts sec = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		return sec;
	}
	
	public Timeouts pageLoadTimeWait(int seconds) {
		Timeouts sec = driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
		return sec;
	}
	
	public String getAlertText() {
		String getAlert = driver.switchTo().alert().getText();
		return getAlert;
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	

}
