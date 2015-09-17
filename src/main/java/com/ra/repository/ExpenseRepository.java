package com.ra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ra.domain.Expenses;

@Repository
public interface ExpenseRepository extends CrudRepository<Expenses,Long> {
	
}
