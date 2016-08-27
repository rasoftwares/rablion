package com.ra.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.ra.domain.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

	
	
}