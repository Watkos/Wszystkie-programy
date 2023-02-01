import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Akcje_nr1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		WebDriverWait w = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.pl/");
		act.moveToElement(driver.findElement(By.id("a-autoid-0-announce"))).click().build().perform();
		act.moveToElement(driver.findElement(By.xpath("//div [@id='nav-tools']/a[@id='nav-link-accountList']"))).build().perform();
		act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		ListaRozwijana(driver, w);
		
	}
	public static void ListaRozwijana(WebDriver driver, WebDriverWait w) { 
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']")));
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
		for (WebElement suggest : suggestions)
		{
			String actualText = suggest.getText();
			if (actualText.equals("hello kitty"));
			{
				suggest.click();
				break;
			}
		}
	}

}
