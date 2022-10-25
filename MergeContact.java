package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		//Calling WDM for the browser driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username and pwd using id locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on the login button using class locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on contacts button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click on merge contacts button
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//Click on Widget From Contact
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		
		//Click on first resulting contact.It opens up in the new window.So get the window handle of it and move the control there
		//Get the list of all the window handles and store it in a set
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		
		//Convert the set into a list so we can use the get method
		List<String> lstWindowHandles = new ArrayList<String>(windowHandles);
		
		//Get the second window handle and store it in a variable secondWindowHandle
		String secondWindowHandle = lstWindowHandles.get(1);
		String firstWindowHandle = lstWindowHandles.get(0);
		
		//Switch the control to second window
		driver.switchTo().window(secondWindowHandle);
		
		//Click on the first resulting link
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//switch to primary window
		driver.switchTo().window(firstWindowHandle);
		
		//Click on the To Contact widget
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
		//Get the list of all the window handles and store it in a set
		 Set<String> windowHandles1 = driver.getWindowHandles();
		 System.out.println(windowHandles1.size());
		 
		//Convert the set into a list so we can use the get method
			List<String> lstWindowHandles1 = new ArrayList<String>(windowHandles1);
			
		//Get the second window handle and store it in a variable secondWindowHandle
			String secondWindowHandle1 = lstWindowHandles1.get(1);
			
		 
		//Switch to second window
		driver.switchTo().window(secondWindowHandle1);
		
		
		//Click on second resulting link
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		
		//Switch to primary window
		driver.switchTo().window(firstWindowHandle);
		
		//Click Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Accept the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Verify the title of the page
		System.out.println(driver.getTitle());
		
	
		// TODO Auto-generated method stub

	}

}
