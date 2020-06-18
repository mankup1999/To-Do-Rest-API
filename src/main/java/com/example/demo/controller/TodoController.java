package com.example.demo.controller;

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

import com.example.demo.model.Todo;
import com.example.demo.repo.TodoRepo;

@RestController
public class TodoController {

	@Autowired
	TodoRepo repo;

	@GetMapping("todos")
	public List<Todo> allTodos() {
		return repo.findAll();
	}

	@GetMapping("todos/{id}")
	public Optional<Todo> getTodoByBid(@PathVariable int id) {
		return repo.findById(id);
	}

	@PostMapping("todos")
	public Todo createTodo(@RequestBody Todo todo) {
//		System.out.println(todo.getId());
		repo.save(todo);
		return todo;
	}

	@PutMapping("todos/{id}")
	public Todo updateTodo(@RequestBody Todo todo, @PathVariable int id) {
		repo.deleteById(id);
		repo.save(todo);
		return todo;
	}

	@DeleteMapping("todos/{id}")
	public void updateTodo(@PathVariable int id) {
		repo.deleteById(id);
	}

}
