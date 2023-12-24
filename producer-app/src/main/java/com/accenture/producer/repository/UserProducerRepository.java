package com.accenture.producer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.producer.entity.UserProducerEntity;

@Repository
public interface UserProducerRepository extends JpaRepository<UserProducerEntity, Long>{

	@Query("SELECT upe FROM UserProducerEntity upe WHERE firstName =?1 AND lastName =?2")
	Optional<UserProducerEntity> findByName(String firstName, String lastName);
	
	@Query("SELECT upe FROM UserProducerEntity upe WHERE isPublished = ?1")
	List<UserProducerEntity> findUserNotPublished(boolean isPublished);

}
