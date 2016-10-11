package pageobjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LevelPage extends BaseClass {

	public LevelPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = ".//*[@id='sidebar-wrapper']/ul/li[2]/a")
	public static WebElement LevelLinkOnMenu;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='col-lg-3']/a")
	public static WebElement ClickAddButton;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='entry_level']")
	public static WebElement EnterGlucoseLevel;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='new_entry']/input[3]")
	public static WebElement ClickSubmitButton;
	
	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@id='page-content-wrapper']/div/div/div/h2"))
	public static List<WebElement> PageTitle;
	
	
	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@id='page-content-wrapper']/div/div[1]"))
	public static List<WebElement> MaximumEntyAlert;
	
	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@id='page-content-wrapper']/div/div[2]/div[1]/div/div[2]/table/tbody/tr"))
	public static List<WebElement> LevelEntriesTable;
}
