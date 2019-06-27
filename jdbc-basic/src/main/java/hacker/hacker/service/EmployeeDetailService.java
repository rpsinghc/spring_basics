package hacker.hacker.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import hacker.hacker.entity.Employee;

@Component
public class EmployeeDetailService implements ServiceDetails<Employee>{
	@Autowired
	JpaRepository<Employee, Integer> jpaRepository;
	
	@Transactional
	public Optional<List<Employee>> getServices(){
		List<Employee> helloList;
    	
		helloList =  jpaRepository.findAll();
		
		return Optional.of(helloList);
	}
}
