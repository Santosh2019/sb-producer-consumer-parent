package com.accenture.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.accenture.controller.UserProducerApi;
import com.accenture.dto.ModelApiResponse;
import com.accenture.dto.UserDto;
import com.accenture.producer.process.UserProducerProcess;

@Controller
public class ProducerController implements UserProducerApi {
	
	@Autowired
	private UserProducerProcess userProducerProcess;

	@Override
	public ResponseEntity<ModelApiResponse> createUser(UserDto userDto) {
		ModelApiResponse response = userProducerProcess.createUser(userDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ModelApiResponse> createUsersWithListInput(List<UserDto> userDtoList) {
		ModelApiResponse response = userProducerProcess.createUsersWithListInput(userDtoList);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ModelApiResponse> deleteUserById(String userId) {
		ModelApiResponse response = userProducerProcess.deleteUserById(userId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> response = userProducerProcess.getAllUsers();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserDto> getUserById(String userId) {
		UserDto response = userProducerProcess.getUserById(userId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserDto> updateUserById(String userId, UserDto userDto) {
		UserDto response = userProducerProcess.updateUser(userId, userDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
