package com.rest.sample.RestSample1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@PostMapping("/save/employee")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDao.save(emp);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return employeeDao.findAll();
	}
	
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getOne(@PathVariable(value="id") Long id) {
		
		Employee emp=employeeDao.findOne(id);
			if(emp==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return ResponseEntity.ok().body(emp);
	}
	
		@PutMapping("/employee/update/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id")Long id,@RequestBody Employee empDetails)
		{
			Employee emp=employeeDao.findOne(id);
			if(emp==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			emp.setName(empDetails.getName());
			emp.setExpertise(empDetails.getExpertise());
			emp.setDesignation(empDetails.getDesignation());
			
			Employee updatedEmployee=employeeDao.save(emp);
			
			return ResponseEntity.ok().body(updatedEmployee);
	}
			
		@DeleteMapping("/employee/delete/{id}")
		public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long id){
			Employee emp=employeeDao.findOne(id);
			if(emp==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			employeeDao.delete(emp);
			return ResponseEntity.ok().body(emp);
		}
}


 