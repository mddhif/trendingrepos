package com.gemography.trendingrepos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import java.net.InetAddress;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
class TrendingreposApplicationTests {

	@LocalServerPort
	private int serverPort;


	@Autowired
	private TestRestTemplate testRestTemplate; 

    
    @Autowired
    private MockMvc mockMvc;
    
    
	@Test
	public void methodShouldNotReturnEmpty() throws Exception {
 
      /*String response = testRestTemplate.getForObject("http://"+InetAddress.getLocalHost().getHostAddress()+
      	":"+serverPort+"/trendingrepos", String.class);

     assertThat(response).isNotEmpty();
       */

     this.mockMvc.perform(get("/trendingrepos"))
                .andDo(print())
                .andExpect(status().isOk())
                
				
                //check if numberOfRepos key exists
                .andExpect(jsonPath("$.[0]", hasKey("numberOfRepos")));
	}

}
