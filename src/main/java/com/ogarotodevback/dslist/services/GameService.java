package com.ogarotodevback.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogarotodevback.dslist.dto.GameMinDTO;
import com.ogarotodevback.dslist.entities.Game;
import com.ogarotodevback.dslist.repositories.GameRepository;

@Service //registra o componente 'GameService' no sistema
public class GameService {
	
	@Autowired
	private GameRepository gameRepository; //chama o componente 
	
	//metodo que faz uma consulta no banco de dados e retorna todos os games
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

}
