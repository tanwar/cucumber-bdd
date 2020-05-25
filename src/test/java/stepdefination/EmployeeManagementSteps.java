package stepdefination;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;

import com.tanwar.domain.Employee;
import com.tanwar.service.EmployeeService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeManagementSteps {
	
	private EmployeeService employeeService = new EmployeeService();
	Employee employee = null;
	
	public EmployeeManagementSteps() {
		System.out.println("EmployeeManagementSteps constructor");
	}
	
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
	
	@Given("I have an employee")
	public void i_have_an_employee(io.cucumber.datatable.DataTable dataTable) {
		List<String> employeeList = dataTable.asList();
		employeeList.stream().forEach(emp -> {
			System.out.println(emp);
		});
		employee = new Employee(employeeList.get(0), Integer.parseInt(employeeList.get(1)));
	}
	
	@Given("I have a list of employees")
	public void employeeList(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> employeesList = dataTable.asLists();
		
		employeesList.stream().forEach(employee -> {
			employee.stream().forEach(empData -> {
				System.out.println(empData);
			});
		});
		
	}
	
	@Given("I have a list of employees in a key value pair")
	public void i_have_a_list_of_employees_in_a_key_value_pair(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> employees = dataTable.asMaps();
		employees.stream().forEach(employeeMap -> {
			for(Entry<String, String> emp : employeeMap.entrySet()) {
				System.out.println("key: " + emp.getKey() + ", value: " + emp.getValue());
			}
		});
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
