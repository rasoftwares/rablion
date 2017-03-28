package com.ra.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.ra.domain.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

	
	
}