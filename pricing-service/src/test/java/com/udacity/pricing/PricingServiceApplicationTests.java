package com.udacity.pricing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingServiceApplicationTests {
	
	@LocalServerPort
	private int port;

	@Test
	public void getPrice() {
		RestTemplate restTemplate = new RestTemplate();
		String url1 = "http://localhost:" + this.port + "/prices/1";
		ResponseEntity<Price> response1 = restTemplate.getForEntity(url1, Price.class);
		Assertions.assertEquals(response1.getStatusCode(), HttpStatus.OK);
		String url2 = "http://localhost:" + this.port + "/prices";
		ResponseEntity<Price> response2 = restTemplate.getForEntity(url2, Price.class);
		Assertions.assertEquals(response2.getStatusCode(), HttpStatus.OK);
	}

}
