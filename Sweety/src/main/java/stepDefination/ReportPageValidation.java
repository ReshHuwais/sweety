package stepDefination;

import modules.CommonTestFunctions;
import modules.LoginPageVerification;
import modules.ReportPageVerification;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageobjects.ReportPage;

import com.sweety.util.WebConnector;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportPageValidation {
	WebConnector instance;
	public WebDriver driver;

	public ReportPageValidation() {
		instance = WebConnector.getInstance();
		driver = instance.driver;
		WebConnector.pageObjects();
	}

	@Given("^I am on Report Page$")
	public void report_page() throws Exception {
		ReportPageVerification.navigateToReportPage(driver, "validEmail",
				"validPassword");
	}

	@When("^I click on \"([^\"]*)\" Link$")
	public void clickLink(String link) throws InterruptedException {
		boolean actualResult = false;
		if (link.equals("Daily")) {
			actualResult = ReportPageVerification
					.clickDailyLink(ReportPage.dailyLinkOnReportPage);
		} else if (link.equals("Monthly")) {
			actualResult = ReportPageVerification
					.clickDailyLink(ReportPage.monthlyLinkOnReportPage);
		}
		CommonTestFunctions.reportLogging(actualResult,"Error: User not navigated to the respective page when "+link+" is clicked");
	}

	@Then("^I should see \"([^\"]*)\" header$")
	public void reportHeader(String link) {
		boolean actualResult = false;
		actualResult = ReportPageVerification.verifyReportTableTilte(link,
				ReportPage.reportTableTitle);
		CommonTestFunctions.reportLogging(actualResult,"Error: Report table title is missmatching for "+link+" report");
	}

	@And("^I should see three levels on \"([^\"]*)\" table$")
	public void tableEntryLevel(String link, DataTable table) {
		boolean actualResult = false;
		actualResult = ReportPageVerification.verifyTableHeader(ReportPage.reportTableHeader,table);
		CommonTestFunctions.reportLogging(actualResult,"Error: Missing header on the table of "+link+" report");
	}

	@Then("^I should see entries for each levels in \"([^\"]*)\" table$")
	public void entriesForEachLevel(String link) {
		boolean actualResult = false;
		actualResult = ReportPageVerification.verifyTableEntries(ReportPage.reportTableEntries);
		CommonTestFunctions.reportLogging(actualResult,"Error: Entry are missing under Min/Max/Avg of "+link+" report");
	}

}
