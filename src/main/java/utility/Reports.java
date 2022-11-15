package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports createReports() {
		ExtentReports reports= new ExtentReports();
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("ExtentReport.html");
		
		reports.attachReporter(sparkReporter);
		
		
		reports.setSystemInfo("Test", "Regression");
		
		return reports;
	}

}

