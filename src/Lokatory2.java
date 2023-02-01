import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lokatory2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String name = "Matełko";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String password = getPassword(driver);
		driver.findElement(By.id("inputUsername")).sendKeys("Trutututu");
		driver.findElement(By.xpath("//form/input[@type='password']")).sendKeys("pamparampam");
		driver.findElement(By.xpath("//button [@type='submit']")).click();
		driver.findElement(By.xpath("//form/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//form/input[1]")).sendKeys("Roman");
		driver.findElement(By.xpath("//form/input[2]")).sendKeys("Roman@ras.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		//Thread.sleep(1000);
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.xpath("//form/input[@type='password']")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button [@type='submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//p")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//p")).getText(), "You are successfully logged in.");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//form/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		String passText = driver.findElement(By.className("infoMsg")).getText();
		String[] passArray = passText.split("'");
		String Pass = passArray[1].split("'") [0];
		System.out.println(Pass);
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		Thread.sleep(1000);
		return Pass;
	}

}
