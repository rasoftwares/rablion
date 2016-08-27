package com.ra.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ra.domain.Article;
import com.ra.repository.ArticleRepository;

@RestController
public class ArticleController extends BaseController {
	String name = "ArticleController";

	public ArticleController() {
		this.setName(name);
	}
	
     @Inject
    ArticleRepository articleRepository;
      
     @RequestMapping(value = "/article", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public Article create(@RequestBody Article article) {
     	System.out.println("Article from UI :" + article + ":");
     	return articleRepository.save(article);
     }
     @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
     public void deleteArticle(@PathVariable Long id) {
         articleRepository.delete(id);
         System.out.println("article item " + id  + "deleted successfully");
     }
     
    
    @RequestMapping(value = "/article", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Article> findArticle () {
        final List<Article> resultList = new ArrayList<>();
        final Iterable<Article> all = articleRepository.findAll();
        
        Iterator<Article> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Article currency = (Article) all_I.next();
			resultList.add(currency);
		}      
        return resultList;
    }
}
    
  
