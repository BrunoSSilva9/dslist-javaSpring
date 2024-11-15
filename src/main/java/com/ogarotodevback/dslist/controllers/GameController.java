package com.ogarotodevback.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogarotodevback.dslist.dto.GameDTO;
import com.ogarotodevback.dslist.dto.GameMinDTO;
import com.ogarotodevback.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games") // define o caminho/rota na api a ser chamado no navegador
public class GameController {

	// camada controller injeta o componente service que por sua vez injeta o repository/camada
	// de dados

	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
