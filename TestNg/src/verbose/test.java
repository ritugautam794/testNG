package verbose;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ritu Gautam\\Downloads\\chromedriver_win32_90\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
	}
	
	@Test
    public void test1() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "abc");
	}

	@Test
    public void test2() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Facebook - లాగిన్ లేదా సైన్ అప్");
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	
    }

}
