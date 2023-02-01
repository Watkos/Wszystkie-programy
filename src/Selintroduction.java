import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Selintroduction {
	
	public static void main(String[] args) {
	//Invoking Browser (przywołanie strony)
	//Chrome - ChromeDriver -> Methods
		System.out.println("hello world");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.monsmare.pl/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
}
}