package testingSelenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleBrowserTest {
	
	WebDriver driver;
	
	@Parameters("browser")
	
	@BeforeClass
	public void baseClass(String browser)
	{
		if(browser.equalsIgnoreCase("firefox")) 
		{
		
			System.setProperty("webdriver.gecko.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			System.out.println("Firefox browser opened successfully!!");
			
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();

			//Maximize the browser
			driver.manage().window().maximize();
			
			System.out.println("Chrome browser opened successfully!!");
		}
		
		//Adding Implict wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String url = "https://demo.guru99.com/V4/index.php";
		driver.get(url);
	
	}
	
	@AfterClass
	public void tear()
	{
		driver.close();
	}
	
	@Test
	public void multipleBrowser() throws InterruptedException
	{
		WebElement userName = driver.findElement(By.name("uid"));
		userName.clear();
		userName.sendKeys("mngr511845");
		Thread.sleep(2000);
		
		WebElement passWord = driver.findElement(By.name("password"));
		passWord.clear();
		passWord.sendKeys("jYmetet");
		Thread.sleep(2000);
		
		WebElement buttonSignIn = driver.findElement(By.name("btnLogin"));
		buttonSignIn.click();
		Thread.sleep(2000);
		
		String userText = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
		System.out.println(userText);
		Thread.sleep(2000);
		
		WebElement linkSignOut = driver.findElement(By.linkText("Log out"));
		linkSignOut.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();		
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Thread.sleep(2000);
	}

}
