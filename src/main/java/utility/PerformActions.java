/**
 * 
 */
package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author JahnaviAkkineni
 *
 */
public class PerformActions {
	
	Actions typeAction;
	Actions clickAction;
	WebDriver driver;
	WebElement e;
	
	public void TypeKeysAction(WebDriver driver,WebElement e,String s) {
		typeAction = new Actions(driver);
		typeAction.moveToElement(e);
		typeAction.sendKeys(e, s);
		typeAction.build().perform();
	}
	
	public void ClickButtonAction(WebDriver driver, WebElement e) {
		clickAction = new Actions(driver);
		clickAction.click(e);
		clickAction.build().perform();
	}
}