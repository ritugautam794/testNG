package AddScreenshotInExtentReports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ScreenshotInExtentReports {
	
	public WebDriver driver;
	public ExtentReports extentreport ;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent() {
	//	extentreport = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extentreport = new ExtentReports("C:\\Users\\Ritu Gautam\\git\\repository-testng\\TestNg\\test-output"+"/test-output/ExtentReport.html", true);
		extentreport.addSystemInfo("Host Name", "Ritu Gautam");
		extentreport.addSystemInfo("Env Name", "QA Env");
		
		
	}
	
	@AfterTest
	public void endReport() {
		extentreport.flush();
		extentreport.close();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\Users\\Ritu Gautam\\git\\repository-testng\\TestNg\\test-output"+"/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
		
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ritu Gautam\\Downloads\\chromedriver_win32_90\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");
		extentTest = extentreport.startTest("freeCrmTitleTest");
		
	}
	
	@Test
	public void CRMTestTitle() {
		extentTest = extentreport.startTest("freeCrmTitleTest");
		String title= driver.getTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
		
	}
	
	@Test
	public void FreeCRMLinkTest() {
		extentTest = extentreport.startTest("freeCrmTitleTest");
		WebElement freecrmlink= driver.findElement(By.xpath("//a[contains(text(),'Free CRM')]"));
		String text= freecrmlink.getText();
		Assert.assertEquals(text, "Free CRMbn");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = ScreenshotInExtentReports.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		extentreport.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}

}
