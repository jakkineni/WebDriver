/**
 * 
 */
package com.gmail.pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import utility.PerformActions;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * @author JahnaviAkkineni
 * This page contains elements on the gmail page post login and validates the apps, 
 * contains image compare
 */
public class MailPage {
	
	WebDriver driver;
	WebElement e;
	WebDriverWait explicitwait;
	
	public MailPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	public void clickAppbutton() {
		explicitwait = new WebDriverWait(driver,100);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.google.com/intl/en/about/products?tab=mh']")));
		driver.findElement(By.xpath("//a[@href='https://www.google.com/intl/en/about/products?tab=mh']")).click();
	}
	
	public boolean verifyMapsButton() {
		if((driver.findElement(By.xpath("//a[@href='https://maps.google.com/maps?hl=en&tab=ml']"))).isDisplayed()) {
			return true;
		}
		else {
			return false;		
		}	
	}
	
	public void selectanddeleteprimaryemail() {
		explicitwait = new WebDriverWait(driver,100);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=':33']/div[1]/span")));
		WebElement select_checkbox = driver.findElement(By.xpath("//*[@id=':33']/div[1]/span"));
		select_checkbox.click();
		String status_selectcheckbox = select_checkbox.getAttribute("aria-checked");
		System.out.println(status_selectcheckbox);
		
		//if (status_selectcheckbox == "true") {
			WebElement delete_button = driver.findElement(By.xpath("//*[@id=\":5\"]/div/div[1]/div[1]/div/div/div[2]/div[3]"));
			delete_button.click();
		//}
		//else {
			//System.out.println("Unable to delete email");
		//}
		
	} 
	
	public boolean MailPage_screenshot() {
		//WebElement gapps;
		String imgresource_path = "C:\\Users\\SunnyBunny\\eclipse-workspace\\Selenium\\webdriver\\imgresources";
		File image = new File(imgresource_path + "\\gApps.jpg");
		//BufferedImage expectedimage = ImageIO.read(image);
		
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);
		
		if (!ImagePresent) {
			System.out.println("Image not present");
			return false;
		}
		else {
			System.out.println("Image present");
			return true;
		}
				
		//Shutterbug.(driver,ScrollStrategy.BOTH_DIRECTIONS).withName("GApps").save("imgresource_path");
	}
}
