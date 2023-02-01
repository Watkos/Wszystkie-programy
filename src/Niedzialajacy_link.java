import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Niedzialajacy_link {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		SoftAssert a = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//String url = " ";
		//String url = driver.findElement(By.xpath("//a[@href='https://www.soapui.org/']")).getAttribute("href");
		
		//conn.setRequestMethod("HEAD");
		//conn.connect();
		//int respCode = conn.getResponseCode();
		//System.out.println(respCode);
		WebElement bottomBar = driver.findElement(By.id("gf-BIG"));
		List <WebElement> links = bottomBar.findElements(By.tagName("a"));
		for (WebElement link : links)
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responceCode = conn.getResponseCode();
			a.assertTrue(responceCode<400, "link which doesn't work: " + link.getText());
			System.out.println(responceCode);
			//if (responceCode>=400)
			//{
				//System.out.println("link which doesn't work: " + link.getText());
				//Assert.assertTrue(false);
			//}
		}
		a.assertAll();

	}

}
