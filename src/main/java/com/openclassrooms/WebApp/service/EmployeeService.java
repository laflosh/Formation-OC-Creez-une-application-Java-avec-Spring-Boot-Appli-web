package com.openclassrooms.WebApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.WebApp.model.Employee;
import com.openclassrooms.WebApp.repository.EmployeeProxy;

import lombok.Data;

@Data
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeProxy employeeProxy;
	
	public Employee getEmployee(final int id) {
		return employeeProxy.getEmployee(id);
	}
	
	public Iterable<Employee> getEmployees() {
		return employeeProxy.getEmployees();
	}
	
	public void deleteEmployee(final int id) {
		employeeProxy.deleteEmployee(id);
	}
	
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee;
		
		// Functional rule : Last name must be capitalized.
		employee.setLastName(employee.getLastName().toUpperCase());

		if(employee.getId() == null) {
			// If id is null, then it is a new employee.
			savedEmployee = employeeProxy.createEmployee(employee);
		} else {
			savedEmployee = employeeProxy.updateEmployee(employee);
		}
		
		return savedEmployee;
	}

}