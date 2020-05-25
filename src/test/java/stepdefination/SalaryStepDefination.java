package stepdefination;

import org.junit.Assert;

import com.tanwar.service.EmployeeService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalaryStepDefination {
	
	private EmployeeService employeeService;
	private Integer grossSalary;
	private Double taxPercent;
	private Double takeHomeSalary;
	
	public SalaryStepDefination () {
		System.out.println("SalaryStepDefination constructor");
		employeeService = new EmployeeService();
	}
	
	@Given("I have salary {int} of an employee")
	public void i_have_salary_of_an_employee(Integer grossSalary) {
	    this.grossSalary = grossSalary;
	}

	@Given("I have the tax percent {double} %")
	public void i_have_the_tax_percent(Double taxPercent) {
	    this.taxPercent = taxPercent;
	}

	@When("I calculate the salary after tax")
	public void i_calculate_the_salary_after_tax() {
	    this.takeHomeSalary = this.employeeService.calculateSalary(grossSalary, taxPercent);
	}

	@Then("It should return {double}")
	public void it_should_return(Double expectedTakeHomeSalary) {
	    Assert.assertEquals(expectedTakeHomeSalary, takeHomeSalary);
	}

	

}
