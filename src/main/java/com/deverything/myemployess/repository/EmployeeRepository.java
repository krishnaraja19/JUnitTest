package com.deverything.myemployess.repository;

import org.springframework.stereotype.Repository;

import com.deverything.myemployess.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
}
