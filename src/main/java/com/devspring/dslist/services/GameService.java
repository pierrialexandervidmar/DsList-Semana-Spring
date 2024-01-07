package com.devspring.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devspring.dslist.dto.GameDTO;
import com.devspring.dslist.dto.GameMinDTO;
import com.devspring.dslist.entities.Game;
import com.devspring.dslist.projections.GameMinProjection;
import com.devspring.dslist.repositories.GameRepository;

/**
 * Serviço responsável por fornecer operações relacionadas a jogos.
 */
@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	/**
	 * Obtém uma lista de resumos de jogos.
	 *
	 * @return Lista de objetos GameMinDTO representando resumos de jogos.
	 */
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		
		// Transforma uma lista de Game em uma lista de GameMinDTO
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		
		return dto;
	}
	
	/**
	 * Obtém detalhes de um jogo com base no ID fornecido.
	 *
	 * @param id O ID do jogo.
	 * @return Objeto GameDTO representando detalhes do jogo, ou null se o jogo não for encontrado.
	 */
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Optional<Game> result = gameRepository.findById(id);
		
		// Transforma um jogo em um objeto GameDTO
		GameDTO dto = result.map(GameDTO::new).orElse(null);
		
		return dto;
	}
	
	/**
	 * Obtém uma lista de resumos de jogos associados a uma lista específica.
	 *
	 * @param listId O ID da lista de jogos.
	 * @return Lista de objetos GameMinDTO representando resumos de jogos associados à lista fornecida.
	 */
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		
		// Transforma uma lista de GameMinProjection em uma lista de GameMinDTO
		List<GameMinDTO> dto = result.stream().map(GameMinDTO::new).toList();
		
		return dto;
	}
}