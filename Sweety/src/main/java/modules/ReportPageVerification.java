package modules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import pageobjects.LevelPage;
import pageobjects.ReportPage;

public class ReportPageVerification {
	static Calendar now = Calendar.getInstance();
	public static HashMap<String, String> errorEntry;

	/*
	 *Verify user is logged-in
	 *If not it will log-in
	 *Then it will navigate to Report entry page
	 *If user already logged in 
	 *Then it will check if user is in Report page if not user will be redirected to entry page
	 */
	public static void navigateToReportPage(WebDriver driver, String userName,
			String password) throws Exception {
		String pageTitle = "";
		LoginPageVerification.login(driver, userName, password);
		Thread.sleep(1000);
		pageTitle = CommonTestFunctions.readText(LevelPage.PageTitle);
		if (!pageTitle.equals("Level Reports")) {
			CommonTestFunctions.click(ReportPage.reportLinkOnMenu);
			Thread.sleep(1000);
		}
	}

	//Clicks on Daily link on report page
	public static boolean clickDailyLink(List<WebElement> link)
			throws InterruptedException {
		if (CommonTestFunctions.verifyelementPresent(link)) {
			CommonTestFunctions.click(link.get(0));
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	//Verify the report table title according to the daily/monthly report
	public static boolean verifyReportTableTilte(String report,
			List<WebElement> link) {
		String tableHeader = "";
		String daily = "Daily Report as of "
				+ new java.sql.Date(System.currentTimeMillis());
		String monthly = "Monthly Report as of for "
				+ new SimpleDateFormat("MMMM").format(now.getTime());
		if (CommonTestFunctions.verifyelementPresent(link)) {
			tableHeader = CommonTestFunctions.readText(link);
			if (report.equals("Daily")) {
				return tableHeader.equals(daily);
			} else if (report.equals("Monthly")) {
				return tableHeader.equals(monthly);
			}
		}
		return true;
	}

	//Verify the column names are available
	public static boolean verifyTableHeader(List<WebElement> link,
			DataTable table) {
		boolean actualResult = false;
		List<String> tableHeader = table.asList(String.class);
		if (CommonTestFunctions.verifyelementPresent(link)) {
			for (int index = 0; index < tableHeader.size(); index++) {
				actualResult = tableHeader.get(index).contains(
						link.get(index).getText());
				if (!actualResult)
					break;
			}
		}
		return actualResult;
	}
	//Verify all the entries are availabele according to MAx/Min/Avg
	public static boolean verifyTableEntries(List<WebElement> link) {
		String dateEntries = "";
		boolean actualResult = true;
		errorEntry = new HashMap<String, String>();
		if (CommonTestFunctions.verifyelementPresent(link)) {
			for (WebElement tr : link) {
				List<WebElement> td = tr.findElements(By.tagName("td"));
				if (td.get(0).getText().length() != 0) {
					dateEntries = td.get(0).getText();
				}
				for (int index = 3; index < td.size(); index++) {
					if (td.get(index).getText().length() == 0) {
						actualResult = false;
						String tdText = td.get(index).getText();
						errorEntry.put(dateEntries, "Error: Missing entires");
					}
				}
			}
		}
		return actualResult;
	}
}
