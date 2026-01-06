package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	
	@Test(priority = 1)
	public void TC01_InValidLogin()
	{
		LoginPage page = new LoginPage(driver);
			page.enterUsername("Admin123");
			page.enterPassword("Admin");
			page.clickOnLogin();
			String loginErrorMessage = page.verifyloginFailErrorMessage();
			Assert.assertEquals(loginErrorMessage, "Invalid credentials");
			
		
	}
	
	@Test(priority = 2)
	public void TC02_ValidLogin()
	{
		LoginPage page = new LoginPage(driver);
			page.enterUsername("Admin");
			page.enterPassword("admin123");
			page.clickOnLogin();
			//System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "OrangeHRM");
			
		
	}
	


}
