/**
 * 
 */
package com.gmail.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;

import utility.BrowserFactory;
import utility.ConfigReader;

/**
 * @author SunnyBunny
 *
 */
public class LoadGmailHomePage {
	WebDriver driver;
	ConfigReader config;
	
	public LoadGmailHomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public String getPageTitle() {
		String pagetitle = driver.getTitle();
		return pagetitle;
	}
	
	public void loadpage() {
		ConfigReader config = new ConfigReader();
		driver.get(config.getApplicationUrl());
	}

}
