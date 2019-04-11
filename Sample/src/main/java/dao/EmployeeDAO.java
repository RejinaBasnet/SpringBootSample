package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Employee;
import repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	// Save an employee
	
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	// Search employee
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	// Get employeeById
	public Employee findOne(Long empid) {
		Optional<Employee> employee = employeeRepository.findById(empid);
		if(employee.isPresent())
		{
			return employee.get();
		}
		else {
			return null;
		}
	}
	
	// Delete employee
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}

}
