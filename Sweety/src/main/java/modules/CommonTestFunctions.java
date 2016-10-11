package modules;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.sweety.util.WebConnector;

public class CommonTestFunctions {
	public static boolean verifyelementPresent(
			List<WebElement> verifyElementPresent) {
		if (verifyElementPresent.size() == 0) {
			return false;
		}
		return true;
	}

	//Read text from the browser
	public static String readText(List<WebElement> verifyElementPresent) {
		return verifyElementPresent.get(0).getText();
	}
	
	//Click on the link
	public static void click(WebElement clickElement){
		clickElement.click();
	}
	
	//Enter text inside text field
	public static void enterTextInField(WebElement textToEnter, String text){
		textToEnter.sendKeys(text);
	}
	
	//Log error messages
	public static void reportLogging(boolean actualResult, String ErrorMessage){
		if(!actualResult){
			WebConnector.log(ErrorMessage);
			Assert.assertEquals(true, actualResult);
		}
	}
}
