package testingSelenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	@BeforeSuite
	public void beforeSuite() 
	{
		System.out.println("This will execute before suite");
	}
	
	@BeforeTest
	public void beforeTest() 
	{
		System.out.println("This will execute before test");
	}

	@BeforeClass
	public void beforeClass() 
	{
		System.out.println("This will execute before class");
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("This will execute before method");
	}
	
	@BeforeGroups
	public void beforeGroup() 
	{
		System.out.println("This will execute before group");
	}
	
	@AfterSuite
	public void afterSuite() 
	{
		System.out.println("This will execute after suite");
	}
	
	@AfterTest
	public void afterTest() 
	{
		System.out.println("This will execute after test");
	}

	@AfterClass
	public void afterClass() 
	{
		System.out.println("This will execute after class");
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		System.out.println("This will execute after method");
	}
	
	@AfterGroups
	public void afterGroup() 
	{
		System.out.println("This will execute after group");
	}
	
	@Test
	public void test()
	{
		System.out.println("This is a test case");
	}
}
