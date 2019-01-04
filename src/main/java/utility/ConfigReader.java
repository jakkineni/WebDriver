package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties configProperties;
	Properties gappProperties;
	
	public ConfigReader(){
		try {
			File configsrc = new File("./configuration/Config.property");
			FileInputStream fis = new FileInputStream(configsrc);
			configProperties = new Properties();
			configProperties.load(fis);
			
			File gappsrc = new File("./configuration/appurl.property");
			FileInputStream fis_gapp = new FileInputStream(gappsrc);
			gappProperties = new Properties();
			gappProperties.load(fis_gapp);
			}
		catch (Exception e) {
			System.out.println("Excpeion is:" + e.getMessage());
		}
			
	}
	
	public String getChromePath() {
		String chromepath = configProperties.getProperty("ChromeDriver");
		return chromepath;		
	}
	
	public String getIEDriverPath() {
		String chromepath = configProperties.getProperty("IEDriver");
		return chromepath;		
	}

	public String getApplicationUrl() {
		String url = configProperties.getProperty("URL");
		return url;
	}

	public String getUserID() {
		String uid = configProperties.getProperty("UID");
		return uid;
	}
	
	public String getPassword() {
		String password = configProperties.getProperty("Password");
		return password;		
	}
	
	public String getBrowserName() {
		String browserName = configProperties.getProperty("BrowserName");
		return browserName;		
	}
	
	public String getgappAccounturl() {
		String gappAccounturl = gappProperties.getProperty("account");
		return gappAccounturl;
	}
}
