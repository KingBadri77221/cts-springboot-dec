package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { App.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ProductControllerWebInetgrationTest {

	@Test
	public void listAll() throws JsonProcessingException, IOException {
		String uri = "http://localhost:8080/api/v1/products";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());

		// assertThat(responseJson.toString(), equalTo("[]"));

	}

	// @Test
	// public void get() {
	// String uri = "http://localhost:8080/api/v1/products/123";
	// RestTemplate restTemplate = new RestTemplate();
	// ResponseEntity<String> response = restTemplate.getForEntity(uri,
	// String.class);
	// assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
	//
	// }

}
