package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceWindowHandles {

	public static void main(String[] args) {
		//Calling WDM for the browser driver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				
				//Launch URL
				driver.get("https://login.salesforce.com/");
				
				//Maximize the window
				driver.manage().window().maximize();
				
				//Add implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
				
				//Enter the username
				driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
				
				//ENter the password
				driver.findElement(By.id("password")).sendKeys("Password#123");
				
				//Click the login button
				driver.findElement(By.xpath("//input[@id='Login']")).click();
				
				//Click the Lear More link under mobile publisher
				driver.findElement(By.xpath("//span[text()='Learn More']")).click();
				
				//Switch the control to second window
				//Create a set of window handles
				Set<String> windowHandles = driver.getWindowHandles();
				
				//Convert the set into list
				List<String> list_windowHandles = new ArrayList<String>(windowHandles);
				
				//Get the second window handle
				String second_windowHandle = list_windowHandles.get(1);
				
				//Switch the control to second window
				driver.switchTo().window(second_windowHandle);
				
				//Click the confirm button
				driver.findElement(By.xpath("//button[text()='Confirm']")).click();
				
				//Get the title of second window
				System.out.println(driver.getTitle());
				
				//Get back to the parent window
				String first_windowHandle = list_windowHandles.get(0);
				driver.switchTo().window(first_windowHandle);
				
				//Close the browser
				driver.quit();
			
		// TODO Auto-generated method stub

	}

}
