package edurekaAssignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SppedTestDemo {
	WebDriver driver;
	WebDriverWait wait;
	WebElement spVw;
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	@Test
	public void testSpeed()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 90);
		//FluentWait<WebDriver> wait1 = new FluentWait<WebDriver>(driver);
		driver.get("https://www.speedtest.net/");
		driver.findElement(By.xpath("//span[text()='Go']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Go']"))).click();
//		//WebElement spVw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='result-data-large number result-data-value download-speed']/../../div[2]")));
//		//Thread.sleep(35000);
	   }
		//@Test(dependsOnMethods= {"testSpeed"}, alwaysRun = true)
		@Test(dependsOnMethods= {"testSpeed"})
		public void measureSpeed()
		{
			WebElement speed = driver.findElement(By.xpath("//span[@class='result-data-large number result-data-value download-speed']"));
			String sp = speed.getText();
			if(wait.until(ExpectedConditions.textToBePresentInElement(speed, "")))
				//if(wait.until(ExpectedConditions.textToBePresentInElement(speed, "")))
			{
			spVw = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='result-data-large number result-data-value download-speed']/../../div[2]")));
			 //wait.until(ExpectedConditions.textToBePresentInElement(speed, ""));
		//WebElement spVw =	driver.findElement(By.xpath("//span[@class='result-data-large number result-data-value download-speed']/../../div[2]"));
//		wait.until(ExpectedConditions.visibilityOf(spVw));
		//wait.until(ExpectedConditions.presenceOfElementLocated(spVw));
			}
		String speed1 = spVw.getText();
		System.out.println("Speed is: "+ speed1);
		System.out.println("Shekhar Anand");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='result-data-large number result-data-value download-speed']/../../div[2]")));
//		WebElement view = driver.findElement(By.xpath("https://learning.edureka.co/classroom/assignment/535/5765/97452?tab=CourseContent"));
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true)", view);
		}

	}

