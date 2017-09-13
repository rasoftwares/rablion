package com.ra.repository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ra.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public static Logger logger = LogManager.getLogger(UserRepository.class);


}


