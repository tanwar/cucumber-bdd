package testcaserunner;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;

public class SimpleTest {

	@Test
	public void test() {
		//RestAssured.get("/orders?startDate=2020-06-06&endDate=2020-06-09").then().body("orderNumber", Matchers.hasItems(115,116));
	}

}
