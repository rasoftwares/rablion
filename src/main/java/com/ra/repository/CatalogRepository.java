package com.ra.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.ra.domain.Catalog;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog, Long> {

	
	
}