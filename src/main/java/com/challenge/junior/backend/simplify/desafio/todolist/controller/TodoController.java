package com.challenge.junior.backend.simplify.desafio.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.junior.backend.simplify.desafio.todolist.dto.TodoDTO;
import com.challenge.junior.backend.simplify.desafio.todolist.entity.Todo;
import com.challenge.junior.backend.simplify.desafio.todolist.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {
	
	@Autowired
	private TodoService todoService;

	@PostMapping
	public ResponseEntity<List<TodoDTO>> create(@RequestBody @Valid Todo todo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
	}
	
	/*
	List<Todo> create(@RequestBody @Valid Todo todo) {
		return todoService.create(todo);
	}
	*/
	
	@GetMapping
	public ResponseEntity<List<TodoDTO>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(todoService.list());
	}
	
	
	/*
	List<Todo> list() {
		return todoService.list();
	}
	*/
	
	@PutMapping
	public ResponseEntity<List<TodoDTO>> update(@RequestBody Todo todo) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(todoService.update(todo));
	}
	
	/*
	List<Todo> update(  @RequestBody Todo todo) {
		return todoService.update(todo);
	}
	*/
	
	@DeleteMapping("{id}")
	public ResponseEntity<List<TodoDTO>> delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(todoService.delete(id));
	}
	
	/*
	List<Todo> delete(@PathVariable Long id) {
		return todoService.delete(id);
	}
	*/
}
