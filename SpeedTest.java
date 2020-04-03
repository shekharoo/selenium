package edurekaAssignments;

import java.util.concurrent.TimeUnit;

/******************Code by Zeeshan**************/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpeedTest {
		static
		{
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.speedtest.net");
		driver.findElement(By.xpath("//span[text()='Go']")).click();
		// explicit wait
		
		new WebDriverWait(driver,90).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='result-container-speed result-container-speed-active']/div[1]/div[2]/div/div[2]/span")));
		WebElement downloadresult = driver.findElement(By.xpath(
				"//div[@class='result-container-speed result-container-speed-active']/div[1]/div[2]/div/div[2]/span"));
		String speed = downloadresult.getText();
		System.out.println("download speed :==="+speed);

	}

}
