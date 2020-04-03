package edurekaAssignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Module3 {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.edureka.co/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Search box inspection
		//Using id
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='search-inp-overlay-new']"));
		//System.out.println(searchBox.isEnabled());
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys("Selenium");
				
		//driver.findElement(By.xpath("//input[@id='search-inp-overlay-new']")).sendKeys("Selenium");
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('search-inp-overlay-new').value='Selenium'",searchBox);

	}

}
