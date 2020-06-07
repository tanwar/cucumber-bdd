package stepdefination;

import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class OrderStepDefination {

	String startDate;
	String endDate;
	Response response;
	ValidatableResponse validatableResponse;

	RequestSpecification requestSpecification;

	@Given("I have a start date {string} and end date {string}")
	public void i_have_a_start_date_and_end_date(String startDate, String endDate) {
//		this.startDate = startDate;
//		this.endDate = endDate;
		requestSpecification = RestAssured.given().param("startDate", startDate).param("endDate", endDate);
	}

	@When("I search for the orders in our system")
	public void i_search_for_the_orders_in_our_system() {
		// response =
		// RestAssured.get("/orders?startDate="+startDate+"&endDate="+endDate);

		response = requestSpecification.when().get("/orders");
	}

	@Then("Search should result in success with code {int}")
	public void search_should_result_in_success_with_code(Integer responseCode) {
		validatableResponse = response.then();
		validatableResponse.statusCode(responseCode);
	}

	@Then("Response should return a list of order numbers")
	public void response_should_return_a_list_of_order_numbers(io.cucumber.datatable.DataTable dataTable) {
		List<Integer> orderNumbers = dataTable.asList().stream().map(element -> Integer.parseInt(element))
				.collect(Collectors.toList());
		validatableResponse.body("orderNumber", Matchers.hasItems(orderNumbers.toArray()));
	}

	@Then("ordernumber should be {int}")
	public void ordernumber_should_be(Integer orderNumber) {
		validatableResponse.body("findAll{it.price > 8000}.orderNumber", Matchers.hasItems(orderNumber));
	}
	
	@Then("response should be under {long} milis")
	public void response_should_be_under_milis(Long time) {
		validatableResponse.time(Matchers.lessThan(time));
	}
	
}
