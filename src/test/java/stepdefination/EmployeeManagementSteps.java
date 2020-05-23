package stepdefination;

import org.junit.Assert;

import com.tanwar.domain.Employee;
import com.tanwar.service.EmployeeService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeManagementSteps {
	
	private EmployeeService employeeService = new EmployeeService();
	Employee employee = null;
	
	
	@Given("I have an employee with name {string} and salry {int}")
	public void givenCondition(String name, Integer salary) {
	    employee = new Employee (name, salary);
	}
	
	@Given("I have an employee with name {string}")
	public void i_have_an_employee_with_name(String name) {
		employee = new Employee(name, 0);
	}

	@Given("salry {int}")
	public void salry(Integer salary) {
		employee.setSalary(salary);
	}
	
	@Given("salry of {double}")
	public void salry(Double salary) {
		employee.setSalary(salary);
	}
	
	

	@When("I add this employee to company systems")
	public void when() {
		// add the employee
		employeeService.addEmployee(employee);
		
	}

	@Then("New employee with name {string} should be added successfully")
	public void verify(String name) {
		boolean expected = employeeService.isEmployeeExists(name);
		Assert.assertTrue(expected);
	}

}
