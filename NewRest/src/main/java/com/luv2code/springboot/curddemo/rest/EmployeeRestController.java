package com.luv2code.springboot.curddemo.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.curddemo.entity.Employee;
import com.luv2code.springboot.curddemo.service.EmployeeService;


@RestController
@RequestMapping
public class EmployeeRestController {
	
	
	private EmployeeService empser;
	
	@Autowired
	public EmployeeRestController(EmployeeService ser) {
		empser = ser;
	}
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return empser.findall();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) throws Exception {
		
		Employee emp = empser.findById(employeeId);
		if(emp == null )
		{
			throw new Exception("Erro " + employeeId);
			
		}
		return emp;
		
	}
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		empser.save(theEmployee);
		
		return theEmployee;
		
	}
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee theempl) {
		empser.save(theempl);
		return theempl;
		
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String dele(@PathVariable int employeeId) throws Exception {
		Employee emp = empser.findById(employeeId);
		if(emp == null )
		{
			throw new Exception("Erro " + employeeId);
			
			
		}
		empser.deleateById(employeeId);
		return "Deleated succsufauly " + employeeId;
		
	}
	@GetMapping("/hellow")
	public String  heelloWorl() {
		return "hello World " ;
	}
	
	
	
	

}
