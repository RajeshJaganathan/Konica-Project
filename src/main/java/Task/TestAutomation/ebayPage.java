package Task.TestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.*;

public class ebayPage {

	WebDriver driver;

	public ebayPage(WebDriver driver) {
		this.driver = driver;
	}

	By searchBox = By.xpath("//input[@placeholder='Search for anything']");

	By guitarItem = By.xpath(
			"//h3[contains(text(), 'Mitchell TD100 3/4 Size Surf Green Electric Guitar Starter Pack w/ Fender Strap')]");

	By guitarPrice = By.xpath("//span[text()='US $109.00']//ancestor::div[@class='mainPrice']");

	public void launchBrowser() {

		driver.get("https:www.ebay.com");
		driver.manage().window().maximize();
	}

	public void searchItem() {
		driver.findElement(searchBox).sendKeys("Electric Guitar" + Keys.ENTER);
		;
	}

	public void selectItem() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(guitarItem));
		driver.findElement(guitarItem).click();
	}

	public void switchTab() {

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		// Here we will check if child window has other child windows and will fetch the
		// heading of the child window
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				String text = driver.findElement(guitarPrice).getText();

				System.out.println(text);
			}

		}

	}
}