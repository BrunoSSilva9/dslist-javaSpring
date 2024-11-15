package com.ogarotodevback.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogarotodevback.dslist.dto.GameListDTO;
import com.ogarotodevback.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists") // define o caminho/rota na api a ser chamado no navegador
public class GameListController {

	// camada controller injeta o componente service que por sua vez injeta o repository/camada
	// de dados

	@Autowired
	private GameListService gameListService;
	
	
	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
}
