package com.ogarotodevback.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogarotodevback.dslist.dto.GameListDTO;
import com.ogarotodevback.dslist.dto.GameMinDTO;
import com.ogarotodevback.dslist.dto.ReplacementDTO;
import com.ogarotodevback.dslist.services.GameListService;
import com.ogarotodevback.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists") // define o caminho/rota na api a ser chamado no navegador, todas as listas de games nesse caso
public class GameListController {

	// camada controller injeta o componente service que por sua vez injeta o repository/camada
	// de dados

	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	//metodo que injecta da camada de servico o metodo que retorna os games de uma lista unica
	@GetMapping(value = "{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	@PostMapping(value = "{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
		
	}
	
}
