package com.devspring.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devspring.dslist.dto.GameListDTO;
import com.devspring.dslist.dto.GameMinDTO;
import com.devspring.dslist.services.GameListService;
import com.devspring.dslist.services.GameService;

/**
 * Controller responsável por lidar com operações relacionadas a listas de jogos.
 * Todas as operações são mapeadas para o path "/lists".
 */
@RestController
@RequestMapping(value="/lists")
public class GameListController {
	
	@Autowired
	private GameListService gamelistService;
	
	@Autowired
	private GameService gameService;
	
	/**
	 * Obtém todas as listas de jogos.
	 *
	 * @return ResponseEntity contendo uma lista de objetos GameListDTO, ou status 404 se não houver listas.
	 */
	@GetMapping
	public ResponseEntity<List<GameListDTO>> findAll() {
		 List<GameListDTO> list = gamelistService.findAll();
		 return ResponseEntity.ok().body(list);
	}

	/**
	 * Obtém uma lista de jogos com base no ID da lista fornecido.
	 *
	 * @param id O ID da lista de jogos.
	 * @return ResponseEntity contendo um objeto GameListDTO, ou status 404 se a lista não for encontrada.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<GameListDTO> findById(@PathVariable Long id) {
		GameListDTO gameList = gamelistService.findById(id);
		return ResponseEntity.ok().body(gameList);
	}
	
	/**
	 * Obtém todos os jogos associados a uma lista específica com base no ID da lista fornecido.
	 *
	 * @param listId O ID da lista de jogos.
	 * @return ResponseEntity contendo uma lista de objetos GameMinDTO, ou status 404 se a lista não for encontrada.
	 */
	@GetMapping(value = "/{listId}/games")
	public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId) {
		 List<GameMinDTO> list = gameService.findByList(listId);
		 return ResponseEntity.ok().body(list);
	}
}
