package modules;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageobjects.LandingPage;
import pageobjects.LoginPage;

import com.sweety.util.WebConnector;

import cucumber.api.DataTable;

public class LandingPageVerification {

	// Verify login user id on home page
	public static boolean verif_text_on_landing_page() {
		String text = LandingPage.log_in_user_name.getText();
		String[] text2 = text.split(" ");
		String expected = text2[0] + " " + text2[1].split("Welcome")[0];
		String actual_text = WebConnector.CONFIG.getProperty("validEmail");
		if (expected.contains(actual_text)) {
			return true;
		}
		return false;
	}

	//Verify recent Entries panel is present on home page
	public static boolean recentEntriesIsPresent() {
		if (CommonTestFunctions
				.verifyelementPresent(LandingPage.recentEntriesPanelIsDisplayed)) {
			return true;
		}
		return false;
	}

	//Verify Report panel is present on home page
	public static boolean reportIsPresent() {
		if (CommonTestFunctions
				.verifyelementPresent(LandingPage.reportPanelsIsDisplayed)) {
			return true;
		}
		return false;
	}

	/*
	 * Veirfy the columns under Entry/Report panels
	 * Compare the column name from the data table and with the read text
	 */
	public static boolean recentEntriesColumnValidation(DataTable table)
			throws InterruptedException {
		boolean actualResult = false;
		String actualText = "";
		String expectedText = "";
		Thread.sleep(1000);
		List<String> panels = table.asList(String.class);
		actualResult = LandingPageVerification.recentEntriesIsPresent();
		if (actualResult) {
			actualResult = CommonTestFunctions
					.verifyelementPresent(LandingPage.recentEntriesDateIsDisplayed);
			if (actualResult) {
				actualText = panels.get(0);
				expectedText = CommonTestFunctions
						.readText(LandingPage.recentEntriesDateIsDisplayed);
				if (!expectedText.equals(actualText)) {
					Assert.assertEquals(expectedText, actualText);
					actualResult = false;
				}
			}
			actualResult = CommonTestFunctions
					.verifyelementPresent(LandingPage.recentEntriesLevelIsDisplayed);
			if (actualResult) {
				actualText = panels.get(1);
				expectedText = CommonTestFunctions
						.readText(LandingPage.recentEntriesLevelIsDisplayed);
				if (!expectedText.equals(actualText)) {
					Assert.assertEquals(expectedText, actualText);
					actualResult = false;
				}
			}
		}
		return actualResult;
	}
	/*
	 * Veirfy the columns under Entry/Report panels
	 * Compare the column name from the data table and with the read text
	 */
	public static boolean reportPanelColumnValidation(DataTable table)
			throws InterruptedException {

		boolean actualResult = false;
		String actualText = "";
		String expectedText = "";
		Thread.sleep(1000);
		List<String> panels = table.asList(String.class);
		actualResult = LandingPageVerification.reportIsPresent();
		if (actualResult) {
			actualResult = CommonTestFunctions
					.verifyelementPresent(LandingPage.recentReportTypeIsDisplayed);
			if (actualResult) {
				actualText = panels.get(0);
				expectedText = CommonTestFunctions
						.readText(LandingPage.recentReportTypeIsDisplayed);
				if (!expectedText.equals(actualText)) {
					Assert.assertEquals(expectedText, actualText);
					actualResult = false;
				}
			}
			actualResult = CommonTestFunctions
					.verifyelementPresent(LandingPage.recentReportAccessIsDisplayed);
			if (actualResult) {
				actualText = panels.get(1);
				expectedText = CommonTestFunctions
						.readText(LandingPage.recentReportAccessIsDisplayed);
				if (!expectedText.equals(actualText)) {
					Assert.assertEquals(expectedText, actualText);
					actualResult = false;
				}
			}
		}
		return actualResult;
	}

	//Verify user is landing on report page when view link is clicked from home page
	public static boolean viewLinkOnReport() throws InterruptedException {

		boolean actualResult = false;
		Thread.sleep(1000);
		actualResult = CommonTestFunctions
				.verifyelementPresent(LandingPage.viewLinkOnReportPanel);
		if (actualResult) {
			CommonTestFunctions.click(LandingPage.viewLinkOnReportPanel.get(0));
		}
		return actualResult;
	}
}
