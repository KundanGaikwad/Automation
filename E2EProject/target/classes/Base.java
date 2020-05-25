package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	public Properties properties;
	
	public WebDriver initializeDriver() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		//Reads a property list (key and element pairs) from the input byte stream. 
		properties.load(fis);
		
		//To provide browser info to mvn
		//mvn test -Dbrowser=chrome (hit this in cmd)
		//String browserName = System.getProperty("browser");
		
		//Load value in local variable 
		String browserName = properties.getProperty("browser");
		
		//Note:= Here we can not use == for comparison because here it will 
		//act as compare by references
		if(browserName.contains("chrome")) {
			//Execute in chrome browser
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			
			if(browserName.contains("headless")) {
				//This option we can use to run tests in the background.
				option.addArguments("headless");
			}
			
			driver = new ChromeDriver(option);
			
		} else if (browserName.equals("firefox")) {
			//Execute in firefox browser
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else if (browserName.equals("IE")) {
			////Execute in IE browser
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		//Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenShotPath(String testName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testName+".png";
		//For latest version you need Apache common IO dependency
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
