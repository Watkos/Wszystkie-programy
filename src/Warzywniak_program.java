import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Warzywniak_program {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] vegetables = {"Tomato","Brocolli","Potato","Carrot"};
		TestProgramVegetables(driver, vegetables);
		//Warzywniak_program p = new Warzywniak_program();
		//p.TestProgramVegetables(driver, vegetables);
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//div[@class='promoWrapper']/input")).sendKeys("Kod Promocyjny hehehue");
		driver.findElement(By.xpath("//div[@class='promoWrapper']/button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='promoWrapper']/span")));
		System.out.println(driver.findElement(By.xpath("//div[@class='promoWrapper']/span")).getText());
		}
	public static void TestProgramVegetables(WebDriver driver, String[] vegetables)
	{
		int i;
		int j = 0;
		List<WebElement> vegeBase = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (i = 0; i < vegeBase.size(); i++)
		{
			String position = vegeBase.get(i).getText();
			String[] splittedPosition = position.split(" ");
			String splittedPositionToCompare = splittedPosition[0];
			List vegetablesList = Arrays.asList(vegetables);
			if (vegetablesList.contains(splittedPositionToCompare))
					{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//Thread.sleep(1000);
				j++;
				if (j == vegetables.length)
				{
					break;
				}
			}
		}
	}

		

	}


