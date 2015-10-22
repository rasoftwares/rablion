package com.ra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ra.domain.Loan;

@Repository
public interface MortgageRepository extends CrudRepository<Loan, Long> {
}
