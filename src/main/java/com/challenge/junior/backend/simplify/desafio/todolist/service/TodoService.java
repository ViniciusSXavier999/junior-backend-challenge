package com.challenge.junior.backend.simplify.desafio.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.challenge.junior.backend.simplify.desafio.todolist.entity.Todo;
import com.challenge.junior.backend.simplify.desafio.todolist.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	public List<Todo> create(Todo todo) {
		todoRepository.save(todo);
		return list();
	}
	
	public List<Todo> list() {
		//Definindo a ordenação de prioridade primeiro
	Sort sort =	Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
		return todoRepository.findAll(sort);
	}
	
	public List<Todo> update(Todo todo) {
		todoRepository.save(todo);
		return list();
	}
	
	public List<Todo> delete(Long id) {
		todoRepository.deleteById(id);
		return list();
	}

}
