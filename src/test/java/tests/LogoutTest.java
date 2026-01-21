package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.LogoutPage;
import utils.ExtentReportManager;
import utils.Log;

public class LogoutTest extends BaseTest {
	
	//Login is a pre-condition is here thats why added here with before method
	 @BeforeMethod
	    public void loginBeforeLogout() {

	        Log.info("Logging in as precondition for Logout test");
            LoginPage login = new LoginPage(driver);
	        login.enterUsername("Admin");
	        login.enterPassword("admin123");
	        login.clickOnLogin();

	        Log.info("Login successful - proceeding to logout test");
	    }
	
	 @Test
	public void TC03_logout()
	{
		Log.info("Starting logout process...");
		test = ExtentReportManager.createTest("Logout Test");
		test.info("Navigating to Logout page");
		LogoutPage page = new LogoutPage(driver);
		page.clickOnLogout();
		Log.info("Logout successful");
		Assert.assertTrue(page.isLoginButtonDisplayed(),
		        "Login button should be visible after logout");
		test.info("Logout successful and login page displayed");
		Log.info("Logout successful and login page displayed");
	}
	
	

}
