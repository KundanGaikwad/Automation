package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.LandingPage;
import resources.Base;

//Help and free support from 12 year exp(Udemy)
//rahulonlinetutor@gmail.com

public class Home extends Base{
	
	//we are storing value in this class object so we will not get issue with
	//Parallel execution
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializeAndOpenStore() throws IOException {
		// Method of Base class with Base class object
		driver = initializeDriver();
		log.info("Driver is initialized");

		// Open URL
		driver.get(properties.getProperty("url"));
		log.info("Navigated to Home Page");
	}


	@Test(dataProvider = "getData")
	public void headerContactUs(String email, String orderReference, String message) throws IOException {
		
		//Click on contact us
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getHeaderContactUs().click();
		
		///Select Subject Heading
		ContactUsPage contactUsPage = new ContactUsPage(driver);
		Select selectSubjectHeading = new Select(contactUsPage.getSubjectHeadingDropdown());
		selectSubjectHeading.selectByIndex(1);
		
		//Enter email address
		contactUsPage.getEmail().sendKeys(email);
		
		//Enter order refernce
		contactUsPage.getOrderReference().sendKeys(orderReference);
		
		//Enter message
		contactUsPage.getMessage().sendKeys(message);
		
		//Click on send button
		contactUsPage.getSubmitMessage().click();
		
		log.info("Successfully send an msg to customer servie");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][3];
		
		data[0][0] = "kundangaikwad5@gmail.com";
		data[0][1] = "100";
		data[0][2] = "We got a problem";
		
		/*data[1][0] = "invalid@email.com";
		data[1][1] = "invalid";*/
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
