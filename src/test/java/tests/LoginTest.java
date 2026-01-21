package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	
	@Test(priority=1)
	public void TC01_loginwithInvalidCredential() {
		Log.info("Starting login test with InValid Credential...");
		test = ExtentReportManager.createTest("Login Test - Invalid Credential");
		test.info("Navigating to URL");
		LoginPage page = new LoginPage(driver);
		Log.info("Entering invalid credential");
		test.info("Entering invalid credential");
		page.enterUsername("Admin123");
		page.enterPassword("Admin");
		Log.info("Clicking on login button");
		test.info("Clicking on login button");
		page.clickOnLogin();
		Log.info("Verifying login error message");
		test.info("Verifying login error message");
		String loginErrorMessage = page.verifyloginFailErrorMessage();
		Assert.assertEquals(loginErrorMessage, "Invalid credentials");
		Log.info("Login fail error message validated");
		test.info("Login fail error message validated");

	}
	
	@Test(priority=2)
	public void TC02_loginwithValidCredential() {
		Log.info("Starting login test with Valid Credential...");
		test = ExtentReportManager.createTest("Login Test - Valid Credential");
		test.info("Navigating to URL");
		LoginPage page = new LoginPage(driver);
		Log.info("Entering valid credential");
		test.info("Entering valid credential");
		page.enterUsername("Admin");
		page.enterPassword("admin123");
		Log.info("Clicking on login button");
		test.info("Clicking on login button");
		page.clickOnLogin();
		// System.out.println(driver.getTitle());
		Log.info("Verifying page title");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		Log.info("Login successful");
		test.info("Login successful");
		
		}


}
