package com.accenture.producer.process;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.dto.ModelApiResponse;
import com.accenture.dto.UserDto;
import com.accenture.producer.converter.UserProducerConverter;
import com.accenture.producer.entity.UserProducerEntity;
import com.accenture.producer.exception.UserBussinessException;
import com.accenture.producer.service.UserProducerService;

@Component
public class UserProducerProcess {

	@Autowired
	UserProducerService userProducerService;

	public ModelApiResponse createUser(UserDto userDto) {

		Optional<UserProducerEntity> userEntity = userProducerService.getUserByName(userDto.getFirstName(),
				userDto.getLastName());
		ModelApiResponse response = new ModelApiResponse();

		if (userEntity.isPresent()) {
			UserProducerEntity user = userEntity.get();
			response.setMessage(user.getFirstName() + " " + user.getLastName() + " already exists in DB.");

			response.setCode(200);
			return response;
		}

		UserProducerEntity entity = userProducerService
				.saveEntityToDB(UserProducerConverter.convertDtoToEntity(userDto));
		response.setCode(201);
		response.setMessage(
				entity.getFirstName() + " " + entity.getLastName() + " saved in DB with id = " + entity.getId());

		return response;
	}

	public ModelApiResponse createUsersWithListInput(List<UserDto> userDtoList) {
		ModelApiResponse response = new ModelApiResponse();
		List<UserProducerEntity> entityList = userProducerService
				.saveAllUsers(UserProducerConverter.convertDtoListToEntityList(userDtoList));
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
		return UserProducerConverter.convertEntityListToDtoList(userProducerService.getAllUserEntities());
	}

	public UserDto getUserById(String userId) {
		boolean userExists = userProducerService.doesUserExistById(userId);

		if (!userExists) {
			throw new UserBussinessException("User with id = "+userId+" does not exists.");
		}

		return UserProducerConverter.convertEntityToDto(userProducerService.getUserById(userId).get());
	}

	public UserDto updateUser(String userId, UserDto userDto) {
		boolean userExists = userProducerService.doesUserExistById(userId);

		if (!userExists) {
			throw new UserBussinessException("User with id = "+userId+" does not exists.");
		}

		UserProducerEntity userProducerEntity = userProducerService.getUserById(userId).get();
		userProducerEntity.setDepartment(userDto.getDepartment());
		userProducerEntity.setFirstName(userDto.getFirstName());
		userProducerEntity.setLastName(userDto.getLastName());
		userProducerEntity.setPhone(userDto.getPhone());
		userProducerEntity.setEmail(userDto.getEmail());

		return UserProducerConverter.convertEntityToDto(userProducerService.saveEntityToDB(userProducerEntity));

	}

}
