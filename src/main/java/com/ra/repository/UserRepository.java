package com.ra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ra.domain.AppUser;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Long> {
}
