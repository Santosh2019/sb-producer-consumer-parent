package com.accenture.consumer.process;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.consumer.converter.UserConsumerConverter;
import com.accenture.consumer.entity.UserConsumerEntity;
import com.accenture.consumer.exception.UserBussinessException;
import com.accenture.consumer.service.UserConsumerService;
import com.accenture.dto.ModelApiResponse;
import com.accenture.dto.UserDto;

@Component
public class UserConsumerProcess {

	@Autowired
	UserConsumerService userProducerService;

	public ModelApiResponse createUser(UserDto userDto) {

		Optional<UserConsumerEntity> userEntity = userProducerService.getUserByName(userDto.getFirstName(),
				userDto.getLastName());
		ModelApiResponse response = new ModelApiResponse();

		if (userEntity.isPresent()) {
			UserConsumerEntity user = userEntity.get();
			response.setMessage(user.getFirstName() + " " + user.getLastName() + " already exists in DB.");

			response.setCode(200);
			return response;
		}

		UserConsumerEntity entity = userProducerService
				.saveEntityToDB(UserConsumerConverter.convertDtoToEntity(userDto));
		response.setCode(201);
		response.setMessage(
				entity.getFirstName() + " " + entity.getLastName() + " saved in DB with id = " + entity.getId());

		return response;
	}

	public ModelApiResponse createUsersWithListInput(List<UserDto> userDtoList) {
		ModelApiResponse response = new ModelApiResponse();
		List<UserConsumerEntity> entityList = userProducerService
				.saveAllUsers(UserConsumerConverter.convertDtoListToEntityList(userDtoList));
		response.setMessage("Saved " + entityList.size() + " records.");
		response.setCode(201);

		return response;
	}

	public ModelApiResponse deleteUserById(String userId) {
		ModelApiResponse response = new ModelApiResponse();
		boolean userExists = userProducerService.doesUserExistById(userId);
		if (userExists) {
			userProducerService.deleteUserById(userId);
			response.setMessage("User with id = " + userId + " deleted successfully");
			response.setCode(200);
			return response;
		}

		response.setMessage("User with id = " + userId + " does not exist");
		response.setCode(501);
		return response;
	}

	public List<UserDto> getAllUsers() {
		return UserConsumerConverter.convertEntityListToDtoList(userProducerService.getAllUserEntities());
	}

	public UserDto getUserById(String userId) {
		boolean userExists = userProducerService.doesUserExistById(userId);

		if (!userExists) {
			throw new UserBussinessException("User with id = "+userId+" does not exists.");
		}

		return UserConsumerConverter.convertEntityToDto(userProducerService.getUserById(userId).get());
	}

	public UserDto updateUser(String userId, UserDto userDto) {
		boolean userExists = userProducerService.doesUserExistById(userId);

		if (!userExists) {
			throw new UserBussinessException("User with id = "+userId+" does not exists.");
		}

		UserConsumerEntity userProducerEntity = userProducerService.getUserById(userId).get();
		userProducerEntity.setDepartment(userDto.getDepartment());
		userProducerEntity.setFirstName(userDto.getFirstName());
		userProducerEntity.setLastName(userDto.getLastName());
		userProducerEntity.setPhone(userDto.getPhone());
		userProducerEntity.setEmail(userDto.getEmail());

		return UserConsumerConverter.convertEntityToDto(userProducerService.saveEntityToDB(userProducerEntity));

	}

}
