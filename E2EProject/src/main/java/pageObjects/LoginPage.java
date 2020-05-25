package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver driver;

	private By registeredEmail = By.cssSelector("input[id='email']");
	private By password = By.cssSelector("input[id='passwd']");
	private By signIn = By.cssSelector("button[id='SubmitLogin']");
	private By title = By.cssSelector("h1[class='page-heading']");
	private By forgotPassword = By.cssSelector("a[title='Recover your forgotten password']");
	
	public WebElement getEmail() {
		return driver.findElement(registeredEmail);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getSignIn() {
		return driver.findElement(signIn);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public ForgotPasswordPage getForgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPasswordPage(driver);
	}
}
