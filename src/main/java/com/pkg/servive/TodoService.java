package com.pkg.servive;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.entity.Todo;
import com.pkg.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	public List<Todo> getAllTodos(){
		List<Todo> todos= new ArrayList<>();
		todoRepository.findAll().forEach(todos::add);
		return todos;
	}
	
	public Optional<Todo> getTodo(long id) {
		return todoRepository.findById(id);
	}
	public void saveTodo(Todo todo) {
		todoRepository.save(todo);
	}
	public void updateTodo(long id, Todo updatedTodo) {
		if(todoRepository.existsById(id)) {
			updatedTodo.setId(id);
			todoRepository.save(updatedTodo);
		} else {
		    System.out.print("Todo is not found with id = "+id);
		}
	}
	public void deleteTodo(long id) {
		todoRepository.deleteById(id);
	}
}
