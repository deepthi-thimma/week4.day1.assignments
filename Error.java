package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Error {

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
		// TODO Auto-generated method stub

	}

}
