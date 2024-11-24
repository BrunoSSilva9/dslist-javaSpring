package com.ogarotodevback.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ogarotodevback.dslist.dto.GameListDTO;
import com.ogarotodevback.dslist.entities.GameList;
import com.ogarotodevback.dslist.projections.GameMinProjection;
import com.ogarotodevback.dslist.repositories.GameListRepository;
import com.ogarotodevback.dslist.repositories.GameRepository;
//service que faz logica de negocio das listas de games

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
	
	@Transactional
	public void move(long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
	
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
	
		for(int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
			
		}
	
		
	
	
	
	}
	
	
}
