import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popupy {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String your_name = "Matełko";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(your_name);
		driver.findElement(By.id("alertbtn")).click();
		// System.out.println(driver.switchTo().alert().getText());
		String alert_text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String[] full_text = alert_text.split(" ");
		System.out.println(full_text[1].trim());
		List<Character> Nazwa_mat = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			char letter = full_text[1].charAt(i);
			Nazwa_mat.add(letter);

		}
		System.out.println(Nazwa_mat);
		StringBuilder sb = new StringBuilder();
		for (Character ch : Nazwa_mat) {
			sb.append(ch);
		}
		String Nazwa_polaczona = sb.toString();
		System.out.println(Nazwa_polaczona);

	}

}
