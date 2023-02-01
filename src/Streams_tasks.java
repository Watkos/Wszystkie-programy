import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Streams_tasks {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//thead//tr/th[1]")).click();
		Thread.sleep(2000);
		String a = "ran";
		//List <WebElement> fruits = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//List <String> abc = fruits.stream().map(s->s.getText()).collect(Collectors.toList());
		//List<String> sorted = abc.stream().sorted().collect(Collectors.toList());
		List <String> price;
		do
		{
		List <WebElement> fruits = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List <String> abc = fruits.stream().map(s->s.getText()).collect(Collectors.toList());
		price = fruits.stream().filter(s->s.getText().contains(a)).map(s->GetPrice(s)).collect(Collectors.toList());
		price.forEach(b->System.out.println(b));
		if (price.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		} while(price.size()<1);

}

	private static String GetPrice(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
	}
