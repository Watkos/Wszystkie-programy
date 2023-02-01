import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Searching_filter {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("che");
		Thread.sleep(1000);
		List <WebElement> fruits = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List <String> fruitNames = fruits.stream().map(s->s.getText()).collect(Collectors.toList());
		int a = fruitNames.size();
		long b = fruitNames.stream().map(s->s.toLowerCase()).filter(s->s.contains("che")).count();
		if (a == b)
			{
				System.out.println("correct");
			}
			else
			{
				System.out.println("dupa");
			}

	}

}
