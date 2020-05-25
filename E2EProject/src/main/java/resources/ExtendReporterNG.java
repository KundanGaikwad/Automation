package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//For this you need extend report dependencies
public class ExtendReporterNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject(){
		
		//user.dir gives path till our project
		String path = System.getProperty("user.dir")+"\\reports"+"\\index.html";
		
		//To create a file with name index.html
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Kundan Gaikwad");
		
		return extent;
		
	}

}
