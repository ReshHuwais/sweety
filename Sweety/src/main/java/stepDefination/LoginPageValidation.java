package stepDefination;

import modules.LandingPageVerification;
import modules.LoginPageVerification;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.sweety.util.WebConnector;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageValidation {
	WebConnector instance;
	public WebDriver driver;

	public LoginPageValidation() {
		instance = WebConnector.getInstance();
		driver = instance.driver;
		WebConnector.pageObjects();
	}

	@Given("^I go to \"([^\"]*)\" application on \"([^\"]*)\"$")
	public void go_to_sweety_application(String login, String browser) {
		System.out.println("***********Open " + login + " application in "
				+ browser + "***************");
		instance.navigate(login);
	}

	@When("^I am on \"([^\"]*)\" page$")
	public void on_page(String verify) throws InterruptedException {
		LoginPageVerification.verif_text_on_login_page(verify);
	}

	@And("^I enter userName as \"([^\"]*)\"$")
	public void enter_userName(String text) {
		LoginPage.sign_in.sendKeys(instance.CONFIG.getProperty(text));
	}

	@And("^I enter Password as \"([^\"]*)\"$")
	public void enter_password(String text) {
		LoginPage.password.sendKeys(instance.CONFIG.getProperty(text));
	}

	@When("^I click on \"([^\"]*)\"$")
	public void I_click_login_button(String submit) throws InterruptedException {
		LoginPage.click_login_button.click();
		Thread.sleep(1000);
	}

	@Then("^I should see \"([^\"]*)\"$")
	public void welcom_message(String message) throws InterruptedException {
		boolean actualResult = false;
		if (message.equals("ErrorMessage")) {
			actualResult = LoginPageVerification.verif_text_on_login_page(message);
		} else {
			actualResult = LandingPageVerification.verif_text_on_landing_page();
		}
		System.out.println(actualResult);
		Assert.assertEquals(true, actualResult);
	}

}
