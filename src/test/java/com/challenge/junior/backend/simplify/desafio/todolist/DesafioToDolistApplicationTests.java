package com.challenge.junior.backend.simplify.desafio.todolist;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.challenge.junior.backend.simplify.desafio.todolist.entity.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DesafioToDolistApplicationTests {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("todo 1", "desc todo 1", false, 1);
		webTestClient
		.post()
		// url que configuramos no controller
		.uri("/todos")
		
		// Corpo da requisição que eu acabei de configurar
		.bodyValue(todo)
		
		// Fazemos a requisição
		.exchange()
		
		// Após realizar a requisição a gente espera um status, nesse caso utilizamos o OK
		.expectStatus().isOk()
		.expectBody()
		
		// Aqui estamos dizendo que esperamos que a resposta seja um json com varias propriedades
		/*O $ quer dizer que estamos se referindo a propriedade raiz, ou seja nesse caso uma lista
		 * de todos e aqui tambem estamos verificando se é um array*/
		.jsonPath("$").isArray()
		
		// Verificando o tamanho do array
		.jsonPath("$.length()").isEqualTo(1)
		
		/*Verificando cada propriedade, verificando se as propriedades retornas foram iguais 
		 * as que eu passei no construtor do meu método de teste. */
		.jsonPath("$[0].nome").isEqualTo(todo.getNome())
		.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
		.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
		.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
		
	}
	
	@Test
	void testCreateTodoFailure() {
		webTestClient
		.post()
		.uri("/todos")
		.bodyValue(
			new Todo("", "", false, 0))
		.exchange()
		.expectStatus().isBadRequest();
		
	}

}
