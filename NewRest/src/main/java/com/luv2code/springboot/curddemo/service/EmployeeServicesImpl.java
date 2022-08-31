package com.luv2code.springboot.curddemo.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.curddemo.dao.EmployeeRepository;
import com.luv2code.springboot.curddemo.entity.Employee;
@Service
public class EmployeeServicesImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	
	
    @Autowired
	public EmployeeServicesImpl(EmployeeRepository theemployeeRepository) {
		
		employeeRepository = theemployeeRepository;
	}

	@Override
	public List<Employee> findall() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theemp = null;
		if(result.isPresent()) {
			theemp = result.get();
		}
		else {
			throw new RuntimeException("do not find Id + " + theId);
		}
		return theemp;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);
		
	}

	@Override
	public void deleateById(int theId) {
		// TODO Auto-generated method stub
		 employeeRepository.deleteById(theId);
	}

	

}
