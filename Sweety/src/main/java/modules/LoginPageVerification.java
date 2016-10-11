package modules;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sweety.util.WebConnector;

import pageobjects.BaseClass;
import pageobjects.CommonObjects;
import pageobjects.LoginPage;

public class LoginPageVerification {

	/*
	 * First checks if user logged in to the application
	 * If not then log in should happen
	 */
	public static void login(WebDriver driver, String userName, String password)
			throws Exception {
		if (CommonTestFunctions
				.verifyelementPresent(LoginPage.verifyElementPresent)) {
			LoginPage.sign_in.sendKeys(WebConnector.CONFIG
					.getProperty("validEmail"));
			LoginPage.password.sendKeys(WebConnector.CONFIG
					.getProperty("validPassword"));
			LoginPage.click_login_button.click();
		}
	}

	//Verify user name on home page
	public static boolean verif_text_on_login_page(String verify) throws InterruptedException {
		String actual_text = LoginPage.verify_notification.getText();
		CommonTestFunctions.click(CommonObjects.HomeLinkonMenu);
		Thread.sleep(1000);
		if (WebConnector.CONFIG.getProperty(verify).contains(actual_text)) {
			return true;
		}
		return false;
	}

}
