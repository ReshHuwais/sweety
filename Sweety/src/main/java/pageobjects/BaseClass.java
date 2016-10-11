package pageobjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public abstract class BaseClass {
	public static WebDriver driver;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

}
