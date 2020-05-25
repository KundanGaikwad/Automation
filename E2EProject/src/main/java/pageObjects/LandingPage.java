package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	//Constructor
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver driver;
	
	private By signIn = By.cssSelector("a[class='login']");
	private By header = By.cssSelector("header[id='header']");
	private By headerContactUs = By.cssSelector("a[title='Contact Us']");

	public LoginPage getLogin() {
		driver.findElement(signIn).click();
		return new LoginPage(driver);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}

	public WebElement getHeaderContactUs() {
		return driver.findElement(headerContactUs);
	}

	
}
