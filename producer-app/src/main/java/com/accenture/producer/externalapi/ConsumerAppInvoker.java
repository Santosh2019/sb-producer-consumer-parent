package com.accenture.producer.externalapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.accenture.dto.ModelApiResponse;
import com.accenture.producer.entity.UserProducerEntity;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class ConsumerAppInvoker {

	private static final String PRODUCER_SERVICE_CB = "producerServiceCircuitBreaker";
	
	@Value("${user-consumer.url}")
	private String CONSUMER_RESOURCE_URL;

	@Autowired
	private RestTemplate restTemplate;
	
	@CircuitBreaker(name = PRODUCER_SERVICE_CB, fallbackMethod = "serviceFallback")
	public ResponseEntity<ModelApiResponse> callConsumerService(HttpEntity<UserProducerEntity> request) {
		
		ResponseEntity<ModelApiResponse> response = restTemplate.exchange(CONSUMER_RESOURCE_URL, HttpMethod.POST, request,
				ModelApiResponse.class);
		return response;
	}

	public ResponseEntity<ModelApiResponse> serviceFallback(Exception e) {
		ModelApiResponse fallbackResponse = new ModelApiResponse();
		fallbackResponse.setMessage("Fallback method - Consumer service not available. Please try after some time.");
		fallbackResponse.setCode(500);
		
		return new ResponseEntity<>(fallbackResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
