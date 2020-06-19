package stepdefination;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TodoStepDefination {

	RequestSpecification requestSpecification;

	WebDriver driver;

	private String taskName;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"/Users/tanwar/work/Content/BDD-Cucumber/Part4/chromedriver/chromedriver");

		driver = new ChromeDriver();
	}

	@Given("I have a task {string}")
	public void i_have_a_task(String taskName) {
		requestSpecification = RestAssured.given();
		this.taskName = taskName;
		driver.get("http://192.168.1.104:4200/");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}

	@When("I hit enter on the task field")
	public void i_hit_enter_on_the_task_field() {
		WebElement taskNameElement = driver.findElement(By.id("taskName"));
		taskNameElement.sendKeys(taskName + Keys.ENTER);
	}

	@Then("The task should be added successfully")
	public void the_task_should_be_added_successfully() {
		// validate service response:
		String[] expectedResponse = new String[1];
		expectedResponse[0] = taskName;
		requestSpecification.get("http://192.168.1.104:8080/tasks").then().body("taskName",
				Matchers.hasItems(expectedResponse));

		// DOM validation:
		WebElement taskList = driver.findElement(By.id("taskList"));
		WebElement taskItem = taskList.findElement(By.id(taskName));
		Assert.assertEquals(taskName + "12", taskItem.findElement(By.id("taskLabel_" + taskName)).getText());
	}

	@After
	public void teardown(Scenario scenario) throws InterruptedException {
		if (scenario.isFailed()) {
			final byte[] screenshot = 
					((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
	}

}
