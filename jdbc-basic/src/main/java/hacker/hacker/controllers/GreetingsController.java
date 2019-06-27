package hacker.hacker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	
	@Autowired
	JdbcTemplate jdbctemp;
	
	
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
    	
		SqlRowSet row =  jdbctemp.queryForRowSet("select * from hello where name ='"+name+"'");
		
		String lname ="";
		
		while(row.next()) {
			String fname = row.getString(1);
			if(fname != null && fname.equalsIgnoreCase(name)) {
				lname = " "+row.getString(2);
			}
		}
		
		//System.out.println(name +" "+lname);
        return "Hello " + name +lname +"!";
    }
    
    

}
