package ru.husnim.spring_learning;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/user")
	public User getUserName(@RequestParam(defaultValue = "Vlad") String username,
			@RequestParam(defaultValue = "vlad@email.com") String email,
			@RequestParam(defaultValue = "0000") String password) {
		return new User(counter.incrementAndGet(), username, email, password, String.format(template, username));
	}

}
