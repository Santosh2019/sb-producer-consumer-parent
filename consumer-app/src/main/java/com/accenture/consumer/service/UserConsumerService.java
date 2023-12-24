package com.accenture.consumer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.consumer.entity.UserConsumerEntity;
import com.accenture.consumer.repository.UserConsumerRepository;
import com.accenture.dto.UserDto;

@Service
public class UserConsumerService {

	@Autowired
	private UserConsumerRepository userProducerRepository;


	public Optional<UserConsumerEntity> getUserByName(String firstName, String lastName) {
		return userProducerRepository.findByName(firstName, lastName);
	}
	
	public UserConsumerEntity saveEntityToDB(UserConsumerEntity request) {
		return userProducerRepository.save(request);
	}

	public Optional<UserConsumerEntity> getUserEntityById(Long userId) {
		return userProducerRepository.findById(userId);
	}
	
	public List<UserConsumerEntity> getAllUserEntities() {
		return userProducerRepository.findAll();
	}

	public UserConsumerEntity updateUser(String id, UserConsumerEntity request) {
		return userProducerRepository.save(request);

	}

	public List<UserConsumerEntity> saveAllUsers(List<UserConsumerEntity> userEntityList) {
		return userProducerRepository.saveAll(userEntityList);
	}
	
	public void deleteUserById(String userId) {
		userProducerRepository.deleteById(Long.valueOf(userId));
	}
	
	public boolean doesUserExistById(String userId) {
		return userProducerRepository.existsById(Long.valueOf(userId));
	}

	public Optional<UserConsumerEntity> getUserById(String userId) {
		return userProducerRepository.findById(Long.valueOf(userId));
	}

}
