package Academy.E2EProject;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtendReporterNG;

//This class is used for moniter our tests.
//This class is made to take screenshot, generate extend report
/*Note : 1) You will not see override methods from interface. To see those methods
 * right click on class = click on source = click on override methods
 * 
 * 2) You need to provide information abt listeners in testng.xml*/ 
public class Listeners extends Base implements ITestListener{

	ExtentTest test;
	ExtentReports extent = ExtendReporterNG.getReportObject();
	//We are makeing test object thread safe for parallel execution
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
	
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		//Screenshot - This is thread safe
		String testMethodName = result.getMethod().getMethodName();
		
		WebDriver driver;
		try {
			//To access field of the class - Here driver is a field
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
			//To add screenshot in local machine and in extent report
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//To attach log of failure to the report
		extentTest.get().fail(result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
	
		//Writes test information from the started reporters to their output view
		extent.flush();
	}

}
