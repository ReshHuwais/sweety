package modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjects.LevelPage;
import pageobjects.ReportPage;

public class LevelEntryPageVerification {
	
	/*
	 *Verify user is logged-in
	 *If not it will log-in
	 *Then it will navigate to Level entry page
	 *If user already logged in 
	 *Then it will check if user is in Level entry page if not user will be redirected to entry page
	 */
	public static void navigateToLevelEntryPage(WebDriver driver,
			String userName, String password) throws Exception {
		String pageTitle = "";
		LoginPageVerification.login(driver, userName, password);
		Thread.sleep(1000);
		pageTitle = CommonTestFunctions.readText(LevelPage.PageTitle);
		if (!pageTitle.equals("Level Entries")) {
			CommonTestFunctions.click(LevelPage.LevelLinkOnMenu);
			Thread.sleep(1000);
		}
	}

	//First checks if user is on entry page and than clicks on add button
	public static boolean click_add_button() throws InterruptedException {
		String pageTitle = CommonTestFunctions.readText(LevelPage.PageTitle);
		if (pageTitle.equals("Level Entries")) {
			CommonTestFunctions.click(LevelPage.ClickAddButton);
			Thread.sleep(1000);
			pageTitle = CommonTestFunctions.readText(LevelPage.PageTitle);
			return pageTitle.equals("Welcome to Sweety");
		}
		return false;
	}

	/*
	 * First deletes all the entries 
	 * Check for 4x a day
	 * check for 5x aday
	 */
	public static boolean enter_glucose_level(int times, WebDriver driver)
			throws InterruptedException {
		String pageTitle = CommonTestFunctions.readText(LevelPage.PageTitle);
		if (!pageTitle.equals("Level Entries")) {
			CommonTestFunctions.click(LevelPage.LevelLinkOnMenu);
			Thread.sleep(1000);
		}
		delete_all_entries(driver);
		click_add_button();
		pageTitle = CommonTestFunctions.readText(LevelPage.PageTitle);
		if (pageTitle.equals("Welcome to Sweety")) {
			for (int index = 0; index < times; index++) {
				CommonTestFunctions.enterTextInField(
						LevelPage.EnterGlucoseLevel, index + "" + times);
				CommonTestFunctions.click(LevelPage.ClickSubmitButton);
				Thread.sleep(1000);
				click_add_button();
			}
		}
		return true;
	}

	public static void delete_all_entries(WebDriver driver)
			throws InterruptedException {
		boolean tablePresent = CommonTestFunctions
				.verifyelementPresent(LevelPage.LevelEntriesTable);
		;
		while (tablePresent) {
			tablePresent = CommonTestFunctions
					.verifyelementPresent(LevelPage.LevelEntriesTable);
			if (tablePresent) {
				List<WebElement> tableDelete = LevelPage.LevelEntriesTable;
				tableDelete.get(0).findElement(By.xpath("td[2]/a")).click();
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
			}
		}

	}
	
	//Validates the expected alert message for each entry per day
	public static boolean validate_maximum_entry(String result){
		String pageTitle = CommonTestFunctions.readText(LevelPage.MaximumEntyAlert);
		if(result.equals("Not")){
			return pageTitle.equals("Maximum entries reached for this date.");
		}else if(result.equals("Be")){
			return !pageTitle.equals("Maximum entries reached for this date.");
		}
		
		return true;
	}
}
