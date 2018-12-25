/**
 * 
 */
package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PerformActions;

/**
 * @author SunnyBunny
 *
 */
public class gmailLoginPageFactory {
	
	WebDriver driver;
	WebDriverWait explicitwait;
	PerformActions action;
		
	public gmailLoginPageFactory(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(how=How.ID,using="identifierId") 
	WebElement txtuname;
	
	@FindBy(how=How.ID,using="identifierNext")
	WebElement next_button;
	
	@FindBy(how=How.ID,using="password")
	WebElement txtpassword;
	
	@FindBy(how=How.ID,using="passwordNext")
	WebElement passwordnext_button;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"password\"]/div[1]/div/content")
	WebElement viewhidepassword_button;
	
	@FindBy(how=How.ID,using=":2o")
	WebElement tabPrimary;
		
	public void typeusername(String uid) {
		txtuname.sendKeys(uid);
	}
	
	public void nextbutton_click() {
		next_button.click();
	}
	
	public void txtpassword(String pass){
		action = new PerformActions();
		explicitwait = new WebDriverWait(driver,100);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		action.TypeKeysAction(driver,txtpassword, pass);
		
		// check if the password is typed completely
		if (txtpassword.getText() == "Enter your password") {
			//txtpassword.clear();
			action.TypeKeysAction(driver,txtpassword, pass);
			System.out.println("txtpassword.getText() after retry" + txtpassword.getText());
		}
		}

	public void passwordnext_button_click() {
		action = new PerformActions();
		explicitwait = new WebDriverWait(driver,100);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordNext")));
		action.ClickButtonAction(driver, passwordnext_button);
	}
	
	public boolean verifyValidLogin() {
		explicitwait = new WebDriverWait(driver,100);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":2o")));
		if (tabPrimary.isDisplayed()) {
			return true;
		}
		else {
				return false;
		}
	}
}
