package com.ra.repository;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.ra.domain.Currency;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

	public static Logger logger = LogManager.getLogger(CurrencyRepository.class);

	
}