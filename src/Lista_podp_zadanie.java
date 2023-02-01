import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lista_podp_zadanie {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.findElement(By.id("autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("Pol");
		List <WebElement> suggests = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		for (int i=0; i<suggests.size(); i++)
		{
			String expectedElement = suggests.get(i).getText();
			if (expectedElement.equals("Poland"))
			{
				suggests.get(i).click();
				break;
			}
			
		}
		

	}

}
