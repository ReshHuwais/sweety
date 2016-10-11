package pageobjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage extends BaseClass {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-12']")
	public static WebElement log_in_user_name;

	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-6'][1]"))
	public static List<WebElement> recentEntriesPanelIsDisplayed;

	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-6'][1]/div/div[2]/table/thead/tr/th[1]"))
	public static List<WebElement> recentEntriesDateIsDisplayed;

	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-6'][1]/div/div[2]/table/thead/tr/th[2]"))
	public static List<WebElement> recentEntriesLevelIsDisplayed;

	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-6'][2]"))
	public static List<WebElement> reportPanelsIsDisplayed;
	
	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-6'][2]/div/div[2]/table/thead/tr/th[1]"))
	public static List<WebElement> recentReportTypeIsDisplayed;

	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-6'][2]/div/div[2]/table/thead/tr/th[2]"))
	public static List<WebElement> recentReportAccessIsDisplayed;

	@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-6'][1]")
	public static WebElement recent_entries_panel;

	@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-6'][2]")
	public static WebElement report_panels;
	
	
	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-6'][2]/div/div[2]/table/tbody/tr/td/a"))
	public static List<WebElement> viewLinkOnReportPanel; 
}
