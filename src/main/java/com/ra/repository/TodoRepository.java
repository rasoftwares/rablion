package com.ra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ra.domain.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
