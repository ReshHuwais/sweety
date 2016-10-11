package stepDefination;

import modules.CommonTestFunctions;
import modules.LandingPageVerification;
import modules.LoginPageVerification;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageobjects.LevelPage;

import com.sweety.util.WebConnector;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LandingPageValidation {
	WebConnector instance;
	public WebDriver driver;

	public LandingPageValidation() {
		instance = WebConnector.getInstance();
		driver = instance.driver;
		WebConnector.pageObjects();
	}

	@Given("^I am on Home page$")
	public void i_am_on_home_page() throws Exception {
		LoginPageVerification.login(driver, "validEmail", "validPassword");
	}

	@When("^I verify the home page$")
	public void verify_home_page() throws InterruptedException {
		boolean actualResult = false;
		actualResult = LoginPageVerification.verif_text_on_login_page("login");
		CommonTestFunctions.reportLogging(actualResult,	"Error: User is not on Landing page");
	}

	@Then("^I sould see my loginID on home page$")
	public void login_id_on_landing_page() {
		boolean actualResult = false;
		actualResult = LandingPageVerification.verif_text_on_landing_page();
		CommonTestFunctions.reportLogging(actualResult,	"Error: User login id is not displayed on Landing page");
	}

	@Then("^I sould see Entry panels on home page$")
	public void verify_Entrypanel(DataTable table) throws InterruptedException {

		boolean actualResult = LandingPageVerification
				.recentEntriesColumnValidation(table);
		CommonTestFunctions.reportLogging(actualResult,	"Error: Entry Pannel is missing");
	}

	@Then("^I sould see Report panels on home page$")
	public void verify_Reportpanels(DataTable table)
			throws InterruptedException {
		boolean actualResult = LandingPageVerification
				.reportPanelColumnValidation(table);
		CommonTestFunctions.reportLogging(actualResult,	"Error: Report Pannel is missing");
	}

	@Then("^I click on view link$")
	public void view_link() throws InterruptedException {
		boolean actualResult = LandingPageVerification.viewLinkOnReport();
		CommonTestFunctions.reportLogging(actualResult,	"Error: View link is missing");
	}

	@Then("^I should land on Level \"([^\"]*)\" page$")
	public void page_title(String pageTitle) {
		boolean actualResult = false;
		String actualText = "";
		String expectedText = "";
		if (CommonTestFunctions.verifyelementPresent(LevelPage.PageTitle)) {
			actualText = CommonTestFunctions.readText(LevelPage.PageTitle);
			expectedText = "Level " + pageTitle;
			actualResult = expectedText.contains(actualText);
			CommonTestFunctions.reportLogging(actualResult,	"Error: User is not landing on Level Report page when view link is clicked");
		}
	}
}
