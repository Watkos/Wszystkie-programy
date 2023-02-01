import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadanie2_formularz {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//form/div/input[@name='name']")).sendKeys("Mat");
		driver.findElement(By.xpath("//form/div/input[@name='email']")).sendKeys("Mat@abc.com");
		driver.findElement(By.xpath("//div/input[@type='checkbox']")).click();
		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(0);
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.xpath("//div/input[@type='date']")).sendKeys("12342022");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector("[class='alert alert-success alert-dismissible']")).getText());
		
	}

}
