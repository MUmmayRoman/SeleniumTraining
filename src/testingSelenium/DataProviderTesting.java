package testingSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTesting {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void setup()
	{
		//Launch a new chrome browser.
		
		System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();

		//Maximize the browser
		driver.manage().window().maximize();
								
		//Adding Implict wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String url = "https://demo.guru99.com/V4/index.php";
		driver.get(url);
				
	}
	
	@AfterClass
	public void tear()
	{
		 
		//Close the Browser.
	      driver.close();
	}
	
	@DataProvider
	public Object LoginCredentials()
	{
		Object[][] credential = new Object[2][2];
		
		credential[0][0] = "mngr511845";
		credential[0][1] = "jYmetet";
		
		credential[1][0] = "mngr511847";
		credential[1][1] = "rEpYgug";
		
		
		return credential;
		
	}
	
	
	
	@Test(dataProvider = "LoginCredentials")
	public void multipleLogin(String Email, String Password) throws InterruptedException
	{
		WebElement userName = driver.findElement(By.name("uid"));
		userName.clear();
		userName.sendKeys(Email);
		Thread.sleep(2000);
		
		WebElement passWord = driver.findElement(By.name("password"));
		passWord.clear();
		passWord.sendKeys(Password);
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
