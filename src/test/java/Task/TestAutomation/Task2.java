package Task.TestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		ebayPage ebay = new ebayPage(driver);
		
		ebay.launchBrowser();
		
		ebay.searchItem();
		
		ebay.selectItem();
		
		ebay.switchTab();
		
		driver.quit();

	}

}
