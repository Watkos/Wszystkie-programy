import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie_okna {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//div[@class='example']/a")).click();
		Set<String> windows = driver.getWindowHandles();
		java.util.Iterator<String> it = windows.iterator();
		String parentPage = it.next();
		String childPage = it.next();
		driver.switchTo().window(childPage);
		System.out.println(driver.findElement(By.xpath("//h3")).getText());
		driver.switchTo().window(parentPage);
		System.out.println(driver.findElement(By.xpath("//h3")).getText());
		
		

	}

}
