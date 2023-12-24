package com.accenture.producer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.dto.UserDto;
import com.accenture.producer.entity.UserProducerEntity;
import com.accenture.producer.repository.UserProducerRepository;

@Service
public class UserProducerService {

	@Autowired
	private UserProducerRepository userProducerRepository;


	public Optional<UserProducerEntity> getUserByName(String firstName, String lastName) {
		return userProducerRepository.findByName(firstName, lastName);
	}
	
	public UserProducerEntity saveEntityToDB(UserProducerEntity request) {
		return userProducerRepository.save(request);
	}

	public Optional<UserProducerEntity> getUserEntityById(Long userId) {
		return userProducerRepository.findById(userId);
	}
	
	public List<UserProducerEntity> getAllUserEntities() {
		return userProducerRepository.findAll();
	}

	public UserProducerEntity updateUser(String id, UserProducerEntity request) {
		return userProducerRepository.save(request);

	}

	public List<UserProducerEntity> saveAllUsers(List<UserProducerEntity> userEntityList) {
		return userProducerRepository.saveAll(userEntityList);
	}
	
	public void deleteUserById(String userId) {
		userProducerRepository.deleteById(Long.valueOf(userId));
	}
	
	public boolean doesUserExistById(String userId) {
		return userProducerRepository.existsById(Long.valueOf(userId));
	}

	public Optional<UserProducerEntity> getUserById(String userId) {
		return userProducerRepository.findById(Long.valueOf(userId));
	}

}
