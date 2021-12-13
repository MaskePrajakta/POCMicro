package com.neosoftmail.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.neosoftmail.model.Employee;
import com.neosoftmail.serviceImplementation.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmployeeServiceImpl empServiceImpl;
	
	@Autowired
	RestTemplate restTemplate;
	
	 @PostMapping("/employees")
	    public  Employee  createEmployee(@RequestBody Employee employee) {
	        return empServiceImpl.createEmpDetails(employee);
	    }
	 
		/*
		 * @GetMapping("/getEmp") public List<Employee> getEmployee() { String
		 * url1="http://localhost:8086/getAdd"; Employee[] emp =
		 * restTemplate.getForObject(url1+"/emp", Employee[].class); return
		 * Arrays.asList(emp); }
		 */

	 @GetMapping("/getEmp")
	 public List<Employee> getEmployee() {
		 Employee e = (Employee) empServiceImpl.getAllEmployee();
		String url1="http://localhost:8086/getAdd";
		List list = restTemplate.getForObject(url1, List.class, e);
		return list;
	 }
	 
}
