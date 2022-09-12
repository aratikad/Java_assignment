package com.miniProject2.Bestfarm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class Test1 {

	@LocalServerPort
	private int port;
	
	@Autowired
	MockMvc mockMvc; // MockMvc simulates a browser.
@Test
	public void adding_New_Farmer_Succesfully() throws Exception {

		mockMvc.perform(get("/api/farmers/addnewfarmer?fname=arati1001&age=24&gender=Female"))
		//check the response was returned successfully
		.andExpect(status().isOk())
		//check the response has content we expect
		.andExpect(content().string(containsString("farmer added successfully")));
	} 


	@Test
	public void adding_New_Farmer_Failed_GenderError() throws Exception {

				//Gender same as word Male,Female

		mockMvc.perform(get("/api/farmers/addnewfarmer?fname=arati1001&age=29&gender=1Female"))
		//check the response was returned successfully
		.andExpect(status().isOk())
		//check the response has content we expect
		.andExpect(content().string(not(containsString("farmer added successfully"))));
		
	}


	@Test
	public void adding_New_Farmer_Failed_AgeError() throws Exception {

				//age should be in between 18 and 125

		mockMvc.perform(get("/api/farmers/addnewfarmer?fname=arati1001&age=160&gender=Female"))
		//check the response was returned successfully
		.andExpect(status().isOk())
		//check the response has content we expect
		.andExpect(content().string(not(containsString("farmer added successfully"))));
		
	}

	@Test
	public void adding_New_Farmer_Failed_NameError() throws Exception {

			//name  less than 8 charachters

		mockMvc.perform(get("/api/farmers/addnewfarmer?fname=arati&age=29&gender=Female"))
		//check the response was returned successfully
		.andExpect(status().isOk())
		//check the response has content we expect
		.andExpect(content().string(not(containsString("farmer added successfully"))));
		
	}


}










	/* 

	@Test
	public void adding_New_Farmer_Failed_NameError() throws Exception {

		mockMvc.perform(get("/api/farmers/addnewfarmer?fname=arati&age=29&gender=Female"))
		//check the response was returned successfully
		.andExpect(status().isOk())
		//check the response has content we expect
		.andExpect(content().string(containsString("failed to add farmer")));
	}
	
	@Test
	public void adding_New_Farmer_Failed_AgeError() throws Exception {

		mockMvc.perform(get("/api/farmers/addnewfarmer?fname=arati1001&age=129&gender=Female"))
		//check the response was returned successfully
		.andExpect(status().isOk())
		//check the response has content we expect
		.andExpect(content().string(containsString("failed to add farmer")));
	}
	
	
//	@Test
//	public void checkIndexPage_isNotReturning_BadRequest() throws Exception {
//
//		mockMvc.perform(get("/"))
//		.andDo(print()) // prints detailed info about requests and responses
//		.andExpect(status().isBadRequest());
//	}
*/
