package com.accenture.consumer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.consumer.entity.UserConsumerEntity;

@Repository
public interface UserConsumerRepository extends JpaRepository<UserConsumerEntity, Long>{

	@Query("SELECT uce FROM UserConsumerEntity uce WHERE firstName =?1 AND lastName =?2")
	Optional<UserConsumerEntity> findByName(String firstName, String lastName);

}
