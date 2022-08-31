package com.luv2code.springboot.curddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.luv2code.springboot.curddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
