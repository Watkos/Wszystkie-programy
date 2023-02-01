import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MonsM {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait w = new WebDriverWait (driver, Duration.ofSeconds(5));

		//sideTable(driver, a);
		browser(driver,a, js);
	}
	public static void closingCookiesBar (WebDriver driver)
	{
		//This method opens website and clicks "Ok" button on Cookies bar
		driver.get("https://allegro.pl/");
		driver.findElement(By.xpath("//button[@class='mgn2_14 mp0t_0a m9qz_yp mp7g_oh mse2_40 mqu1_40 mtsp_ib mli8_k4 mp4t_0 munh_0 m911_5r mefy_5r mnyp_5r mdwl_5r msbw_2 mldj_2 mtag_2 mm2b_2 mqvr_2 msa3_z4 mqen_m6 meqh_en m0qj_5r mh36_16 mvrt_16 mg9e_0 mj7a_0 mjir_sv m2ha_2 m8qd_qh mjt1_n2 b1vf8 mgmw_9u msts_enp mrmn_qo mrhf_u8 m31c_kb m0ux_fp bnpxh mjru_k4 _158e2_4-oWM m3h2_0 m3h2_16_s mryx_24 mryx_0_s mryx_24_x m7er_0k']")).click();
	}
	public static void sideTable(WebDriver driver, Actions a) 
	{
		closingCookiesBar(driver);
		//This method checks if all browsers in side bar are opening correctly
		WebElement sideTable = driver.findElement(By.xpath("//div[@data-prototype-id='allegro.navigation.layers']"));
		List<WebElement> allLinks = sideTable.findElements(By.xpath("//div[@data-prototype-id='allegro.navigation.layers']/div/div"));
		//allBrowsersTitles array list "allBrowsersTitles" is needed to save all opened browsers titles inside it
		ArrayList<String> allBrowsersTitles = new ArrayList<String>();
		//Loop which opens all links in browsers other tabs
		for (WebElement link : allLinks)
		{
			a.moveToElement(link).keyDown(Keys.CONTROL).click().build().perform();
		}
		//This code part gets all the browsers titles into previously defined array list "allBrowsersTitles"
		Set <String> browsers = driver.getWindowHandles();
		java.util.Iterator <String> it = browsers.iterator();
		while (it.hasNext())
		{
			driver.switchTo().window(it.next());
			allBrowsersTitles.add(driver.getTitle());
			driver.close();
		}
		//Comparing number of links in side bar with number of opened links - if they're the same it means all links were opened correctly
		int allBrowsersSize = allBrowsersTitles.size();
		if (allBrowsersSize == allLinks.size())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	public static void browser (WebDriver driver, Actions a, JavascriptExecutor js) throws InterruptedException, IOException
	{
		closingCookiesBar(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Clicking on "szukaj wielu" button and inputing text in searching bar
		driver.findElement(By.xpath("//a[@data-role='multisearch-button']")).click();
		driver.findElement(By.id("input0")).sendKeys("telefon");
		Thread.sleep(1000);
		//Clicking again in the input bar to make sure the suggestions bar will appear
		a.moveToElement(driver.findElement(By.id("input0"))).click().build().perform();
		//Gathering all the loaded suggestions to a list
		List <WebElement> suggestionsFirst = driver.findElements(By.xpath("//div[@data-role='multisearch-field-0']/div/div"));
		//Loop which looks for the searched phrase
		for (int i = 0; i<suggestionsFirst.size(); i++)
		{
			String suggest1 = suggestionsFirst.get(i).getText();
			//Checking if the position from suggest bar contains "uchwyt". If it contains the phrase than program will choose this one, if not it will be checking the next suggestion.
			if (suggest1.contains("uchwyt"))
			{
				suggestionsFirst.get(i).click();
				Assert.assertTrue(true);
				break;
			}
		}
		//Here's the same thing with the next searching bar - inputting searched phrase, gathering all suggestions in list and than looking for the needed one.
		driver.findElement(By.id("input1")).sendKeys("ładowarka");
		List<WebElement> suggestionsSecond = driver.findElements(By.xpath("//div[@data-role='multisearch-field-1']/div/div"));
		for (int j = 0; j<suggestionsSecond.size(); j++)
		{
			String suggest2 = suggestionsSecond.get(j).getText();
			if (suggest2.contains("samochodowa"))
			{
				suggestionsSecond.get(j).click();
				Assert.assertTrue(true);
				break;
			}
		}
		driver.findElement(By.xpath("//div[@class='mp4t_16']/button[@type='submit']")).click();
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,500)");
		//Taking a screenshot of the final result
		File szukajWielu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(szukajWielu, new File ("D:\\Programowanie_screenshoty\\Screenshot.png"));
		driver.close();
	}
}
