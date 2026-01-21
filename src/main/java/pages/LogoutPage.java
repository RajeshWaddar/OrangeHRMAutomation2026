package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By logoutUserDropDown = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	private By logoutButtonField = By.xpath("//a[normalize-space()='Logout']");
	private By loginButton = By.xpath("//button[normalize-space()='Login']");
	
	
	public LogoutPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	}
	
	public void clickOnLogout()
	{
		 wait.until(ExpectedConditions.elementToBeClickable(logoutUserDropDown)).click();
		 wait.until(ExpectedConditions.elementToBeClickable(logoutButtonField)).click();
		//driver.findElement(logoutUserDropDown).click();
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonField));
		//element.click();
	}
	
	public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton))
                   .isDisplayed();
    }

}
