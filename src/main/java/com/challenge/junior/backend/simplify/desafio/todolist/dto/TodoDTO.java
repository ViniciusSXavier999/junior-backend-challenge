package com.challenge.junior.backend.simplify.desafio.todolist.dto;

import com.challenge.junior.backend.simplify.desafio.todolist.entity.Todo;

import jakarta.validation.constraints.NotBlank;

public class TodoDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private boolean realizado;
	private int prioridade;
	
	public TodoDTO() {
		
	}

	public TodoDTO(Long id, String nome, String descricao, boolean realizado, int prioridade) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.realizado = realizado;
		this.prioridade = prioridade;
	}
	
	
	
	// construtor que recebe a entidade para facilitar a conversão de entidade para DTO
	public TodoDTO(Todo todo) {
		// Copiando os dados de um todo para um DTO DTO
		id = todo.getId();
		nome = todo.getNome();
		descricao = todo.getDescricao();
		realizado =	todo.isRealizado();
		prioridade = todo.getPrioridade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	
	
}
