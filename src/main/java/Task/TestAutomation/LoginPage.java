package Task.TestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
	}
	
	By uName = By.xpath("//input[@type='email']");
	
	By pwd = By.xpath("//input[@type='password']");
	
	public void launchBrowser() {
		
		driver.get("https:www.gmail.com");

		driver.manage().window().maximize();
	}
	
	public void enterUsername() {
		driver.findElement(uName).sendKeys("testemail010001@gmail.com" + Keys.ENTER);;
	}

	//Method to enter password
	public void enterPassword() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pwd));
		driver.findElement(pwd).sendKeys("Sathish@0107" + Keys.ENTER);
		Thread.sleep(5000);
	}
	
	public void verifyPage() {
		String text = driver.getTitle();

		if (text.contains("testemail010001@gmail.com")) {

			System.out.println("Values are equal");

		} else {
			System.out.println("Values are not equal");
		}

		
	}

}
