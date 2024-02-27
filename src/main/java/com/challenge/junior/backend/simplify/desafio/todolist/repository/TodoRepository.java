package com.challenge.junior.backend.simplify.desafio.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.junior.backend.simplify.desafio.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>  {

}
