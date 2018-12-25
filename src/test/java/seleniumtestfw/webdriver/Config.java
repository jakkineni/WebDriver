package seleniumtestfw.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Config {
	
	public void testConfig() throws Exception {
		File configsrc = new File("./configuration/Config.property");
		FileInputStream fis = new FileInputStream(configsrc);
		Properties configProperties = new Properties();
		configProperties.load(fis);
		}

}
