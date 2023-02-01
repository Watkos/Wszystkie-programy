import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class Liczba_linkow {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\User\\Desktop\\Programowanie\\edgedriver_win64\\msedgedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new EdgeDriver();
		//WebDriver driver = new ChromeDriver();
		//Actions a = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//List <WebElement> webPageLinks = driver.findElements(By.tagName("a"));
		//System.out.println(webPageLinks.size());
		WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		WebElement columnfooterDriver = driver.findElement(By.xpath("//a[text()='Discount Coupons']/parent::h3/parent::li/parent::ul"));
		List <WebElement> allLinksColumn = columnfooterDriver.findElements(By.tagName("a"));
		String controlsHold = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int i=0; i<allLinksColumn.size(); i++)
		{
			columnfooterDriver.findElements(By.tagName("a")).get(i).sendKeys(controlsHold);
			//a.moveToElement(allLinksColumn.get(i)).keyDown(Keys.CONTROL).click().build().perform();
		}
		Set <String> browsers = driver.getWindowHandles();
		java.util.Iterator<String> it = browsers.iterator();
		while (it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
	}

}
