package com.devspring.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devspring.dslist.dto.GameListDTO;
import com.devspring.dslist.entities.GameList;
import com.devspring.dslist.repositories.GameListRepository;

/**
 * Serviço responsável por fornecer operações relacionadas a listas de jogos.
 */
@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	/**
	 * Obtém uma lista de resumos de listas de jogos.
	 *
	 * @return Lista de objetos GameListDTO representando resumos de listas de jogos.
	 */
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		
		// Transforma uma lista de GameList em uma lista de GameListDTO
		List<GameListDTO> dto = result.stream().map(GameListDTO::new).toList();
		
		return dto;
	}
	
	/**
	 * Obtém detalhes de uma lista de jogos com base no ID fornecido.
	 *
	 * @param id O ID da lista de jogos.
	 * @return Objeto GameListDTO representando detalhes da lista de jogos, ou null se a lista não for encontrada.
	 */
	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		Optional<GameList> result = gameListRepository.findById(id);
		
		// Transforma uma lista de GameList em um objeto GameListDTO
		GameListDTO dto = result.map(GameListDTO::new).orElse(null);
		
		return dto;
	}
}
