package Hard_Soft_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
	
//	Soft Assert vs Hard Assert in TestNG:
//
//	+hard assertion: hard validation: if a hard assertion is getting failed: immediately test case will me marked as failed and test case will be terminated.
//
//	+soft assertion : soft validation: if a soft assertion is getting failed: test case will not be marked as passed as well as next lines will be executed
//
//	+assertAll() : is used to mark the test case as failed, if any soft assertion is getting failed
//	
	
	@Test
	public void test1() {
		//example of hard assertion
		System.out.println("open the browser");
		Assert.assertEquals(true, false ,"login failed");
		System.out.println("enter the url of login page");
		System.out.println("enter the email");
		System.out.println("enter the password");
		System.out.println("click the login button");
	}
	
	
	@Test
	public void test2() {
		//example of soft assertion
		
		SoftAssert softAssert = new SoftAssert();
		System.out.println("open the browser");
		softAssert.assertEquals(true, false,"login failed");
		System.out.println("enter the url of login page");
		System.out.println("enter the email");
		System.out.println("enter the password");
		System.out.println("click the login button");
	}
	
	
	@Test
	public void test3() {
		//example of soft assertion
		
		SoftAssert softAssert = new SoftAssert();
		System.out.println("open the browser");
		softAssert.assertEquals(true, false,"login failed");
		System.out.println("enter the url of login page");
		System.out.println("enter the email");
		System.out.println("enter the password");
		System.out.println("click the login button");
		softAssert.assertAll();
	}
	

}
