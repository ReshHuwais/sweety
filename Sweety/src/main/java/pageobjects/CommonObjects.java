package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CommonObjects  extends BaseClass {

	public CommonObjects(WebDriver driver) {
		super(driver);
	}
	@FindBy(how = How.XPATH, using = ".//*[@id='sidebar-wrapper']/ul/li[1]/a")
	public static WebElement HomeLinkonMenu;
}
