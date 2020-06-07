package stepdefination;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class OrderShippingStepDefination {
	
	Response response;
	ValidatableResponse validatableResponse;

	RequestSpecification requestSpecification;
	
	
	@Given("I have the order number {long}")
	public void i_have_the_order_number(Long orderNumber) {
		requestSpecification = RestAssured.given()
										.pathParam("order-number", orderNumber);
	}

	@Given("it is present in the system")
	public void it_is_present_in_the_system() {
		response = requestSpecification.get("/orders/{order-number}");
	}

	@When("I call shipping address service")
	public void i_call_shipping_address_service() {
		Integer orderNumber = response.then().extract().path("orderNumber");
		
		response = RestAssured.given()
						.pathParam("order-number", orderNumber)
						.headers("header-name", "header-value")
				   .when()
				   		.get("/orders/{order-number}/address");
		
	}

	@Then("the shipping address should be {string}")
	public void the_shipping_address_should_be(String address) {
		response.then().body("address", Matchers.equalTo(address));
		response.then().log().body();
	}

}
