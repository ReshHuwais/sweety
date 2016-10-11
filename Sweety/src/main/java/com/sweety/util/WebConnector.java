package com.sweety.util;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import modules.LoginPageVerification;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjects.CommonObjects;
import pageobjects.LandingPage;
import pageobjects.LevelPage;
import pageobjects.LoginPage;
import pageobjects.ReportPage;
import cucumber.api.java.After;

public class WebConnector {
	public static WebDriver driver;
	public static Properties OR = null;
	public static Properties CONFIG = null;
	public static WebDriver Mozila = null;
	public static WebDriver Chrome = null;
	public static WebDriver Ie = null;
	public static WebConnector object = null;
	public static String browserType = null;
	public static String url = null;
	public static Logger Application_log = Logger.getLogger("devpinoyLogger");

	private WebConnector() {
		if (OR == null) {
			try {
				OR = new Properties();
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir")
								+ "\\src\\main\\java\\config\\OR.properties");
				OR.load(file);

				CONFIG = new Properties();
				file = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\main\\java\\config\\"
						+ OR.getProperty("testEnv") + ".properties");
				CONFIG.load(file);
				browserType = CONFIG.getProperty("browserType");
				url = CONFIG.getProperty("sweety");
				openBrowser(browserType);
				navigate("sweety");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public static WebConnector getInstance() {
		if (object == null)
			object = new WebConnector();
		return object;
	}

	public static void pageObjects() {
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, LandingPage.class);
		PageFactory.initElements(driver, LevelPage.class);
		PageFactory.initElements(driver, ReportPage.class);
		PageFactory.initElements(driver, CommonObjects.class);
	}

	// Open the requested browser public void openBrowser(String browserType)
	public void openBrowser(String browserType) {
		System.out.println(Mozila);
		if (browserType.equals("Mozila") && Mozila == null) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			Mozila = driver;
		} else if (browserType.equals("Mozila") && Mozila != null) {
			driver = Mozila;
		} else if (browserType.equals("Chrome") && Chrome == null) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			Chrome = driver;
		} else if (browserType.equals("Chrome") && Chrome != null) {
			driver = Chrome;
		} else if (browserType.equals("Ie") && Ie == null) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Ie = driver;
		} else if (browserType.equals("Ie") && Ie != null) {
			driver = Ie;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.initElements(driver, LoginPage.class);
	}

	// Navigates to the URL
	public void navigate(String url) {
		driver.manage().deleteAllCookies();
		driver.get(CONFIG.getProperty(url));
		Set<String> s = driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		driver.switchTo().window(it.next());
	}

	/******************** Common functions **************************/

	public boolean isElementPresent(String xpath) {
		int count = driver.findElements(
				By.xpath(WebConnector.OR.getProperty(xpath))).size();
		if (count != 0) {
			return true;
		}
		return false;
	}

	public static void log(String message) {
		System.out.println(message);
		Application_log.debug(message);
	}

	@After
	public void quit() {
		driver.close();
	}
}
