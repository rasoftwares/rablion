package com.ra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ra.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
