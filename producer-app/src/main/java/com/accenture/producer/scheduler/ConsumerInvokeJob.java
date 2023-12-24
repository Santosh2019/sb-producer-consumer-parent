package com.accenture.producer.scheduler;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.accenture.dto.ModelApiResponse;
import com.accenture.producer.entity.UserProducerEntity;
import com.accenture.producer.externalapi.ConsumerAppInvoker;
import com.accenture.producer.repository.UserProducerRepository;

@Component
@EnableScheduling
public class ConsumerInvokeJob {
	
	@Autowired
	private UserProducerRepository repository;
	
	@Autowired
	private ConsumerAppInvoker consumerInvoker;
	
	private List<UserProducerEntity> entitiesNotPublished;
    private static Queue<UserProducerEntity> queueOfNotPublished = new LinkedList<>();
	
	private boolean fetchRecords = true;

	@Scheduled(fixedRate = 5000)
	public void publishJob() {
		if(fetchRecords) {
			entitiesNotPublished = repository.findUserNotPublished(false);
			for(UserProducerEntity entity : entitiesNotPublished) {
				queueOfNotPublished.add(entity);
			}
			
			fetchRecords = false;
		}
		publishUserDataToConsumerApi();
	}
	
	public void publishUserDataToConsumerApi() {
		UserProducerEntity notPublishedEntity = queueOfNotPublished.poll();
		
		if(notPublishedEntity == null) {
			fetchRecords = true;
			System.out.println("Nonpublished queue empty reseting fetchRecords flag");
			return;
		}
		
		HttpEntity<UserProducerEntity> request = new HttpEntity<>(notPublishedEntity);
		
		ResponseEntity<ModelApiResponse> response = consumerInvoker.callConsumerService(request);
		
		if(response.getBody().getCode() == 201) {
			System.out.println("Published >>  "+request.getBody().getFirstName()+" to consumer service at " + new Date() +" STATUS = "+response.getBody().getCode());
			notPublishedEntity.setPublished(true);
			repository.save(notPublishedEntity);
		} else {
			System.out.println("Response : "+response.getBody().getMessage());
		}
		
	}
}
