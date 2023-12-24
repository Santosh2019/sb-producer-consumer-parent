package com.accenture.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.accenture.consumer.process.UserConsumerProcess;
import com.accenture.controller.UserConsumerApi;
import com.accenture.controller.UserProducerApi;
import com.accenture.dto.ModelApiResponse;
import com.accenture.dto.UserDto;

@Controller
public class ConsumerController implements UserConsumerApi {
	
	@Autowired
	private UserConsumerProcess userProducerProcess;
	

	@Override
	public ResponseEntity<ModelApiResponse> consumeUser(UserDto userDto) {
		ModelApiResponse response = userProducerProcess.createUser(userDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}


	@Override
	public ResponseEntity<ModelApiResponse> deleteConsumedUserById(String userId) {
		ModelApiResponse response = userProducerProcess.deleteUserById(userId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<UserDto>> getAllConsumedUsers() {
		List<UserDto> response = userProducerProcess.getAllUsers();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserDto> getConsumedUserById(String userId) {
		UserDto response = userProducerProcess.getUserById(userId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserDto> updateConsumedUserById(String userId, UserDto userDto) {
		UserDto response = userProducerProcess.updateUser(userId, userDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
