import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Warzywniak {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Programowanie\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//div[@class='product'][1]/div[@class='product-action']/button   <--- PRZYCISK
		////div[@class='product'][1]/h4  <--- NAZWA PRODUKTU  
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		int i = 0;
		String searched_product = "Cucumber - 1 Kg";
		String searched_product2 = "Beans - 1 Kg";
		while (true)
		{
			i++;
			String path = "//div[@class='product']["+i+"]/h4";
			String product_name = driver.findElement(By.xpath(path)).getText();
			if (product_name.equals(searched_product))
			{
				break;
			}
		}
		String path1 = "//div[@class='product'][";
		String path2 = "]/div[@class='product-action']/button";
		int searched_num = i;
		String full_path = path1 + searched_num + path2;
		//String cucumber_path = "//div[@class='product']["+i+"]/div[@class='product-action']/button";
		//String a1 = "//div[@class='product'][";
		//String a2 = "]/div[@class='product-action']/button";
		//String a3 = a1 + searched_number;
		driver.findElement(By.xpath(full_path)).click();
		int j = 0;
		while (true)
		{
			j++;
			String path5 = "//div[@class='product']["+j+"]/h4";
			String product2_name = driver.findElement(By.xpath(path5)).getText();
			if (product2_name.equals(searched_product2))
			{
				break;
		}
		}
		
		String path12 = "//div[@class='product'][";
		String path22 = "]/div[@class='product-action']/button";
		int searched_num2 = j;
		String full_path2 = path12 + searched_num2 + path22;
		driver.findElement(By.xpath(full_path2)).click();
}
}
