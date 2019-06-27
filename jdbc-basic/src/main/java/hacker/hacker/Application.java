package hacker.hacker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
public class Application  implements CommandLineRunner{
	

    public static void main(String[] args) {
    	//System.out.println(SpringVersion.getVersion());
        SpringApplication.run(Application.class, args);
        
    }
	@Override
	public void run(String... args) throws Exception {

		
	}
}
