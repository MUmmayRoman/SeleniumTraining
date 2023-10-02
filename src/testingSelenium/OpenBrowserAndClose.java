package testingSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowserAndClose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize the webdriver
		
		WebDriver driver;
		
		//Open a chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		
		//Close the browser
		driver.close();
		System.out.println("Browser Close successfully!!");

	}

}
