package hacker.hacker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hacker.hacker.entity.Employee;
import hacker.hacker.service.ServiceDetails;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class EmployeeController {


	@Autowired
	ServiceDetails<Employee> service;
	
	
    @RequestMapping(value = "/hb/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> greetingHibernate(@PathVariable String name) {
    	Optional<List<Employee>> helloList  = null;
    	try{
    		helloList = service.getServices();
    		if ( helloList.isPresent()) {
    			helloList.get().stream().forEach(hello ->  System.out.println(hello));
    		}
    		
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
		//System.out.println(name +" "+lname);
        return ResponseEntity.of(Optional.of(helloList));
    }
    
}
