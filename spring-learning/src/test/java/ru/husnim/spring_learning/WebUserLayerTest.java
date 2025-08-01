package ru.husnim.spring_learning;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class WebUserLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void shouldReturnDefaultUser() throws Exception {
		this.mockMvc.perform(get("/user")) // Запрос без параметров
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("Vlad")) // Проверка имени
				.andExpect(jsonPath("$.email").value("vlad@email.com")) // Проверка email
				.andExpect(jsonPath("$.password").value("0000"))
				.andExpect(jsonPath("$.message").value("Hello, Vlad!"))
				.andDo(document("user/default")); // Проверка пароля
	}

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void shouldReturnCustomUser() throws Exception {
		this.mockMvc.perform(get("/user")
				.param("username", "Alex") // Передаем имя
				.param("email", "alex@email.com") // Передаем email
				.param("password", "1234")) // Передаем пароль
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("Alex")) // Проверка имени
				.andExpect(jsonPath("$.email").value("alex@email.com")) // Проверка email
				.andExpect(jsonPath("$.password").value("1234"))
				.andExpect(jsonPath("$.message").value("Hello, Alex!"))
				.andDo(document("user/custom")); // Проверка пароля
	}
}
