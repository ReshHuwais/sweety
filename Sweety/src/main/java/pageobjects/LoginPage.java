package pageobjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindAll(@FindBy(how = How.ID, using = "user_email"))
	public static List<WebElement> verifyElementPresent;
	
	
	@FindBy(how = How.ID, using = "user_email")
	public static WebElement sign_in;

	@FindBy(how = How.ID, using = "user_password")
	public static WebElement password;

	@FindBy(how = How.NAME, using = "commit")
	public static WebElement click_login_button;

	@FindBy(how = How.XPATH, using = ".//*[@id='page-content-wrapper']/div/div[1]")
	public static WebElement verify_notification;
}
