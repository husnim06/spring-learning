package ru.husnim.spring_learning;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hello_world")
	public Map<String, Object> greeting() {
		return Collections.singletonMap("message", "Hello, World");
	}

}
