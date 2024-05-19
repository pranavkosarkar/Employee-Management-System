package com.example.StudentCrudOperations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		
		return repo.findAll() ;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
Optional <Employee> empy=repo.findById(id);
Employee emp=null;
if(empy.isPresent())
	emp=empy.get();
else
	throw new RuntimeException("Employee not present");
		return emp;
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	

	
	}
	
	


