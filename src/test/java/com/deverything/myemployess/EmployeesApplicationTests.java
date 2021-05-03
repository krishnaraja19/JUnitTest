package com.deverything.myemployess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.deverything.myemployess.entity.Employee;
import com.deverything.myemployess.repository.EmployeeRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EmployeesApplicationTests {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Test
	@Order(1)
	public void testCreateEmployee() {
		Employee emp = new Employee();
		emp.setId(1L);
		emp.setFirstName("Krishna Raja");
		emp.setLastName("Alagar Samy");
		emp.setEmailId("krishnaraja19@gmail.com");
		emp = empRepo.save(emp);
		assertNotNull(empRepo.findById(1L).get());
	}
	
	@Test
	@Order(2)
	public void testFindAllEmployees () {
		List<Employee> list = empRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testfindEmployeeById () {
		Employee emp = empRepo.findById(1L).get();
		assertEquals("krishnaraja19@gmail.com", emp.getEmailId());
	}
	
	@Test
	@Order(4)
	public void testUpdateEmployee () {
		Employee emp = empRepo.findById(1L).get();
		emp.setEmailId("krishnaraja2021@gmail.com");
		empRepo.save(emp);
		assertNotEquals("krishnaraja19@gmail.com", empRepo.findById(1L).get().getEmailId());
	}
	@Test
	@Order(5)
	public void testDelete () {
		empRepo.deleteById(1L);
		assertThat(empRepo.existsById(1L)).isFalse();
	}

}
