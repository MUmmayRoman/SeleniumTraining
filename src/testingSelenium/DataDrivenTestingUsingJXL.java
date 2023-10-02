package testingSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenTestingUsingJXL {

	
	public static void main(String[] args) throws BiffException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();

		//Maximize the browser
		driver.manage().window().maximize();
								
		//Adding Implict wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		FileInputStream fi = new FileInputStream("C:\\Roman's_WorkPlace\\Selenium\\Login.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		int z = s.getRows();
		System.out.println("The number of rows in an excel sheet are: " +z);
		
		
		String url = "https://demo.guru99.com/V4/index.php";
		driver.get(url);
		
		for(int row=0; row<z; row++) {
			
			String username = s.getCell(0, row).getContents();
			System.out.println("Username : " +username);
			
			WebElement text_Username = driver.findElement(By.name("uid"));
			text_Username.clear();
			text_Username.sendKeys(username);
			Thread.sleep(2000);
			
			String password = s.getCell(1, row).getContents();
			System.out.println("Password : " +password);
			
			WebElement text_Password = driver.findElement(By.name("password"));
			text_Password.clear();
			text_Password.sendKeys(password);
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
		
		driver.close();
		driver.quit();
		

	}

}
