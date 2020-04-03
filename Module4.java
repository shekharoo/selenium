package edurekaAssignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Module4 {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goindigo.in/?linkNav=home_header");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//label[@for='oneWayTrip']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement from = driver.findElement(By.xpath("(//input[@placeholder='From'])[1]"));
		WebElement to = driver.findElement(By.xpath("(//input[@placeholder='To'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(from)).sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		from.sendKeys("Gaya",Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOf(to)).sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		to.sendKeys("Bengaluru",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@data-parsley-indigodate-message='Please select a valid date'])[1]")).click();
		
		driver.findElement(By.xpath("(//a[@class='ui-state-default' and text()='13'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Search Flight']")).click();
		WebElement listFlight = driver.findElement(By.xpath("//div[@class='trips-body ios-scroll ow']"));
		System.out.println(listFlight.getText());
//		List<WebElement> fl = listFlight.findElements(By.className("row trips-row d-flex"));
//		System.out.println(fl);
		
		
	     //System.out.println(listFlight);
//		System.out.println("End..");

	}

}
