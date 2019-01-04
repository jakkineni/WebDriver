package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ConfigReader;

public class testGApp implements testGoogleApps {
	
	WebDriver driver;
	WebElement element;
	ConfigReader getappurl;
	
	public testGApp(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	//WebElement account = driver.findElement(By.xpath("//*[@id=\"gb192\"]"));
	
	
	public boolean testAppVisible(String appname, String appURL, WebElement element) {
		getappurl = new ConfigReader();
		String accounturl = getappurl.getgappAccounturl();		
		if (accounturl.equals(element.getAttribute("href"))) {
			element.click();
			return true;
		}
		else {
			return false;
		}
	}

	public void testAppLink() {
		// TODO Auto-generated method stub
		
	}
	

}
