
package com.ra.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.function.Consumer;



import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ra.domain.Todo;
import com.ra.repository.TodoRepository;

@RestController
public class Todocontroller extends BaseController {
	String name = "todoController";

	public Todocontroller() {
		this.setName(name);
	}
	
    @Inject
    TodoRepository todoRepository;
    
 @RequestMapping(value = "/todo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo create(@RequestBody Todo todo) {
    	System.out.println("Todo from UI :" + todo + ":");
    	return todoRepository.save(todo);
    }
    
    
    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.delete(id);
        System.out.println("todo item " + id  + "deleted successfully");
    }
    
    
    @RequestMapping(value = "/todo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Todo> findTodo() {
        final List<Todo> resultList = new ArrayList<>();
        final Iterable<Todo> all = todoRepository.findAll();
        
        Iterator<Todo> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Todo user = (Todo) all_I.next();
			resultList.add(user);	
		}      
        return resultList;
    }
}

