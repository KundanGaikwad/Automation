package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

//Help and free support from 12 year exp(Udemy)
//rahulonlinetutor@gmail.com

public class Authentication extends Base {
	
	//we are storing value in this class object so we will not get issue with
	//Parallel execution
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initializeAndOpenStore() throws IOException {
		// Method of Base class with Base class object
		driver = initializeDriver();
		log.info("Driver is initialzed");

		// Open URL
		driver.get(properties.getProperty("url"));
		log.info("Navigated to Home Page");
	}

	@Test(dataProvider = "getData")
	public void login(String username, String password) throws IOException {
		
		// Created object to access Home page elements
		LandingPage landingPage = new LandingPage(driver);

		// Verify Header
		Assert.assertTrue(landingPage.getHeader().isDisplayed());

		// Click on sign in button and you will move to another page
		LoginPage loginPage = landingPage.getLogin();

		// Validate Text
		Assert.assertEquals(loginPage.getTitle().getText(), "AUTHENTICATION");

		// Type emailId
		loginPage.getEmail().sendKeys(username);

		// Type password
		loginPage.getPassword().sendKeys(password);

		// Click on login button
		loginPage.getSignIn().click();
		
		log.info("Login successfully");

	}

	@Test
	public void forgotPassword() throws IOException {

		// Click on sign In button
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.getLogin();

		// Click on forgot password
		ForgotPasswordPage forgotPasswordPage = loginPage.getForgotPassword();

		// Verify Title
		Assert.assertEquals(forgotPasswordPage.getTitle().getText(), "FORGOT YOUR PASSWORD?");

		log.info("Open forgot password page");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];

		data[0][0] = "kundangaikwad5@gmail.com";
		data[0][1] = "Pass@123456";

		/*
		 * data[1][0] = "invalid@email.com"; data[1][1] = "invalid";
		 */

		return data;
	}

	/*@AfterTest
	public void tearDown() {
		driver.close();
	}*/
}
