import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kalendarz {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		String date = "April";
		String actDate = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']/span")).getText();
		while (!actDate.equals(date))
		{
			driver.findElement(By.xpath("//div[@class='flatpickr-month']/span[@class='flatpickr-next-month']")).click();
			actDate = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']/span")).getText();
			System.out.println(actDate);

			//if (actDate.equals(date))
			//{
				//System.out.println("Success");
				//break;
			//}
			//else 
			//{
			//driver.findElement(By.xpath("//div[@class='flatpickr-month']/span[@class='flatpickr-next-month']")).click();
			Thread.sleep(1000);
			}
		System.out.println("Success");
		}
		}


	


