package stepDefination;

import modules.CommonTestFunctions;
import modules.LevelEntryPageVerification;

import org.openqa.selenium.WebDriver;

import com.sweety.util.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LevelEntryPageValidation {
	WebConnector instance;
	public WebDriver driver;

	public LevelEntryPageValidation() {
		instance = WebConnector.getInstance();
		driver = instance.driver;
		WebConnector.pageObjects();
	}

	@Given("^I am on Level Entry Page$")
	public void level_entry() throws Exception {
		LevelEntryPageVerification.navigateToLevelEntryPage(driver, "validEmail", "validPassword");
	}

	@When("^I click on Add butoon$")
	public void click_add_button() throws InterruptedException {
		boolean actualResult = false;
		actualResult = LevelEntryPageVerification.click_add_button();
		CommonTestFunctions.reportLogging(actualResult,	"Error: User not not on the correct page to click on Add button");
	}

	@And("^I enter my Glucose level \"([^\"]*)\" a day$")
	public void enter_glucose(int times) throws InterruptedException {
		LevelEntryPageVerification.enter_glucose_level(times, driver);
	}

	@Then("^My recods should \"([^\"]*)\" created$")
	public void validate_added_record(String result) {
		boolean actualResult = LevelEntryPageVerification
				.validate_maximum_entry(result);
		if (result.equals("Be"))
			CommonTestFunctions.reportLogging(actualResult,	"Error: Application fails to enter sugar level 4x a day");
		else if (result.equals("Not"))
			CommonTestFunctions.reportLogging(actualResult,	"Error: Applcation fails to display alert message when user enter sugar level more than 4x a day");
	}
}
