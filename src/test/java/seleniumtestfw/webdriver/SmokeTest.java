package seleniumtestfw.webdriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.AssertJUnit;
import org.testng.*;
import org.testng.annotations.Test;

import com.gmail.pages.gmailLoginPageFactory;
import utility.BrowserFactory;
import utility.ConfigReader;
import com.gmail.pages.LoadGmailHomePage;
import com.gmail.pages.MailPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class SmokeTest {
	
	ConfigReader config;
	
	WebDriver driver = BrowserFactory.startbrowser();
	
	@Test(priority=1)
	public void VerifyGmail() {	
		LoadGmailHomePage gmailhomepage = PageFactory.initElements(driver, LoadGmailHomePage.class);
		gmailhomepage.loadpage();
		//gmailhomepage.loadpage();
		String expectedTitle = "Gmail"; 
		System.out.println(gmailhomepage.getPageTitle());
			
		try{
			  AssertJUnit.assertEquals(gmailhomepage.getPageTitle(), expectedTitle);
			  System.out.println("Navigated to correct webpage");
			}
			catch(Throwable pageNavigationError){
			  System.out.println("Didn't navigate to correct webpage");
			}
		
	}
	
	@Test(priority=2)
	public void GmailLogin() {
		ConfigReader config = new ConfigReader();
		gmailLoginPageFactory loginpage = PageFactory.initElements(driver, gmailLoginPageFactory.class);
		
		loginpage.typeusername(config.getUserID());
		loginpage.nextbutton_click();
		
		loginpage.txtpassword(config.getPassword());
		loginpage.passwordnext_button_click();
		AssertJUnit.assertTrue(loginpage.verifyValidLogin());
		System.out.println("Valid login");
		}
			
	
		@Test(priority=3)
		public void googleapps() throws Exception {
		MailPage mpage = new MailPage(driver);
		mpage.selectanddeleteprimaryemail();
		mpage.clickAppbutton();
		AssertJUnit.assertTrue(mpage.verifyMapsButton());
		System.out.println("google apps button was clicked");
		//AssertJUnit.assertTrue(mpage.GoogleApps_screenshot());
		
		}
		
	}
	

		
	
	

