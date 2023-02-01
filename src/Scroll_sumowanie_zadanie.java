import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll_sumowanie_zadanie {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=200");
		List <WebElement> columns = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"));
		List <WebElement> rows = driver.findElements(By.xpath("//table[@id='product'][@name='courses']/tbody/tr"));
		System.out.println("Number of colums: "+columns.size());
		System.out.println("Number of rows "+rows.size());
		String secLine = rows.get(2).getText();
		System.out.println("Second line of table: "+secLine);

	}

}
