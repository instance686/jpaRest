package com.rest.sample.RestSample1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRespository;
	
	
	/*---save an employee-----*/
	public Employee save(Employee emp) {
		
		return employeeRespository.save(emp);
		
	}
	
	/*------search all employee------*/
	public List<Employee> findAll(){
		return employeeRespository.findAll();
	}
	
	/*------search single employee------*/
	
	
	public Employee findOne(Long empid) {
		
		List<Long> ids=new ArrayList<Long>();
		ids.add(empid);
			List<Employee> empList=employeeRespository.findAll(ids);
			return empList.get(0);
	}
	/*------update an employee--------*/
	
	
	/*-------delete an employee--------*/
	
	public void delete(Employee emp) {
		employeeRespository.delete(emp);
	}
}
