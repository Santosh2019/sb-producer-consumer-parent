package com.accenture.producer.converter;

import java.util.ArrayList;
import java.util.List;

import com.accenture.dto.UserDto;
import com.accenture.producer.entity.UserProducerEntity;

public class UserProducerConverter {
	
	public static UserProducerEntity convertDtoToEntity(UserDto userDto) {
		UserProducerEntity entity = new UserProducerEntity();
		entity.setFirstName(userDto.getFirstName());
		entity.setLastName(userDto.getLastName());
		entity.setEmail(userDto.getEmail());
		entity.setDepartment(userDto.getDepartment());
		entity.setPhone(userDto.getPhone());
		
		return entity;
	}
	
	public static UserDto convertEntityToDto(UserProducerEntity userEntity) {
		UserDto dto = new UserDto();
		dto.setFirstName(userEntity.getFirstName());
		dto.setLastName(userEntity.getLastName());
		dto.setEmail(userEntity.getEmail());
		dto.setDepartment(userEntity.getDepartment());
		dto.setPhone(userEntity.getPhone());
		dto.setId(userEntity.getId());
		
		return dto;
	}
	
	public static List<UserProducerEntity> convertDtoListToEntityList(List<UserDto> userDtoList) {
		List<UserProducerEntity> entityList = new ArrayList<>();
		
		for(UserDto userDto : userDtoList) {
			UserProducerEntity entity = new UserProducerEntity();
			entity.setFirstName(userDto.getFirstName());
			entity.setLastName(userDto.getLastName());
			entity.setEmail(userDto.getEmail());
			entity.setDepartment(userDto.getDepartment());
			entity.setPhone(userDto.getPhone());
			entityList.add(entity);
		}
		
		return entityList;
	}
	
	public static List<UserDto> convertEntityListToDtoList(List<UserProducerEntity> userEntityList) {
		List<UserDto> dtoList = new ArrayList<>();
		
		for(UserProducerEntity userEntity : userEntityList) {
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
