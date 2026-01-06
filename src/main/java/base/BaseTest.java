package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
			driver.quit();
	}

}
