package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow {

	public static void main(String[] args) {
		//Calling WDM for the browser driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("https://leafground.com/window.xhtml");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		//Get the title of first window
		String titleFirstWindow = driver.getTitle();
		System.out.println(titleFirstWindow);
		
		
		//Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		
		//switch the control to second window to get its title
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindowHandles = new ArrayList<String>(windowHandles);
		String firstWindowHandle = lstWindowHandles.get(0);
		String secondWindowHandle = lstWindowHandles.get(1);
		driver.switchTo().window(secondWindowHandle);
		
		
		//Get the title of second window
		String titleSecondWindow = driver.getTitle();
		System.out.println(secondWindowHandle);
		
		//Check if both titles arent the same
		if(titleFirstWindow.equals(secondWindowHandle)) {
			System.out.println("Test not successfull");
		}
		else {
			System.out.println("Test successfull");
		}
		driver.close();
		driver.switchTo().window(firstWindowHandle);
		
		//Find the number of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		
		//Find the number of opened tabs
		Set<String> setWindowHandles = driver.getWindowHandles();
		int setWindowHandlesSize = setWindowHandles.size();
		System.out.println("The no of opened tabs are "+ setWindowHandlesSize);
		
		//Convert it into a list so you can get the window handles
		List<String> lstWindowHandles2 = new ArrayList<String>(setWindowHandles);
		String parentWindow = lstWindowHandles2.get(0);
		for(int i=1;i<=setWindowHandlesSize-1;i++) {
			driver.switchTo().window(lstWindowHandles2.get(i));
			driver.close();
			driver.switchTo().window(parentWindow);		
		}
		
		//Close all windows excpet the primary tab
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		Set<String> windowHandles3 = driver.getWindowHandles();
		int windowHandlesSize3= windowHandles3.size();
		List<String> lstWindowHandles3 = new ArrayList<String>(windowHandles3);
		String parentWindow3 = lstWindowHandles3.get(0);
		for(int i=1;i<=windowHandlesSize3-1;i++) {
			driver.switchTo().window(lstWindowHandles3.get(i));
			driver.close();
			driver.switchTo().window(parentWindow3);
			
			
		}
		
		//Wait for 2 new tabs to open
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
