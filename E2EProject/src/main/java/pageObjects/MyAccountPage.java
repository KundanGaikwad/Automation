package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	// Constructor
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver driver;

	private By title = By.cssSelector("h1[class='page-heading']");
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	

}
