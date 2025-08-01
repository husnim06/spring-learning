package ru.husnim.spring_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBlogApiApplication {

//	private static final Logger log = LoggerFactory.getLogger(SpringBlogApiApplication.class);

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(SpringBlogApiApplication.class, args);
	}
	
	/*
	 * @Bean public CommandLineRunner demo(UserRepository repository) { return
	 * (args) -> { // save a few customers
	 * 
	 * repository.save(new UserTable("Vlad", "vlad@gmail.com", "1234"));
	 * repository.save(new UserTable("Mashka", "maha@email.com", "0000"));
	 * repository.save(new UserTable("Pyshok", "pyhich@email.com", "miay"));
	 * 
	 * // fetch all customers log.info("Customers found with findAll():");
	 * log.info("-------------------------------");
	 * repository.findAll().forEach(customer -> { log.info(customer.toString()); });
	 * log.info("");
	 * 
	 * // fetch an individual customer by ID UserTable customer =
	 * repository.findById(1L); log.info("Customer found with findById(1L):");
	 * log.info("--------------------------------"); log.info(customer.toString());
	 * log.info("");
	 * 
	 * // fetch customers by last name
	 * log.info("Customer found with findByLastName('Mashka'):");
	 * log.info("--------------------------------------------");
	 * repository.findByUsername("Mashka").forEach(bauer -> {
	 * log.info(bauer.toString()); }); log.info(""); }; }
	 */

}