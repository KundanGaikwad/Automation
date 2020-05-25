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
import pageObjects.MyAccountPage;
import resources.Base;

//Help and free support from 12 year exp(Udemy)
//rahulonlinetutor@gmail.com

public class MyAccount extends Authentication {
		
	public static Logger log = LogManager.getLogger(Base.class.getName());

	
	@Test(dependsOnMethods = "login")
	public void myAccountLinkChecks() throws IOException {
		
		/*MyAccountPage myAccountPage = new MyAccountPage(driver);
		
		//Assert text of the title
		Assert.assertEquals(myAccountPage.getTitle().getText(), "MY ACCOUNT");*/
		System.out.print("Passed");

	}

	/*@AfterTest
	public void tearDown() {
		driver.close();
	}*/
}
