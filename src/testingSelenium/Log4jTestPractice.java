package testingSelenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Log4jTestPractice {
	
	WebDriver driver;
	
	// Here we need to create logger instance so we need to pass Class name for 
    //which  we want to create log file in my case Google is classname
        Logger logger=Logger.getLogger("Log4jExample");
     
	
	@BeforeClass
	public void setup() throws InterruptedException
	{   
        	// configure log4j properties file
	         PropertyConfigurator.configure("Log4j.properties");
	   
	          // Open browser
	         System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
	 		 driver = new ChromeDriver();
	 		 Thread.sleep(2000);
	          logger.info("Browser Opened");
	        
	          // Set implicit wait
	          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	          logger.info("Implicit wait given");
	}
	
	@AfterClass
	public void tear() throws InterruptedException
	{
		// Close Browser
        driver.close();
        Thread.sleep(2000);
        logger.info("Browser Closed");
	}
	
	@Test
	public void log4jExample() throws InterruptedException
	{
		 // Load application
        driver.get("https://www.google.co.in/");
        Thread.sleep(2000);
        logger.info("Url opened");
        
        
        // Maximize Browser
        driver.manage().window().maximize();
        logger.info("Maximizing the browser");
      
 
        // type Selenium
        driver.findElement(By.name("q")).sendKeys("Selenium");
        Thread.sleep(2000);
        logger.info("keyword type");
        
		
	}

}
