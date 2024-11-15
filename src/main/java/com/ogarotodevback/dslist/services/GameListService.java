package com.ogarotodevback.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ogarotodevback.dslist.dto.GameListDTO;
import com.ogarotodevback.dslist.entities.GameList;
import com.ogarotodevback.dslist.repositories.GameListRepository;
import com.ogarotodevback.dslist.repositories.GameRepository;

@Service // registra o componente 'GameService' no sistema
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(GameListDTO::new).toList();
	}
	
	

}
