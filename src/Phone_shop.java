import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Phone_shop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		String[] phones = {"iphone", "Nokia"};
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//a[@href='/angularpractice/shop']")).click();
		TestingTask(driver, phones);
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success']")));
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		

		

	}
public static void TestingTask(WebDriver driver, String[] phones)
{
	List<WebElement> phoneList = driver.findElements(By.xpath("//app-card[@class='col-lg-3 col-md-6 mb-3']"));
	int j =0;
	for (int i=0; i<phoneList.size(); i++)
	{
		String phoneText = phoneList.get(i).getText();
		String[] trimmedPhones = phoneText.split(" ");
		String comparisonPhone = trimmedPhones[0];
		List selectedPhones = Arrays.asList(phones);
		if (selectedPhones.contains(comparisonPhone))
		{
			driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
			j++;
			if (j == phones.length)
			{
				break;
			}
		}
		
		
	}
}
}
