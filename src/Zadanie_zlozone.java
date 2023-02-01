import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import dev.failsafe.internal.util.Assert;

public class Zadanie_zlozone {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String opt2 = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[@for='benz']")).getText();
		driver.findElement(By.id("checkBox"+opt2)).click();
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(opt2);
		driver.findElement(By.id("name")).sendKeys(opt2);
		driver.findElement(By.id("alertbtn")).click();
		String[] alertCompList = driver.switchTo().alert().getText().split(",");
		String[] alertComp = (alertCompList[0].split(" "));
		String compVar = alertComp[1].trim();
		if (compVar.equalsIgnoreCase(opt2))
		{
			System.out.println("Success, grabbed variable is: "+opt2);
		}
		else
		{
			System.out.println("Error");
		}
		driver.switchTo().alert().accept();
	}
}
