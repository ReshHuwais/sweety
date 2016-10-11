package pageobjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReportPage extends BaseClass{

	public ReportPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(how = How.XPATH, using = ".//*[@id='sidebar-wrapper']/ul/li[3]/a")
	public static WebElement reportLinkOnMenu;
	
	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@id='page-content-wrapper']/div/div[2]/div[2]/ul/li[1]/a"))
	public static List<WebElement> dailyLinkOnReportPage;
	
	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@id='page-content-wrapper']/div/div[2]/div[2]/ul/li[2]/a"))
	public static List<WebElement> monthlyLinkOnReportPage;
	
	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@id='page-content-wrapper']/div/div[2]/div[1]/div/div[1]/h3"))
	public static List<WebElement> reportTableTitle;
	
	
	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@id='page-content-wrapper']/div/div[2]/div[1]/div/div[2]/table/thead/tr/th"))
	public static List<WebElement> reportTableHeader;
	
	@FindAll(@FindBy(how = How.XPATH, using = ".//*[@id='page-content-wrapper']/div/div[2]/div[1]/div/div[2]/table/tbody/tr"))
	public static List<WebElement> reportTableEntries;
}
