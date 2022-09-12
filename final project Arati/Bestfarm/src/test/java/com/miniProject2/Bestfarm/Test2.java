package com.miniProject2.Bestfarm;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Test2 {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void adding_New_Farmer_Succesfully() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/farmers/addnewfarmer?fname=arati1001&age=24&gender=Female",
				String.class)).contains("farmer added successfully");
	}
}