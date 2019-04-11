package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dao.EmployeeDAO;
import model.Employee;

@RestController
@RequestMapping("/example")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;

	// SaveEmployee
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}

	// Get all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeDAO.findAll();
	}

	// Get employee by Id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empid) {
		Employee emp = employeeDAO.findOne(empid);

		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}

	// Update employee

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid,
			@Valid @RequestBody Employee empDetails) {
		Employee emp = employeeDAO.findOne(empid);

		if (emp == null) {
			return ResponseEntity.notFound().build();
		}

		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());

		Employee updatedEmployee = employeeDAO.save(emp);

		return ResponseEntity.ok().body(updatedEmployee);

	}

	@DeleteMapping("employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long empid) {
		Employee emp = employeeDAO.findOne(empid);

		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		
		employeeDAO.delete(emp);
		
		return ResponseEntity.ok().build();
	}

}
