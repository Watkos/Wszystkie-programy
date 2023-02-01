import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_lokatory {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://sso.teachable.com/secure/9521/identity/login/password");
		driver.findElement(By.id("email")).sendKeys("Trututututu@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Przykladowe haslo");
		driver.findElement(By.name("commit")).click();
		System.out.println(driver.findElement(By.className("auth-flash-error")).getText());
		//driver.findElement(By.linkText("Forgot Password")).click();
		driver.findElement(By.cssSelector("a[class='bodySmall form-footer']")).click();
	}

}
