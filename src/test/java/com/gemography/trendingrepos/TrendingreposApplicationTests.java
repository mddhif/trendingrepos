package com.gemography.trendingrepos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.*;
import java.net.InetAddress;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class TrendingreposApplicationTests {

	@LocalServerPort
	private int serverPort;


	@Autowired
	private TestRestTemplate testRestTemplate; 

    
    
	@Test
	public void methodShouldNotReturnEmpty() throws Exception {
 
      String response = testRestTemplate.getForObject("http://"+InetAddress.getLocalHost().getHostAddress()+
      	":"+serverPort+"/trendingrepos", String.class);

     assertThat(response).isNotEmpty();

	}

}
