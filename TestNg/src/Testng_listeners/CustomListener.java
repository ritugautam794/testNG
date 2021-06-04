package Testng_listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


public class CustomListener extends Base implements ITestListener {
	@Override
	 public void onTestStart(ITestResult result) {
		    // not implemented
		  }
	@Override
	 public void onTestSuccess(ITestResult result) {
		    // not implemented
		  }
	
	@Override
	public void onTestFailure(ITestResult result) {
	    System.out.println("Faild test");
	    TakeSrennshotforFailedTestcases(result.getMethod().getMethodName());
	  }
	@Override
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }
	
	

}
