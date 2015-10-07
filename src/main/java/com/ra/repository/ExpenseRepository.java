package com.ra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ra.domain.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

	
	//@Query("SELECT date_trunc(cast(?2 as text), date) AS date, sum(amount) as amount FROM #{#entityName}  WHERE username = cast(?1 as text) GROUP BY date_trunc(cast(?2 as text), date) Order By date")
	//List<Object> amountSpent(String username, String period);
}
