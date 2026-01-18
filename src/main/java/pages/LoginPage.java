package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;



public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	private By usernameTextField = By.xpath("//input[@placeholder='Username']");
	private By passwordTextField = By.xpath("//input[@placeholder='Password']");
	private By loginButton = By.xpath("//button[normalize-space()='Login']");
	private By LoginFailErrorMessage = By.xpath("//p[normalize-space()='Invalid credentials']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public void enterUsername(String username) {
		Log.info("Enter Username...");
		// driver.findElement(usernameTextField).sendKeys(username);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextField));
		element.sendKeys(username);
	}

	public void enterPassword(String password) {
		Log.info("Enter Password...");
		driver.findElement(passwordTextField).sendKeys(password);
	}

	public void clickOnLogin() {
		Log.info("Clicking on Login...");
		driver.findElement(loginButton).click();
	}

	public String verifyloginFailErrorMessage() {
		Log.info("Verify Login Error Message...");
		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginFailErrorMessage));
		return errorMsg.getText();
	}

}
