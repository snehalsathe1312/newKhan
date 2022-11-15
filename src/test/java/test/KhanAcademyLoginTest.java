package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.KhanAcademyLandingPage;
import pom.KhanAcademyLoginPage;
import utility.BaseClass;
import utility.Parametrization;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class KhanAcademyLoginTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		reports= Reports.createReports();
		
	}
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser) {
		driver=Browser.openBrowser(browser);
	}
	@Test
	public void khanAcademyTest() throws EncryptedDocumentException, IOException, InterruptedException {
		test= reports.createTest("KhanAcademyLoginTest");
		
		KhanAcademyLandingPage khanAcademyLandingPage= new KhanAcademyLandingPage(driver);
		khanAcademyLandingPage.clickOnLogin();
		
		 KhanAcademyLoginPage  khanAcademyLoginPage= new  KhanAcademyLoginPage(driver);
		 khanAcademyLoginPage.enterEmail(Parametrization.getExcelData("TestData", 0, 0), driver);
		 khanAcademyLoginPage.enterPassword(Parametrization.getExcelData("TestData", 1, 0));
		 khanAcademyLoginPage.clickOnSubmit();
		 Thread.sleep(4000);
		 String expectedTitle="Dashboard | Khan Academy";
		 Assert.assertEquals(driver.getTitle(), expectedTitle);
		
		
	}
	@AfterMethod
	public void captureResult(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
			
		}else if (result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, result.getName());
			
		}
		else{
			test.log(Status.SKIP, result.getName());
		}
		
	}

@AfterTest
public void publishReport() {
	reports.flush();
}
}
