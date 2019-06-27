package hacker.hacker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hacker.hacker.entity.Employee;

public interface EmployeeRepository extends  JpaRepository<Employee, Integer> {
	
	

}
