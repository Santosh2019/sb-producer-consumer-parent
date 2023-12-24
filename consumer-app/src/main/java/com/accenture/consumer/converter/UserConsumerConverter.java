package com.accenture.consumer.converter;

import java.util.ArrayList;
import java.util.List;

import com.accenture.consumer.entity.UserConsumerEntity;
import com.accenture.dto.UserDto;

public class UserConsumerConverter {
	
	public static UserConsumerEntity convertDtoToEntity(UserDto userDto) {
		UserConsumerEntity entity = new UserConsumerEntity();
		entity.setFirstName(userDto.getFirstName());
		entity.setLastName(userDto.getLastName());
		entity.setEmail(userDto.getEmail());
		entity.setDepartment(userDto.getDepartment());
		entity.setPhone(userDto.getPhone());
		
		return entity;
	}
	
	public static UserDto convertEntityToDto(UserConsumerEntity userEntity) {
		UserDto dto = new UserDto();
		dto.setFirstName(userEntity.getFirstName());
		dto.setLastName(userEntity.getLastName());
		dto.setEmail(userEntity.getEmail());
		dto.setDepartment(userEntity.getDepartment());
		dto.setPhone(userEntity.getPhone());
		dto.setId(userEntity.getId());
		
		return dto;
	}
	
	public static List<UserConsumerEntity> convertDtoListToEntityList(List<UserDto> userDtoList) {
		List<UserConsumerEntity> entityList = new ArrayList<>();
		
		for(UserDto userDto : userDtoList) {
			UserConsumerEntity entity = new UserConsumerEntity();
			entity.setFirstName(userDto.getFirstName());
			entity.setLastName(userDto.getLastName());
			entity.setEmail(userDto.getEmail());
			entity.setDepartment(userDto.getDepartment());
			entity.setPhone(userDto.getPhone());
			entityList.add(entity);
		}
		
		return entityList;
	}
	
	public static List<UserDto> convertEntityListToDtoList(List<UserConsumerEntity> userEntityList) {
		List<UserDto> dtoList = new ArrayList<>();
		
		for(UserConsumerEntity userEntity : userEntityList) {
			UserDto dto = new UserDto();
			dto.setFirstName(userEntity.getFirstName());
			dto.setLastName(userEntity.getLastName());
			dto.setEmail(userEntity.getEmail());
			dto.setDepartment(userEntity.getDepartment());
			dto.setPhone(userEntity.getPhone());
			dto.setId(userEntity.getId());
			dtoList.add(dto);
		}
		
		return dtoList;
	}

}
