package Testng_listeners;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class addscreenshot_inTestNG extends Base {
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
	}
	
	@Test
	public void launchChrome() {
		System.out.println("launch chrome browser");
		Assert.assertEquals(true, false);
	}
	
	@AfterMethod
    public void tearDown(){
		driver.quit();	
	}
	
	

}
