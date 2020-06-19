package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
	
	//@Test
	public void shouldSearchGoogle() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/tanwar/work/Content/BDD-Cucumber/Part4/chromedriver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.1.104:4200/");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		WebElement taskName = driver.findElement(By.id("taskName"));
		
		taskName.sendKeys("New task" + Keys.ENTER);
		Thread.sleep(10000);
		driver.quit();
		
		
	}

}
