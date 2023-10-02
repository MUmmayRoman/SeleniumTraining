package testingSelenium;

import org.testng.annotations.Test;

public class MultipleTest {
	
	@Test(priority = 0)
	public void One()
	{
		System.out.println("First Testcase");
	}
	
	@Test(priority = 1)
	public void Two()
	{
		System.out.println("Second Testcase");
	}
	
	@Test(priority = 2, enabled = false)
	public void Three()
	{
		System.out.println("Third Testcase");
	}
	
	
	@Test(priority = 3, enabled = false)
	public void Four()
	{
		System.out.println("Fourth Testcase");
	}
	
	@Test(priority = 4, invocationCount = 5)
	public void Five()
	{
		System.out.println("Fifth Testcase");
	}

}
