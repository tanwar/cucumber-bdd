package com.tanwar.service;

import java.util.ArrayList;
import java.util.List;

import com.tanwar.domain.Employee;

public class EmployeeService {

	private List<Employee> employees;

	public EmployeeService() {
		super();
		employees = new ArrayList<>();
	}

	public int addEmployee(Employee employee) {
		int nextEmployeeId = employees.size() + 1;

		employee.setId(nextEmployeeId);
		employees.add(employee);
		return nextEmployeeId;
	}

	public boolean isEmployeeExists(String name) {
		boolean isExists = false;
		for (Employee employee : employees) {
			if (employee.getName().equalsIgnoreCase(name)) {
				isExists = true;
				break;
			}
		}

		return isExists;
	}
	
	public Double calculateSalary(Integer grossSalary, Double taxPercent) {
		return grossSalary - (grossSalary * (taxPercent/100));
	}

}
