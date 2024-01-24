package com.pkg.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.entity.Todo;
import com.pkg.servive.TodoService;

@RestController
public class Controller {
	@Autowired
	private TodoService todoService; 

	@GetMapping("/todos")
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}
	
	@GetMapping("/todos/{id}")
	public Optional<Todo> getTodo(@PathVariable("id") long id){
		return todoService.getTodo(id);
	}
	
	@DeleteMapping("/todos/{id}")
	public void deleteTodo(@PathVariable long id){
		todoService.deleteTodo(id);
	}
	
	@PostMapping("/todos")
	public void saveTodo(@RequestBody Todo todo)
	{
		todoService.saveTodo(todo);
	}
	
	@PutMapping("/todos/{id}")
	public void updateTodo(@PathVariable long id,@RequestBody Todo updatedTodo)
	{
		todoService.updateTodo(id, updatedTodo);
	}

}
