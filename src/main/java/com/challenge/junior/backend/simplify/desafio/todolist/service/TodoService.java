package com.challenge.junior.backend.simplify.desafio.todolist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.challenge.junior.backend.simplify.desafio.todolist.dto.TodoDTO;
import com.challenge.junior.backend.simplify.desafio.todolist.entity.Todo;
import com.challenge.junior.backend.simplify.desafio.todolist.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	public List<TodoDTO> create(Todo todo) {
		todoRepository.save(todo);
		return list();
	}

	// convertendo DTO para entity
	public TodoDTO toDto(Todo entity) {
		TodoDTO dto = new TodoDTO();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setDescricao(entity.getDescricao());
		dto.setRealizado(entity.isRealizado());
		dto.setPrioridade(entity.getPrioridade());
		return dto;

	}

	public List<TodoDTO> list() {
		// Definindo a ordenação de prioridade primeiro
		Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
		// convertendo dto em entity
		return todoRepository.findAll(sort).stream().map(entity -> toDto(entity))
				.collect(Collectors.toList());
	}

	public List<TodoDTO> update(Todo todo) {
		todoRepository.save(todo);
		return list();
	}

	public List<TodoDTO> delete(Long id) {
		todoRepository.deleteById(id);
		return list();
	}

}
