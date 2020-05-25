package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {

	// Constructor
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver driver;

	private By title = By.xpath("//h1[@class='page-heading bottom-indent']");
	private By subjectHeadingDropdown = By.xpath("//select[@id='id_contact']");
	private By email = By.xpath("//input[@id='email']");
	private By orderReference = By.xpath("//input[@id='id_order']");
	private By submitMessage= By.cssSelector("button[name='submitMessage']");
	private By message = By.cssSelector("textarea[id='message']");
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getSubjectHeadingDropdown() {
		return driver.findElement(subjectHeadingDropdown);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getOrderReference() {
		return driver.findElement(orderReference);
	}
	
	public WebElement getSubmitMessage() {
		return driver.findElement(submitMessage);
	}
	
	public WebElement getMessage() {
		return driver.findElement(message);
	}
	
	
	
	
	
	
}
