/**
 * 
 */
package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author JahnaviAkkineni
 *	This class contains methods to choose and start a browser based on input parameters
 */
public class BrowserFactory {
	ConfigReader config;
	static WebDriver driver;
	
	public static WebDriver startbrowser() {
		ConfigReader config = new ConfigReader();
		String browsername = config.getBrowserName();
		
		if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver = new ChromeDriver();
			
		}
		else if (browsername.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", config.getIEDriverPath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		return driver;

	}
}
