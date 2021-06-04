package RetryLogicinTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTests {
	
	//@Test(retryAnalyzer = Analyzer.RetryAnalyzer.class)
	@Test
	public void test1() {
		Assert.assertEquals(false, true);
	}
	
	//@Test(retryAnalyzer = Analyzer.RetryAnalyzer.class)
	@Test
	public void test2() {
		Assert.assertEquals(false, true);
	}

}
