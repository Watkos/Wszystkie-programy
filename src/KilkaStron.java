import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class KilkaStron {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set <String> window = driver.getWindowHandles();
		java.util.Iterator <String> it = window.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		//driver.switchTo().window(parentWindow);
		//WebElement rel = driver.findElement(By.xpath("//h2[text()='Featured Courses']"));
		//WebElement rel2 = driver.findElement(with(By.tagName("a")).below(rel));
		//String name = driver.findElement(with(By.tagName("a")).below(rel2)).getText();
		//String name = driver.findElement(By.xpath("//div/h2/a[1]")).getText();
		String firstText = driver.findElements(By.xpath("//h2/a")).get(0).getText();
		driver.switchTo().window(parentWindow);
		WebElement name = driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']"));
		name.sendKeys(firstText);
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("screen.jpg"));

		

	}

}
