package com.ra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ra.domain.Appuser;

@Repository
public interface UserRepository extends CrudRepository<Appuser, Long> {
}
