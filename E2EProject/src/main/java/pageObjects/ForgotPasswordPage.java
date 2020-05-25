package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

	// Constructor
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver driver;

	private By title = By.cssSelector("h1[class='page-subheading']");
	
	public WebElement getTitle() {
		
		return driver.findElement(title);
	}
}
