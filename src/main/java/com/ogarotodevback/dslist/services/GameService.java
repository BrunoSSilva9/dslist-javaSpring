package com.ogarotodevback.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ogarotodevback.dslist.dto.GameDTO;
import com.ogarotodevback.dslist.dto.GameMinDTO;
import com.ogarotodevback.dslist.entities.Game;
import com.ogarotodevback.dslist.projections.GameMinProjection;
import com.ogarotodevback.dslist.repositories.GameRepository;

import jakarta.transaction.Transactional;

@Service // registra o componente 'GameService' no sistema
public class GameService {

	@Autowired
	private GameRepository gameRepository; // chama o componente que acessa os dados

	@Transactional
	public GameDTO findById(@PathVariable Long listId) {
		 Game result = gameRepository.findById(listId).get();
		 return new GameDTO(result);
	}
	
	// metodo que faz uma consulta no banco de dados e retorna todos os games
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	
	//retorna os games de uma lista unica
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}

}
