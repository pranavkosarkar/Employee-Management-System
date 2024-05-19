package com.example.StudentCrudOperations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee addEmployee(Employee emp);
	public Employee getEmployeeById(int id);
	public void deleteEmployeeById(int id);

	
}
